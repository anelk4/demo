package com.example.demo.services.impl;

import com.example.demo.models.Account;
import com.example.demo.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl {
    @Autowired
    private AccountRepository accountRepository;

    public Account registerNewAccount(Account account) {
        // Here you can add encryption to the password before saving
        return accountRepository.save(account);
    }
}
