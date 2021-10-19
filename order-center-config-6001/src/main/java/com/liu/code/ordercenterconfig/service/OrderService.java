package com.liu.code.ordercenterconfig.service;

public interface OrderService {
    void createOrder(String productName, int num) throws InterruptedException;
}
