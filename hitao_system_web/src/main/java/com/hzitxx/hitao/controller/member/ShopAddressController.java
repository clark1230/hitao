package com.hzitxx.hitao.controller.member;


import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.service.member.IShopAddressService;
import com.hzitxx.hitao.system.pojo.member.ShopAddress;
import com.hzitxx.hitao.util.LayuiEntity;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
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
@RestController
@RequestMapping("/shopAddress")
//@Api(value = "收货地址Controller",tags = "收货地址控制器")
public class ShopAddressController  {

    @Autowired
    private IShopAddressService shopAddressService;


    /**
     * 分页
     * @return
     */
//    @ApiOperation(value = "获取收货地址信息",notes = "获取收货地址信息")
    //@ApiImplicitParams(@ApiImplicitParam(value = "page",name = "第几页",required = true,paramType = "query",dataType = "int"))
    @GetMapping(value="shopAddressAjax")
    @ResponseBody
    public LayuiEntity<ShopAddress> shopAddressAjax(@RequestParam(value = "page",defaultValue = "1") int page,
                                                    @RequestParam(value = "limit",defaultValue = "20") int  limit,
                                                    String searchParam,String searchValue){
        Map<String,Object>  map = new HashMap<>();
        if(StringUtils.isNotBlank(searchParam) && StringUtils.isNotBlank(searchValue)){
            map.put(searchParam,searchValue);
        }
        LayuiEntity<ShopAddress> layuiEntity = shopAddressService.page(page,limit,map);
        return layuiEntity;
    }


    /**
     * 处理添加表单
     * @param
     * @return
     */
    //@ApiOperation(value = "添加收货地址")
    @PostMapping(value = "addShopAddress")
    public ServerResponse addShopAddress(ShopAddress shopAddress, Model model){
       return shopAddressService.addShopAddressSelective(shopAddress);
    }

    /**
     * 根据id查询数据
     * @param id
     * @return
     */
    @GetMapping("findOne")
    public ServerResponse findOne(@RequestParam("id") int id){
        return  this.shopAddressService.findOne(id);
    }

    /**
     * 处理修改数据表单提交
     * @return
     */
    @PostMapping("editShopAddress")
    public ServerResponse editShopAddress(ShopAddress shopAddress,Model model){
        return shopAddressService.updateSelectiveById(shopAddress);
    }

    /**
    * 根据id批量删除数据
    * @param ids
    * @return
    */
    @GetMapping("deleteByIds")
    public ServerResponse deleteByIds(String[] ids){
        return shopAddressService.deleteByIds(ids);
    }
}
