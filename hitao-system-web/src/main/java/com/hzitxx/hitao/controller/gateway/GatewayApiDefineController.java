package com.hzitxx.hitao.controller.gateway;


import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.service.gateway.IGatewayApiDefineService;
import com.hzitxx.hitao.system.pojo.GatewayApiDefine;
import com.hzitxx.hitao.util.LayuiEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xianyaoji
 * @since 2018-06-07
 */
@Api(value = "网关Controller",tags = "{动态网关管理接口}")
@RestController
@RequestMapping("/gatewayApiDefine")
public class GatewayApiDefineController  {

    @Autowired(required = false)
    private IGatewayApiDefineService gatewayApiDefineService;


    /**
     * 分页
     * @return
     */
    @ApiOperation(value = "获取网关分页数据",tags = "showData", notes = "获取网关分页数据")
    @GetMapping(value="gatewayApiDefineAjax")
    public ServerResponse<LayuiEntity<GatewayApiDefine>> gatewayApiDefineAjax(@RequestParam(value = "page",defaultValue = "1") int page,
                                               @RequestParam(value = "limit",defaultValue = "20") int  limit, String value){
        Map<String,Object>  map = new HashMap<>();
        return gatewayApiDefineService.page(page,limit,map);
    }


    /**
     * 处理添加表单
     * @param
     * @return
     */
    @ApiOperation(value = "添加网关",tags = "save", notes = "添加网关信息")
    @PostMapping(value = "/addGatewayApiDefine")
    public ServerResponse addGatewayApiDefine(@RequestBody  GatewayApiDefine gatewayApiDefine){
        System.out.println(gatewayApiDefine);
        return gatewayApiDefineService.addGatewayApiDefineSelective(gatewayApiDefine);
    }


    /**
     * 处理修改数据表单提交
     * @return
     */
    @ApiOperation(value = "编辑网关",tags = "update", notes = "编辑网关信息")
    @PostMapping("/editGatewayApiDefine")
    public ServerResponse editGatewayApiDefine(@RequestBody  GatewayApiDefine gatewayApiDefine){
        return gatewayApiDefineService.updateSelectiveById(gatewayApiDefine);
    }

    /**
    * 根据id批量删除数据
    * @param ids
    * @return
    */
    @ApiOperation(value = "批量删除网关",tags = "deleteBatch", notes = "物理批量删除网关信息")
    @GetMapping("/deleteByIds")
    public ServerResponse deleteByIds(String[] ids){
        return gatewayApiDefineService.deleteByIds(ids);
    }

    /**
     * 根据id查询网关信息
     * @param id
     * @return
     */
    @ApiOperation(value = "获取网关",tags = "findOne", notes = "获取网关信息")
    @GetMapping("/findOne")
    public ServerResponse findOne(Integer id){
        return this.gatewayApiDefineService.findOne(id);
    }


    /**
     * 获取网关信息
     * @param enabled
     * @return
     */
    @ApiOperation(value = "获取可用网关",tags = "searchGatewayApi", notes = "获取可用网关")
    @GetMapping("/searchGatewayApi")
    public ServerResponse<List<GatewayApiDefine>> searchGatewayApi(@RequestParam("enabled") Integer enabled){
        Map<String,Object> paramsMap = new HashMap<>();
        paramsMap.put("enabled",enabled);
        return this.gatewayApiDefineService.searchGatewayApiDefine(paramsMap);
    }
}
