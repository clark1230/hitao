package com.hzitxx.hitao.controller.gateway;


import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.service.gateway.IGatewayApiDefineService;
import com.hzitxx.hitao.system.pojo.GatewayApiDefine;
import com.hzitxx.hitao.util.LayuiEntity;
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
@RestController
@RequestMapping("/gatewayApiDefine")
public class GatewayApiDefineController  {

    @Autowired(required = false)
    private IGatewayApiDefineService gatewayApiDefineService;


    /**
     * 分页
     * @return
     */
    @GetMapping(value="gatewayApiDefineAjax")
    @ResponseBody
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
    @PostMapping(value = "addGatewayApiDefine")
    public ServerResponse addGatewayApiDefine(@RequestBody  GatewayApiDefine gatewayApiDefine){
        System.out.println(gatewayApiDefine);
        return gatewayApiDefineService.addGatewayApiDefineSelective(gatewayApiDefine);
    }


    /**
     * 处理修改数据表单提交
     * @return
     */
    @PostMapping("editGatewayApiDefine")
    public ServerResponse editGatewayApiDefine(@RequestBody  GatewayApiDefine gatewayApiDefine){
        return gatewayApiDefineService.updateSelectiveById(gatewayApiDefine);
    }

    /**
    * 根据id批量删除数据
    * @param ids
    * @return
    */
    @GetMapping("deleteByIds")
    public ServerResponse deleteByIds(String[] ids){
        return gatewayApiDefineService.deleteByIds(ids);
    }

    /**
     * 根据id查询网关信息
     * @param id
     * @return
     */
    @GetMapping("/findOne")
    public ServerResponse findOne(Integer id){
        return this.gatewayApiDefineService.findOne(id);
    }


    /**
     * 获取网关信息
     * @param enabled
     * @return
     */
    @GetMapping("/searchGatewayApi")
    public ServerResponse<List<GatewayApiDefine>> searchGatewayApi(@RequestParam("enabled") Integer enabled){
        Map<String,Object> paramsMap = new HashMap<>();
        paramsMap.put("enabled",enabled);
        return this.gatewayApiDefineService.searchGatewayApiDefine(paramsMap);
    }
}
