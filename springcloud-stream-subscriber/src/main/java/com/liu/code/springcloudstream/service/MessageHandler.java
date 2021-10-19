package com.liu.code.springcloudstream.service;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;

@EnableBinding(Sink.class)
public class MessageHandler {

    // Spring Cloud Stream consumer API
    // 和rabbitmq springboot starter的使用方式非常像
    @StreamListener(Sink.INPUT)
    public void handle(Message<String> message) {
        System.out.println("received: " + message.getPayload());
    }
}
