package com.liu.code.ordercenterconfig.controller;

import com.liu.code.ordercenterconfig.service.OrderService;
import com.liu.code.ordercenterconfig.service.WmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
// Controller上使用该注解实现动态刷新，可以在线动态修改配置文件而不用重启服务
@RefreshScope
public class OrderController {
    @Autowired
    private WmsService wmsService;
    @Autowired
    private OrderService orderService;

    @Value("${order.env}")
    private String configVar;
    @Value("${order.common}")
    private String configCommon;

    @GetMapping("/test/wms")
    public String testWmsService() {
        System.out.println("tested");
        return wmsService.test();
    }

    @GetMapping("/test/config")
    public void testConfig() {
        System.out.println(configVar);
        System.out.println(configCommon);
    }

    @GetMapping("/do/{name}/{number}")
    public String doOrder(@PathVariable String name, @PathVariable int number) throws InterruptedException {
        orderService.createOrder(name, number);
        return "order successful!";
    }
}
