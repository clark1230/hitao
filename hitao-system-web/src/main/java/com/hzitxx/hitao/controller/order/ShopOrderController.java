package com.hzitxx.hitao.controller.order;

import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.service.order.IShopOrderService;
import com.hzitxx.hitao.system.pojo.order.ShopOrder;
import com.hzitxx.hitao.util.LayuiEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

;

@RestController
@RequestMapping("/shopOrder")
public class ShopOrderController {
    @Autowired
    private IShopOrderService orderService;

    /**
     * 获取订单信息
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/showData")
    public ServerResponse<LayuiEntity<ShopOrder>> showData(@RequestParam(value = "page",defaultValue = "1") Integer page,
                                                           @RequestParam(value = "limit",defaultValue = "10") Integer limit) {
        return orderService.page(page,limit,null);
    }
}
