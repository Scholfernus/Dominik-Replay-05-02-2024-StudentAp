package com.example.student.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class AuthController {


    @GetMapping("/login")
    public String getLogin() {
        return "auth/login";
    }
}
