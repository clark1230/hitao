package com.hzitxx.hitao.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.Verification;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Jwt 工具类
 */
public class JwtTokenUtil {
    // 过期时间120分钟
    private static final long EXPIRE_TIME = 2*60*60*1000;
    /**
     * 秘钥
     */
    private static  String secret = "c083da1c-8865-4b09-95a9-0364d4a54e7c";

    /**
     * 生成token
     * @param username 业务参数  用户名
     * @param email  业务参数   邮箱
     * @return  token
     * @throws UnsupportedEncodingException
     */
    public static String createToken(String username,String email) throws UnsupportedEncodingException {
        Map<String,Object> header = new HashMap<String,Object>();
        //头信息指定了JWT使用的签名算法
        header.put("type","jwt");
        header.put("alg","HS256");// HS256 表示使用了HMAC-SHA256 算法
        long currentTime = System.currentTimeMillis();
        long expireTime = currentTime + 7200*1000;// 2个小时后超时
        String token = JWT.create().withHeader(header)
                .withClaim("username",username)
                .withClaim("email",email)
                .withIssuedAt(new Date(currentTime))  //签发时间
                .withExpiresAt(new Date(expireTime))  ////过期时间
                .withJWTId("df046d05-8948-4c08-8506-988cc72e057e")  //唯一的身份，主要作为一次性token，从而避免重放攻击
                .sign(Algorithm.HMAC256(secret));   //加密

        return token;
    }

    /**
     * 解析token
     * @param token
     * @return  解析结果
     */
    public static Map<String,Claim> parseToken(String token) throws UnsupportedEncodingException {
        Verification verification = JWT.require(Algorithm.HMAC256(secret));
        JWTVerifier verifier = verification.build();
        DecodedJWT decodedJWT= null;
        try{
            decodedJWT = verifier.verify(token);//验证token
        }catch (Exception e){
            return null;
        }
        return decodedJWT.getClaims();
    }

    /**
     * 校验token是否正确
     * @param token 密钥
     * @param secret 用户的密码
     * @return 是否正确
     */
    public static boolean verify(String token, String username,String userId, String secret) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withClaim("username", username)
                    .withClaim("userId",userId)
                    .build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    /**
     * 生成签名,2小时后过期
     * @param username 用户名
     * @param secret 用户的密码
     * @return 加密的token
     */
    public static String sign(String username,String userId, String secret) {
        try {
            Date date = new Date(System.currentTimeMillis()+EXPIRE_TIME);
            Algorithm algorithm = Algorithm.HMAC256(secret);
            Map<String,Object> header = new HashMap<String,Object>();
            //头信息指定了JWT使用的签名算法
            header.put("type","jwt");
            header.put("alg","HS256");// HS256 表示使用了HMAC-SHA256 算法
            // 附带username信息
            return JWT.create().withHeader(header)
                    .withClaim("userId",userId)
                    .withClaim("username", username)
                    .withExpiresAt(date)
                    .sign(algorithm);
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    /**
     * 用户名
     * @return
     */
    public static  String getUser(String token) {
        DecodedJWT decodedJWT=  JWT.decode(token);;
        return decodedJWT.getClaim("username").asString();
    }

    /**
     * 获取用户编号
     * @param token
     * @return
     */
    public static  String getUserId(String token){
        DecodedJWT decodedJWT = JWT.decode(token);
        return decodedJWT.getClaim("userId").asString();
    }
}
