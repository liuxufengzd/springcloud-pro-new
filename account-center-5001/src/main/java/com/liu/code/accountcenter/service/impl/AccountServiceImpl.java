package com.liu.code.accountcenter.service.impl;

import com.liu.code.accountcenter.mapper.AccountMapper;
import com.liu.code.accountcenter.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountMapper accountMapper;

    @Override
    public void balanceChange(String userName, double money) {
        accountMapper.balanceChange(userName, money);
        System.out.println("account:" + userName + " money:" + money);
    }
}
