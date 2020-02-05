package com.coderstower.blog.oidc_spring_security.resource.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ResourceController {

    @GetMapping("whoarethere")
    public List<String> whoAreThere(@AuthenticationPrincipal Jwt principal) {
        return Arrays.asList("Daniel", "Pedro", "Juan", "Jwt: " + principal.getClaims());
    }
}
