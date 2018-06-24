package com.hzitxx.hitao.controller;

import com.hzitxx.hitao.sender.RabbitmqSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RefreshScope  //允许动态刷新配置
@Controller
public class EventController {

    @Autowired
    private RabbitmqSender sender;

    @GetMapping(value = "publish")
    @ResponseBody
    public Object publish(){
        sender.sendMessage("哈哈,逗比!");
        return "event published";
    }



}
