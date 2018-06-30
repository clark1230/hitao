package com.hzitxx.hitao.controller.member;


import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.service.member.IShopAreaService;
import com.hzitxx.hitao.system.pojo.member.ShopArea;
import com.hzitxx.hitao.util.LayuiEntity;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
/**
 * <p>
 * 地区表 前端控制器
 * </p>
 *
 * @author xianyaoji
 * @since 2018-04-24
 */
@RestController
@RequestMapping("/shopArea")
//@Api(value = "区域Controller",tags = "区域控制器")
public class ShopAreaController  {
    @Autowired
    private IShopAreaService shopAreaService;

    /**
     * 分页
     * @return
     */
//    @ApiOperation(value = "获取区域信息",notes = "获取区域信息")
    @GetMapping(value="shopAreaAjax")
    @ResponseBody
    public LayuiEntity<ShopArea> shopAreaAjax(@RequestParam(value = "page",defaultValue = "1") int page,
                                              @RequestParam(value = "limit",defaultValue = "20") int  limit,
                                              String searchParam,String searchValue){
        Map<String,Object>  map = new HashMap<>();
        if(StringUtils.isNotBlank(searchParam) && StringUtils.isNotBlank(searchValue)){
            map.put(searchParam,searchValue);
        }
        LayuiEntity<ShopArea> layuiEntity = shopAreaService.page(page,limit,map);
        return layuiEntity;
    }



    /**
     * 处理添加表单
     * @param
     * @return
     */
//    @ApiOperation(value = "添加区域信息",notes = "添加区域信息")
    @PostMapping(value = "addShopArea")
    public ServerResponse addShopArea(ShopArea shopArea, Model model){
        shopArea.setCreatedTime(new Date());
        return shopAreaService.addShopAreaSelective(shopArea);
    }

    /**
     * 根据id查询数据
     * @param areaId
     * @return
     */
//    @ApiOperation(value="根据areaId获取区域信息",notes = "根据areaId获取区域信息")
    @GetMapping(value = "findOne")
    public ServerResponse findOne(@RequestParam("areaId") int areaId){
        return  shopAreaService.findOne(areaId);
    }

    /**
     * 处理修改数据表单提交
     * @return
     */
//    @ApiOperation(value = "编辑区域信息",notes = "编辑区域信息")
    @PostMapping("editShopArea")
    public ServerResponse editShopArea(ShopArea shopArea,Model model){
        shopArea.setUpdatedTime(new Date());
        return shopAreaService.updateSelectiveById(shopArea);
    }

    /**
    * 根据id批量删除数据
    * @param ids
    * @return
    */
//    @ApiOperation(value = "批量删除区域信息",notes = "批量删除区域信息")
    @GetMapping("deleteByIds")
    public ServerResponse deleteByIds(String[] ids){
        return shopAreaService.deleteByIds(ids);
    }
}
