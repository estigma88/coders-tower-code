package com.coderstower.blog.a_case_integration_tests.application.usecase;

import com.coderstower.blog.a_case_integration_tests.application.MockedEdgesConfig;
import com.coderstower.blog.a_case_integration_tests.extesion.ITestHandler;
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;


public class UseCaseTest extends MockedEdgesConfig {

    @Test
    public void publishNextPostSuccessful(WireMockRuntimeInfo wireMockRuntimeInfo, ITestHandler iTestHandler) {
        iTestHandler.loadWiremockMocks(wireMockRuntimeInfo, "testcases/usecase/wiremock/");

        var response = given().
                port(port).
                post("/posts/group1/next").
                then().
                statusCode(200).
                extract()
                .body()
                .asString();

        iTestHandler.validateJSONResponse("testcases/usecase/response.json", response);
    }
}
