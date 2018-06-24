package com.hzitxx.hitao.sender;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface Sender {
    String OUTPUT= "output";

    /**
     * 输出
     * @return
     */
    @Output(Sender.OUTPUT)
    MessageChannel output();
}
