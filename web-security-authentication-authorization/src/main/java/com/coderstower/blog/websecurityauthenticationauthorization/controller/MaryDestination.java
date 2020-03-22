package com.coderstower.blog.websecurityauthenticationauthorization.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
public class MaryDestination {
    @GetMapping("love-you")
    @RolesAllowed({"ROLE_BOYFRIEND"})
    public String loveYou(){
        return "love you too";
    }

    @GetMapping("can-meet-your-parents")
    @PreAuthorize("hasRole('ROLE_BOYFRIEND') and hasRole('ROLE_CAN_MEET_PARENTS')")
    public String canMeetYourParents(){
        return "You can";
    }
}
