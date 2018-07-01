package com.hzitxx.hitao.rpc;

import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.system.pojo.permission.ShopAdmin;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("authentication-service")
public interface AccountService {
    /**
     * 后台系统登陆
     * @param shopAdmin
     * @return
     */
    @RequestMapping(value = "/account/login",method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ServerResponse login(@RequestBody ShopAdmin shopAdmin);
}
