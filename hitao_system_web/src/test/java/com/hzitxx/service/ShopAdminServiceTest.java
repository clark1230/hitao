package com.hzitxx.service;

import com.hzitxx.hitao.HitaoSystem;
import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.service.product.IShopGoodsService;
import com.hzitxx.hitao.system.pojo.product.ShopGoods;
import com.hzitxx.hitao.util.LayuiEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = HitaoSystem.class)
public class ShopAdminServiceTest {
    @Autowired
    private IShopGoodsService iShopGoodsService;

    @Test
    public void test() {
        ServerResponse<LayuiEntity<ShopGoods>> serverResponse = iShopGoodsService.page(1,2,null);
        System.out.println(serverResponse.getData().getData().size());
    }
}
