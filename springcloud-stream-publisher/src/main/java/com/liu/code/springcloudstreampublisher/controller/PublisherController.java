package com.liu.code.springcloudstreampublisher.controller;

import com.liu.code.springcloudstreampublisher.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublisherController {
    @Autowired
    private PublisherService publisherService;

    @GetMapping("/send/{message}")
    public void sendMsg(@PathVariable String message){
        publisherService.send(message);
    }
}
