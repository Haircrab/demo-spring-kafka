package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin()
public class HelloWorldController {
    @Autowired
    UserDetailsService userDetailsService;

    @RequestMapping({"/hello"})
    public String hello() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        return name;
    }

}
