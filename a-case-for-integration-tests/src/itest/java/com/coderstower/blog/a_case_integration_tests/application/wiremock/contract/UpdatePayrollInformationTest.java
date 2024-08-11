package com.coderstower.blog.a_case_integration_tests.application.wiremock.contract;

import com.coderstower.blog.a_case_integration_tests.extension.ITestExtension;
import com.coderstower.blog.a_case_integration_tests.extension.ITestHandler;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.test.context.ActiveProfiles;

import java.io.IOException;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@ActiveProfiles("itest")
@AutoConfigureWireMock(stubs = {"classpath:testcases/wiremock/contract/updatePayrrollInformation/mocks"})
@ExtendWith(ITestExtension.class)
public class UpdatePayrollInformationTest {
    @LocalServerPort
    protected Integer port;

    @Test
    public void postPayrollInformation(
            ITestHandler iTestHandler) throws IOException {
        var input = iTestHandler.readFromFile(
                "testcases/wiremock/contract/updatePayrrollInformation/request.json"
        );

        var actual = RestAssured.given()
                .contentType(ContentType.JSON)
                .port(port)
                .body(input)
                .when()
                .post("/wiremock/payroll")
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .asString();

        iTestHandler.assertEqualsJSON(
                "testcases/wiremock/contract/updatePayrrollInformation/response.json",
                actual
        );
    }
}
