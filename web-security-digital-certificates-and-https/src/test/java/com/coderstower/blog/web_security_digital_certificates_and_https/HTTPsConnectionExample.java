package com.coderstower.blog.web_security_digital_certificates_and_https;

import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.assertj.core.api.Assertions.assertThat;

public class HTTPsConnectionExample {
  @Test
  public void connect_https_error()
          throws IOException, InterruptedException {
    HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_1_1)
            .build();

    HttpRequest httpRequest = HttpRequest.newBuilder()
            .uri(URI.create("https://coderstower.com/"))
            .GET()
            .build();

    HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers
            .ofString());
    System.out.println(httpResponse.body());

    assertThat(httpResponse.statusCode()).isEqualTo(200);
  }
}
