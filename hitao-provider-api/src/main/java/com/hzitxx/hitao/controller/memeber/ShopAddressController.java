package com.hzitxx.hitao.controller.memeber;

import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.front.member.ShopAddress;
import com.hzitxx.hitao.rpc.member.ShopAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shopAddress")
public class ShopAddressController {

    @Autowired(required = false)
    private ShopAddressService shopAddressService;

    /**
     * 添加收货地址
     * @param shopAddress
     * @return
     */
    @PostMapping("/addShopAddress")
    public ServerResponse addShopAddress(@RequestBody  ShopAddress shopAddress){
        return this.shopAddressService.addShopAddress(shopAddress);
    }

    /**
     * 获取收货地址
     * @return
     */
    @GetMapping("/list")
    public ServerResponse list(@RequestParam("memberId") int memberId){
        return this.shopAddressService.list(memberId);
    }

    /**
     * 删除收货地址
     * @param id
     * @return
     */
    @DeleteMapping("/delete")
    public ServerResponse delete(@RequestParam("id") int id){
        return  this.shopAddressService.delete(id);
    }

    /**
     * 获取收货地址详情
     * @param id
     * @return
     */
    @GetMapping("/detail")
    public ServerResponse detail(@RequestParam("id") int id){
        return this.shopAddressService.detail(id);
    }

    /**
     * 编辑收货地址
     * @param shopAddress
     * @return
     */
    @PostMapping("/updateShopAddress")
    public ServerResponse updateShopAddress(@RequestBody ShopAddress shopAddress){
        return  this.shopAddressService.updateShopAddress(shopAddress);
    }

    /**
     * 获取会员默认的收货地址
     * @return
     */
    @GetMapping("/getDefaultAddress")
    public ServerResponse getDefaultAddress(){
        return  this.shopAddressService.getDefaultAddres();
    }
}
