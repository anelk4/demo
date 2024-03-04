package com.example.demo.controllers;

import com.example.demo.models.Account;
import com.example.demo.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegisterController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/register")
    public String getRegistrationForm() {
        return "register";
    }


    @PostMapping("/register")
    public String registerAccount(@ModelAttribute Account account) {
        accountService.registerNewAccount(account);
        return "redirect:/login"; // Перенаправление на страницу входа после регистрации
    }

}
