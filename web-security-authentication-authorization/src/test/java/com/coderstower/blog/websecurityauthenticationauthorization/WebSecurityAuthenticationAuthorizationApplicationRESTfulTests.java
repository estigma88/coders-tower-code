package com.coderstower.blog.websecurityauthenticationauthorization;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class WebSecurityAuthenticationAuthorizationApplicationRESTfulTests {
  private final RestTemplate restTemplate = new RestTemplate();

  @Test
  void contextLoads() {
  }

  @Test
  public void loveYou_unknownUser_reject() {
    HttpHeaders headers = new HttpHeaders();
    headers.setBasicAuth("ex-boyfriend", "123");
    HttpEntity<String> httpEntity = new HttpEntity<>(
            headers);

    Assertions.assertThrows(
            HttpClientErrorException.Unauthorized.class, () -> {
              restTemplate
                      .exchange("http://localhost:8080/love-you",
                              HttpMethod.GET, httpEntity,
                              String.class);
    });
  }


  @Test
  public void loveYou_userJohn_accept() {
    HttpHeaders headers = new HttpHeaders();
    headers.setBasicAuth("john", "honey");
    HttpEntity<String> httpEntity = new HttpEntity<>(
            headers);

    ResponseEntity<String> response = restTemplate
            .exchange("http://localhost:8080/love-you",
                    HttpMethod.GET, httpEntity,
                    String.class);

    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(response.getBody()).isEqualTo("Love you too");
  }

  @Test
  public void canMeetYourParents_userJohn_cannot() {
    HttpHeaders headers = new HttpHeaders();
    headers.setBasicAuth("john", "honey");
    HttpEntity<String> httpEntity = new HttpEntity<>(
            headers);

    Assertions.assertThrows(
            HttpClientErrorException.Forbidden.class, () -> {
              restTemplate
                      .exchange("http://localhost:8080/can-meet-your-parents",
                              HttpMethod.GET, httpEntity,
                              String.class);
            });
  }
}
