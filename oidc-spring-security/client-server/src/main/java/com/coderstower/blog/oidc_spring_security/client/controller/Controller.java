package com.coderstower.blog.oidc_spring_security.client.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("hello")
    public String hello(){
        return "asfdasfsdaf";
    }
}
