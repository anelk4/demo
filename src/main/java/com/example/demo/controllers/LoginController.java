// src/main/java/com/example/demo/controllers/LoginController.java
package com.example.demo.controllers;
// ожидает базу данных
import com.example.demo.models.Account;
import com.example.demo.services.impl.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

 //   @Autowired
   // private LoginServiceImpl loginService;


        @GetMapping("/login")
        public String login() {
            return "login"; // имя HTML файла для страницы входа
        }

    @GetMapping("/profile")
    public String profile() {
        return "profile"; // имя HTML файла для страницы профиля
    }
}
