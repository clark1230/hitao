package com.hzitxx.hitao.controller;


import com.hzitxx.hitao.service.IShopPermissionRouteService;
import com.hzitxx.hitao.system.pojo.permission.ShopPermissionRoute;
import com.hzitxx.hitao.utils.LayuiEntity;
import com.hzitxx.hitao.utils.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xianyaoji
 * @since 2018-06-21
 */
@RestController
@RequestMapping("/shopPermissionRoute")
public class ShopPermissionRouteController  {
    @Autowired
    private IShopPermissionRouteService shopPermissionRouteService;

    /**
     * 分页
     * @return
     */
    @GetMapping(value="shopPermissionRouteAjax")
    @ResponseBody
    public LayuiEntity<ShopPermissionRoute> shopPermissionRouteAjax(@RequestParam(value = "page",defaultValue = "1") int page,
                                                                    @RequestParam(value = "limit",defaultValue = "20") int  limit, String value){
        Map<String,Object>  map = new HashMap<>();
        LayuiEntity<ShopPermissionRoute> layuiEntity = shopPermissionRouteService.page(page,limit,map);
        return layuiEntity;
    }

    /**
     * 查询信息
     * @return
     */
    @GetMapping("/find")
    public ServerResponse find(){
        return this.shopPermissionRouteService.searchShopPermissionRoute(null);
    }


    /**
     * 处理添加表单
     * @param
     * @return
     */
    @PostMapping(value = "addShopPermissionRoute")
    public String addShopPermissionRoute(ShopPermissionRoute shopPermissionRoute,Model model){
        int result = shopPermissionRouteService.addShopPermissionRouteSelective(shopPermissionRoute);
        String view ;
        if(result!=1){
            view = "shopPermissionRoute/addShopPermissionRoute";
            model.addAttribute("error","添加失败!");
        }else{
            view = "redirect:shopPermissionRoute";
        }
        return view;
    }


    /**
     * 处理修改数据表单提交
     * @return
     */
    @PostMapping("editShopPermissionRoute")
    public String editShopPermissionRoute(ShopPermissionRoute shopPermissionRoute,Model model){
        String view;
        int result = shopPermissionRouteService.updateSelectiveById(shopPermissionRoute);
        if(result!=1){
            view = "product/shopPermissionRoute/editShopPermissionRoute";
        }else{
            view = "redirect:shopPermissionRoute";
        }
        return view;
    }


}
