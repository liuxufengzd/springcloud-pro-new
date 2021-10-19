package com.liu.code.accountcenter.controller;

import com.liu.code.accountcenter.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/balance/dec")
    public String balanceDec(@RequestParam("name") String name, @RequestParam("money") double money) {
        accountService.balanceChange(name, money);
        return "balance has decrease!";
    }
}
