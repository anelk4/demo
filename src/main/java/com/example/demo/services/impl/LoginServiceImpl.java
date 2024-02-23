// src/main/java/com/example/demo/services/LoginService.java
// ожидает базу данных
package com.example.demo.services.impl;

import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl {
    // Temporary hardcoded credentials
    private final String hardcodedUsername = "username";
    private final String hardcodedPassword = "password";

    public boolean authenticate(String username, String password) {
        // This will later be replaced with database authentication
        return hardcodedUsername.equals(username) && hardcodedPassword.equals(password);
    }
}
