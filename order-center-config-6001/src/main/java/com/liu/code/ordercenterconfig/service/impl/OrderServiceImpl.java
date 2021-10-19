package com.liu.code.ordercenterconfig.service.impl;

import com.liu.code.ordercenterconfig.mapper.OrderMapper;
import com.liu.code.ordercenterconfig.service.AccountService;
import com.liu.code.ordercenterconfig.service.OrderService;
import com.liu.code.ordercenterconfig.service.WmsService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private AccountService accountService;
    @Autowired
    private WmsService wmsService;

    @Override
    // 统一的事务XID
    // TM (Transaction Manager) 事务发起，发送决议提交或回滚给TC（seata server）,TC综合分析后命令RM执行具体的数据库处理
    // 由于行锁的存在，效率降低，所以很多业务不用分布式事务
    // rollbackFor : 如果方法内出现Exception.class才会回滚
    @GlobalTransactional(name = "myOrder", rollbackFor = Exception.class)
    public void createOrder(String productName, int num) throws InterruptedException {
        orderMapper.createOrder(productName, num);
        System.out.println(wmsService.stockDec(productName, num));
        System.out.println(accountService.balanceDec("lxf", num * 1000));
        System.out.println("order: " + productName + " has been created for number of " + num);
//        int index = 1/0;
    }
}
