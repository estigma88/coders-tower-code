package com.coderstower.blog.virtual_threads;

import io.gatling.javaapi.core.CoreDsl;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpDsl;
import io.gatling.javaapi.http.HttpProtocolBuilder;

import java.time.Duration;

import static io.gatling.javaapi.core.CoreDsl.incrementUsersPerSec;
import static io.gatling.javaapi.core.OpenInjectionStep.atOnceUsers;
import static io.gatling.javaapi.http.HttpDsl.http;

public class MultipleRequestSimulation extends Simulation {
    private final HttpProtocolBuilder httpConf =
            http.baseUrl("http://localhost:8080/");

    {
        setUp(
                CoreDsl
                        .scenario("Get files")
                        .exec(
                                HttpDsl
                                        .http("Get files")
                                        .get("/files")
                                        .queryParam("path", "/home/danielpelaez/Downloads/Candidate Packet_hireworks x Kedify 2025.pdf")
                                        .check(
                                                HttpDsl.status().shouldBe(200)
                                        )
                                )
                        .injectOpen(
                                incrementUsersPerSec(50)
                                        .times(5)
                                        .eachLevelLasting(Duration.ofSeconds(30))
                                        .separatedByRampsLasting(Duration.ofSeconds(5))
                                        .startingFrom(20)
                                )
        ).protocols(httpConf);
    }
}
