package com.liu.code.springcloudstreampublisher.service.impl;

import com.liu.code.springcloudstreampublisher.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

// 硬编码中使用统一的Spring Cloud Stream API完成Source->Channel / Sink->Channel,通过修改配置文件可以非常简单地切换不同MQ，最大限度解耦
@EnableBinding(Source.class) //定义消息的推送管道 Source->Channel
public class PublisherServiceImpl implements PublisherService {
    @Autowired
    @Qualifier("output")
    private MessageChannel outbound;

    @Override
    public void send(Object message) {
        outbound.send(MessageBuilder.withPayload(message).build());
        System.out.println("sent...");
    }
}
