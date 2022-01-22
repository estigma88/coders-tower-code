package com.coderstower.blog.springobervability;

import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpProtocolBuilder;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.http;

public class CustomersSimulation extends Simulation {
  HttpProtocolBuilder httpProtocol = http
          .baseUrl(
                  "http://localhost:8080");

  ScenarioBuilder scn = scenario("Constant requests")
          .exec(http("request_1")
                  .get("/customers"))
          .exec(http("request_2")
                  .get("/customers/transform"));

  {
    setUp(scn.injectClosed(rampConcurrentUsers(5).to(100).during(160))
            .protocols(httpProtocol));
  }
}
