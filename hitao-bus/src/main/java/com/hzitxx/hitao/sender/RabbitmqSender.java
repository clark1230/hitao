package com.hzitxx.hitao.sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class RabbitmqSender {
    @Autowired
    private Sender sender;


    /**
     * 发送消息
     * @return
     */
    public String sendMessage(String message){
        System.out.println("发送消息!");
        try{
            sender.output().send(MessageBuilder.withPayload(message).build());
            return  "发送成功!";
        }catch (Exception e){
            return "发送失败!";
        }
    }
}
