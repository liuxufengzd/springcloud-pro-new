package com.liu.code.shipcenter.service.impl;

import com.liu.code.shipcenter.mapper.ShipMapper;
import com.liu.code.shipcenter.service.ShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShipServiceImpl implements ShipService {
    @Autowired
    private ShipMapper shipMapper;

    @Override
    public void insertShip(String productName, int number) {
        shipMapper.insertShip(productName, number);
        System.out.println("ship:" + productName + " number:" + number);
    }
}
