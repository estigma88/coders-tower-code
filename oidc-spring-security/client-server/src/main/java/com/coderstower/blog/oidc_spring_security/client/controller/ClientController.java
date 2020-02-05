package com.coderstower.blog.oidc_spring_security.client.controller;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class ClientController {
    private final RestTemplate restTemplate;

    public ClientController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("ping")
    public String ping(){
        return "Pong!!";
    }

    @GetMapping("/oidc-principal")
    public OidcUser getOidcUserPrincipal(
            @AuthenticationPrincipal OidcUser principal) {
        return principal;
    }

    @GetMapping("/auth2-principal")
    public OAuth2AuthorizedClient getAuth2UserPrincipal(
            @RegisteredOAuth2AuthorizedClient("google") OAuth2AuthorizedClient authorizedClient) {
        return authorizedClient;
    }

    @GetMapping("areyouthere")
    public String areYouThere(@AuthenticationPrincipal OidcUser principal, @RegisteredOAuth2AuthorizedClient("google") OAuth2AuthorizedClient authorizedClient){
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(principal.getIdToken().getTokenValue());
        //headers.setBearerAuth(authorizedClient.getAccessToken().getTokenValue());

        HttpEntity<Void> entity = new HttpEntity<>(null, headers);

        ResponseEntity<List<String>> responseEntity = restTemplate.exchange("http://localhost:8081/whoarethere", HttpMethod.GET,  entity, new ParameterizedTypeReference<List<String>>(){});

        return "Yes, we are " + responseEntity.getBody();
    }
}
