package com.coderstower.blog.oidc_spring_security.client.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ClientController {
    private final RestTemplate restTemplate;

    public ClientController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("ping")
    public String ping() {
        return "Pong!!";
    }

    @GetMapping("/oauth2-principal")
    public OAuth2User getAuth2UserPrincipal(
            @AuthenticationPrincipal OAuth2User oAuth2User) {
        return oAuth2User;
    }

    @GetMapping("/id-token")
    public String getIDToken(
            @AuthenticationPrincipal OidcUser principal) {
        return principal.getIdToken().getTokenValue();
    }

    @GetMapping("go-in-mary-apartment")
    public String goInMaryApartment(@AuthenticationPrincipal OidcUser principal,
                                    @RegisteredOAuth2AuthorizedClient OAuth2AuthorizedClient authorizedClient) {
        HttpHeaders headers = new HttpHeaders();

        //Google uses the ID Token
        headers.setBearerAuth(principal.getIdToken().getTokenValue());

        //Linkedin uses Access Token
        //headers.setBearerAuth(authorizedClient.getAccessToken().getTokenValue());

        HttpEntity<Void> entity = new HttpEntity<>(null, headers);

        ResponseEntity<String> responseEntity = restTemplate.exchange(
                "http://localhost:8081/enter",
                HttpMethod.GET,
                entity,
                String.class);

        return responseEntity.getBody();
    }
}
