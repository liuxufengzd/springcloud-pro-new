package com.liu.code.wmscenter.controller;

import com.liu.code.wmscenter.service.ShipService;
import com.liu.code.wmscenter.service.WmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class WmsController {
    @Value("${server.port}")
    private int port;
    @Autowired
    private ShipService shipService;
    @Autowired
    private WmsService wmsService;

    @GetMapping("/test")
    public String testHealthy() {
        System.out.println("tested");
        return "wms-center: healthy -> " + port;
    }

    @PostMapping("/stock/dec")
    public String stockDec(@RequestParam String name, @RequestParam int number) {
        wmsService.stockDec(name, number);
        System.out.println(shipService.callShip(name, number));
        return "stock has decrease!";
    }
}
