package com.hzitxx.hitao.interceptors;

import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.*;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.security.Permission;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Properties;


/**
 * 自定义权限拦截器
 */
@Component
@Intercepts(value={
        @Signature(type=Executor.class,method = "query",
        args={MappedStatement.class,Object.class, RowBounds.class,ResultHandler.class}),
        @Signature(type = Executor.class,method = "query",
        args={MappedStatement.class,Object.class, RowBounds.class, ResultHandler.class, CacheKey.class, BoundSql.class})})
public class PermissionInterceptor implements Interceptor {
    private Logger logger = LoggerFactory.getLogger(Permission.class);

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("拦截!...");
        MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
        Object parameter = invocation.getArgs()[1];
        BoundSql boundSql = mappedStatement.getBoundSql(parameter);
        // 原始查询sql
        String originalSql = boundSql.getSql().trim();
        // 参数
        Object parameterObject = boundSql.getParameterObject();
        // 用户
        String adminId=null;

        if(parameterObject instanceof HashMap){
            try{
                adminId=(String)((HashMap)parameterObject).get("adminId");
            }catch(Exception e){}
        }
        if(adminId!=null){
            //获取角色
            String getRoleSql="SELECT adm.admin_name,rol.role_name FROM shop_admin adm, shop_admin_role adr, shop_role rol" +
                    " WHERE adm.admin_id = adr.admin_id AND adr.role_id = rol.role_id AND adm.admin_id =?";
            String role=null;
            Connection connection = null;
            PreparedStatement countStmt = null;
            ResultSet rs = null;
            try{
                connection = mappedStatement.getConfiguration()
                        .getEnvironment().getDataSource().getConnection();
                countStmt = connection.prepareStatement(getRoleSql);
                countStmt.setString(1, adminId);
                rs = countStmt.executeQuery();
                if (rs.next()) {
                    role=rs.getString(2);
                }
            }catch (Exception e){
                logger.error(e.getMessage());
            }finally {
                if(rs != null){
                    rs.close();
                }
                if(countStmt != null){
                    countStmt.close();
                }
                if(connection != null){
                    connection.close();
                }
            }

            // 总经理  市场经理   部门主管  员工
            if(role!=null){
                if("系统管理员".equalsIgnoreCase(role)) {
                    //查看全部
                }else if(role.equals("风险员")){
                    if(originalSql.toLowerCase().indexOf("admin_id")!=-1){
                        // 查询
                        String usersSql="select a.admin_id from tbldepartment_user " +
                                "a where a.departmentcode=" +
                                "(select b.departmentcode from tbldepartment_user b where b.userid='"+adminId+"')";
                        String riskSql="select a.* from ("+originalSql+")a  " +
                                "where a.user_id in ("+usersSql+")";
                        BoundSql newBoundSql = copyFromBoundSql(mappedStatement,boundSql, riskSql);
                        ParameterMap map=mappedStatement.getParameterMap();
//                        ParameterMapping mapping=new ParameterMapping.Builder(mappedStatement.getConfiguration(), adminId, String.class).build();
//                        map.getParameterMappings().add(mapping);
                        MappedStatement newMs = copyFromMappedStatement(mappedStatement, new BoundSqlSqlSource(newBoundSql),map);
                        invocation.getArgs()[0] = newMs;
                    }
                }else if("部门主管".equalsIgnoreCase(role)){
                    if(originalSql.toLowerCase().indexOf("admin_id")!=-1){
                        String selfSql="select a.* from ("+originalSql+")a  where a.company_id = '"+adminId+"'";
                        BoundSql newBoundSql = copyFromBoundSql(mappedStatement,boundSql, selfSql);
                        ParameterMap map=mappedStatement.getParameterMap();
                        MappedStatement newMs = copyFromMappedStatement(mappedStatement,
                                new BoundSqlSqlSource(newBoundSql),map);
                        invocation.getArgs()[0] = newMs;
                    }
                }else{
                    throw new RuntimeException("角色错误");
                }
            }
        }
        return invocation.proceed();
    }


    public class BoundSqlSqlSource implements SqlSource {
        BoundSql boundSql;
        public BoundSqlSqlSource(BoundSql boundSql) {
            this.boundSql = boundSql;
        }

        public BoundSql getBoundSql(Object parameterObject) {
            return boundSql;
        }
    }

    /**
     * 复制MappedStatement对象
     */
    private MappedStatement copyFromMappedStatement(MappedStatement ms,
                                                    SqlSource newSqlSource,
                                                    ParameterMap parameterMap) {
        MappedStatement.Builder builder = new MappedStatement.Builder(ms.getConfiguration(), ms.getId(),
                newSqlSource, ms.getSqlCommandType());

        builder.resource(ms.getResource());
        builder.fetchSize(ms.getFetchSize());
        builder.statementType(ms.getStatementType());
        builder.keyGenerator(ms.getKeyGenerator());
        // builder.keyProperty(ms.getKeyProperty());
        builder.timeout(ms.getTimeout());
        builder.parameterMap(parameterMap);
        builder.resultMaps(ms.getResultMaps());
        builder.resultSetType(ms.getResultSetType());
        builder.cache(ms.getCache());
        builder.flushCacheRequired(ms.isFlushCacheRequired());
        builder.useCache(ms.isUseCache());

        return builder.build();
    }

    /**
     * 复制BoundSql对象
     */
    private BoundSql copyFromBoundSql(MappedStatement ms, BoundSql boundSql,
                                      String sql) {
        BoundSql newBoundSql = new BoundSql(ms.getConfiguration(), sql,
                boundSql.getParameterMappings(), boundSql.getParameterObject());
        for (ParameterMapping mapping : boundSql.getParameterMappings()) {
            String prop = mapping.getProperty();
            if (boundSql.hasAdditionalParameter(prop)) {
                newBoundSql.setAdditionalParameter(prop, boundSql
                        .getAdditionalParameter(prop));
            }
        }
        return newBoundSql;
    }


    /**
     * 插件
     * @param target
     * @return
     */
    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target,this);
    }

    /**
     *
     * @param properties
     */
    @Override
    public void setProperties(Properties properties) {
        System.out.println(properties);
    }
}
