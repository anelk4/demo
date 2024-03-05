// src/main/java/com/example/demo/controllers/LoginController.java
package com.example.demo.controllers;
// ожидает базу данных
import com.example.demo.services.impl.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @Autowired
    private LoginServiceImpl loginService;

  //  @GetMapping("login")
    //public String login() {
       // return "login";
    //}

    @PostMapping("/login")
    public ModelAndView processLogin(@RequestParam String username, @RequestParam String password) {
        boolean isAuthenticated = loginService.authenticate(username, password);
        if (isAuthenticated) {
            return new ModelAndView("redirect:/profile");
        } else {
            return new ModelAndView("login", "error", "Invalid credentials");
        }
    }
}
