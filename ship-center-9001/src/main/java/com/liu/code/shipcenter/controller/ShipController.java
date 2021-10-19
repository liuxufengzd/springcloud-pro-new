package com.liu.code.shipcenter.controller;

import com.liu.code.shipcenter.service.ShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ShipController {
    @Autowired
    private ShipService shipService;

    @PostMapping("/do")
    public String Shipment(@RequestParam("name") String name, @RequestParam("number") int number) {
        shipService.insertShip(name, number);
        return "Product has been shipped!";
    }

}
