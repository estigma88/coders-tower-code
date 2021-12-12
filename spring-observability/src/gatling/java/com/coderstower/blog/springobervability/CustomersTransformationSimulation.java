package com.coderstower.blog.springobervability;

import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpProtocolBuilder;

import static io.gatling.javaapi.core.CoreDsl.atOnceUsers;
import static io.gatling.javaapi.core.CoreDsl.scenario;
import static io.gatling.javaapi.http.HttpDsl.http;

public class CustomersTransformationSimulation extends Simulation {
  HttpProtocolBuilder httpProtocol = http
          .baseUrl(
                  "http://localhost:8080");

  ScenarioBuilder scn = scenario("Scenario Name")
          .exec(http("request_1")
                  .get("/customers/transform"));

  {
    setUp(scn.injectOpen(atOnceUsers(1))
            .protocols(httpProtocol));
  }
}
