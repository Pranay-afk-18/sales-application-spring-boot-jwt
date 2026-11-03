package com.example.sales.appli.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.sales.appli.Entity.SalesManLogin;
import com.example.sales.appli.Service.SalesManService;
import com.example.sales.appli.Service.JwtService;

@RestController
public class SalesController {

    @Autowired
    SalesManService salesManService;

    @Autowired
    JwtService jwtService;

    @PostMapping("/register")
    public String register(@RequestBody SalesManLogin salesManLogin) {
        salesManService.addlogin(salesManLogin);
        return "Registration successful";
    }

    @PostMapping("/login")
    public String login(@RequestBody SalesManLogin salesManLogin) {

        boolean isValid = salesManService.verifyLogin(
                salesManLogin.getSalesName(),
                salesManLogin.getPassword()
        );

        if (isValid) {
            return jwtService.generateToken(
                    salesManLogin.getSalesName()
            );
        }

        return "Invalid sales name or password";
    }
}