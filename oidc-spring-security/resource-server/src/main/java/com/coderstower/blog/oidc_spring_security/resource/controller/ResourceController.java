package com.coderstower.blog.oidc_spring_security.resource.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ResourceController {

    @GetMapping("whoarethere")
    public List<String> whoAreThere() {
        return Arrays.asList("Daniel", "Pedro", "Juan");
    }
}
