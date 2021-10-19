package com.liu.code.ordercenterconfig.service;

import com.liu.code.ordercenterconfig.service.fallback.WmsServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 类似Mybatis的Mapper注解用法，动态代理实现类,实现类中做负载均衡（整合了Ribbon，Ribbon起到拦截器作用，从注册中心取回
 * service name对应的server ip：port，然后实现负载均衡策略，可以自定义,默认为robin round）
 * OpenFeign可以实现一处定义service接口，模仿调用自己的service一样处处可以调用，符合controller中
 * 面向Service接口编程的习惯和范例，也可以使用 webClient
 * 注意：openfeign的使用必须有注册中心注册该服务,如 nacos
 */
@FeignClient(value = "wms-center",fallback = WmsServiceFallback.class)
public interface WmsService {
    @GetMapping("/wms/test")
    String test();
    @PostMapping("/wms/stock/dec")
    String stockDec(@RequestParam("name") String name, @RequestParam("number") int number);
}
