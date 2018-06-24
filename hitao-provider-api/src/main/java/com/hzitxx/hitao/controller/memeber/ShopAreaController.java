package com.hzitxx.hitao.controller.memeber;

import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.rpc.member.ShopAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shopArea")
public class ShopAreaController {
    @Autowired
    private ShopAreaService shopAreaService;

    @GetMapping("/getShopArea")
    public ServerResponse getShopArea(@RequestParam(value = "parentId",defaultValue = "0")int parentId){
        return this.shopAreaService.getShopArea(parentId);
    }
}
