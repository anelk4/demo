package com.example.demo;

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

  //  @GetMapping("/login")
    //public String showLoginForm() {
      //  return "login";
    //}
    @GetMapping("login")
  public String login() {
      return "login";
  }

    @GetMapping("/profile")
    public String profile() {
        return "profile"; // This should match the name of your HTML file without the extension.
    }

    // Добавьте методы для обработки остальной логики приложения
}
