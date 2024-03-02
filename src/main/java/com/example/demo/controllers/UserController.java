package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/About")
    public String about() {
        return "About";
    }

    @GetMapping("/Admin")
    public String admin() {
        return "Admin";
    }

  //  @GetMapping("/login")
    //public String showLoginForm() {
      //  return "login";
    //}

 //@GetMapping("/profile")
   // public String userProfile() {
     //  return "profile"; // имя HTML файла для страницы профиля пользователя
  //}

    // Добавьте методы для обработки остальной логики приложения
}
