package com.coderstower.blog.virtual_threads;

import io.gatling.javaapi.core.CoreDsl;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpDsl;
import io.gatling.javaapi.http.HttpProtocolBuilder;

import static io.gatling.javaapi.core.OpenInjectionStep.atOnceUsers;
import static io.gatling.javaapi.http.HttpDsl.http;

public class RequestOneSimulation extends Simulation {
    private final HttpProtocolBuilder httpConf =
            http.baseUrl("http://localhost:8080/");

    {
        setUp(
                CoreDsl
                        .scenario("Render Widget For Customer: $customerId")
                        .exec(
                                HttpDsl
                                        .http("Render Widget")
                                        .get("/files")
                                        .queryParam("path", "/home/danielpelaez/Downloads/Candidate Packet_hireworks x Kedify 2025.pdf")
                                        .check(
                                                HttpDsl.status().shouldBe(200)
                                        )
                                )
                        .injectOpen(
                                atOnceUsers(1)
                        )
        ).protocols(httpConf);
    }
}
