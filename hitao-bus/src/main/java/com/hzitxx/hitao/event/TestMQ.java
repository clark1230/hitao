package com.hzitxx.hitao.event;

import com.hzitxx.hitao.entity.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.utils.SerializationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestMQ {

    @Autowired
    private RabbitTemplate template;

    public void sendMsg(User obj){
        template.convertAndSend("springCloudBus","test2", "hello");
        //template.convertAndSend(obj);

    }
}
