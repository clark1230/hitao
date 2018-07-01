package com.hzitxx.hitao.rpc.member;

import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.front.member.ShopAddress;
import com.hzitxx.hitao.rpc.member.fallback.ShopAddressServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "user-service",fallback = ShopAddressServiceFallback.class)
public interface ShopAddressService {
    /**
     * 添加收货地址
     * @param shopAddress
     * @return
     */
    @RequestMapping(value = "/shopAddress/addShopAddress",method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    ServerResponse addShopAddress(@RequestBody ShopAddress shopAddress);

    /**
     * 获取收货地址
     * @return
     */
    @RequestMapping(value = "/shopAddress/list",method = RequestMethod.GET)
    ServerResponse list(@RequestParam("memberId") int memberId);

    /**
     * 删除收货地址
     * @param id
     * @return
     */
    @RequestMapping(value = "/shopAddress/delete",method = RequestMethod.DELETE)
    ServerResponse delete(@RequestParam("id") int id);

    /**
     * 获取详细收货地址信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/shopAddress/detail",method = RequestMethod.GET)
    ServerResponse detail(@RequestParam("id") int id);

    /**
     * 编辑收货地址信息
     * @param shopAddress
     * @return
     */
    @RequestMapping(value = "/shopAddress/updateShopAddress",method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    ServerResponse updateShopAddress(@RequestBody ShopAddress shopAddress);

    /**
     * 获取用户默认的收货地址
     * @return
     */
    @RequestMapping(value = "/shopAddress/getDefaultAddress",method = RequestMethod.GET)
    ServerResponse getDefaultAddres();
}
