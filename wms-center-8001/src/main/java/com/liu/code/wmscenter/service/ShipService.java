package com.liu.code.wmscenter.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "ship-center")
public interface ShipService {

    @PostMapping("/ship/do")
    String callShip(@RequestParam("name") String name, @RequestParam("number") int number);
}
