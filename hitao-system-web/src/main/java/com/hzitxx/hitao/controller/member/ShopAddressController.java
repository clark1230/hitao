package com.hzitxx.hitao.controller.member;


import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.service.member.IShopAddressService;
import com.hzitxx.hitao.system.pojo.member.ShopAddress;
import com.hzitxx.hitao.util.LayuiEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
/**
 * <p>
 * 买家地址信息表 前端控制器
 * </p>
 *
 * @author xianyaoji
 * @since 2018-04-24
 */
@Api(value = "收货Controller",tags = "{收货信息接口}")
@RestController
@RequestMapping("/shopAddress")
public class ShopAddressController  {

    @Autowired
    private IShopAddressService shopAddressService;


    /**
     * 分页
     * @return
     */
    @ApiOperation(value = "获取分页收货信息",tags = "showData", notes = "获取分页收货信息")
    @GetMapping(value="shopAddressAjax")
    @ResponseBody
    public ServerResponse<LayuiEntity<ShopAddress>> shopAddressAjax(@RequestParam(value = "page",defaultValue = "1") int page,
                                                    @RequestParam(value = "limit",defaultValue = "20") int  limit,
                                                    String searchParam,String searchValue){
        Map<String,Object>  map = new HashMap<>();
        if(StringUtils.isNotBlank(searchParam) && StringUtils.isNotBlank(searchValue)){
            map.put(searchParam,searchValue);
        }
        return shopAddressService.page(page,limit,map);
    }


    /**
     * 处理添加表单
     * @param
     * @return
     */
    /*@ApiOperation(value = "",tags = "showData", notes = "获取分页收货信息")
    @PostMapping(value = "addShopAddress")
    public ServerResponse addShopAddress(ShopAddress shopAddress, Model model){
       return shopAddressService.addShopAddressSelective(shopAddress);
    }*/

    /**
     * 根据id查询数据
     * @param id
     * @return
     */
    @ApiOperation(value = "获取收货信息",tags = "findOne", notes = "获取收货信息")
    @GetMapping("findOne")
    public ServerResponse findOne(@RequestParam("id") int id){
        return  this.shopAddressService.findOne(id);
    }

    /**
     * 处理修改数据表单提交
     * @return
     */
   /* @PostMapping("editShopAddress")
    public ServerResponse editShopAddress(ShopAddress shopAddress,Model model){
        return shopAddressService.updateSelectiveById(shopAddress);
    }*/

    /**
    * 根据id批量删除数据
    * @param ids
    * @return
    */
    /*@GetMapping("deleteByIds")
    public ServerResponse deleteByIds(String[] ids){
        return shopAddressService.deleteByIds(ids);
    }*/
}
