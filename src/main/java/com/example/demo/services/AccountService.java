package com.example.demo.services;

import com.example.demo.models.Account;

public interface AccountService {
    void save(Account account);
    Account findByUsername(String username);
}
