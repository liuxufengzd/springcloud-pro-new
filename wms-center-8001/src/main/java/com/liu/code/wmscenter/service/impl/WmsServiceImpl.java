package com.liu.code.wmscenter.service.impl;

import com.liu.code.wmscenter.mapper.WmsMapper;
import com.liu.code.wmscenter.service.WmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WmsServiceImpl implements WmsService {
    @Autowired
    private WmsMapper wmsMapper;

    @Override
    public void stockDec(String productName, int number) {
        wmsMapper.stockDec(productName, number);
        System.out.println("stock: " + productName + " number: " + number);
    }
}
