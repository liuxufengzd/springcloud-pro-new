package com.liu.code.ordercenterconfig.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "account-center")
public interface AccountService {
    @PostMapping("/account/balance/dec")
    String balanceDec(@RequestParam("name") String name, @RequestParam("money") double money);
}
