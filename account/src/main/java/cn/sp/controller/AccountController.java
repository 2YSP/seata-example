package cn.sp.controller;

import cn.sp.dto.AccountDeductDTO;
import cn.sp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Ship
 * @Description:
 * @Date: Created in 2021/8/23
 */
@RequestMapping("/account")
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/deduct")
    public void deduct(@RequestBody AccountDeductDTO accountDeductDTO){
        accountService.deduct(accountDeductDTO);
    }
}
