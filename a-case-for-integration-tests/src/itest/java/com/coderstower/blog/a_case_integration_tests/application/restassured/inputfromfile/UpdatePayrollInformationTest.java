package com.coderstower.blog.a_case_integration_tests.application.restassured.inputfromfile;

import com.coderstower.blog.a_case_integration_tests.extension.ITestExtension;
import com.coderstower.blog.a_case_integration_tests.extension.ITestHandler;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@ActiveProfiles("itest")
@ExtendWith(ITestExtension.class)
public class UpdatePayrollInformationTest {
    @LocalServerPort
    protected Integer port;

    @Test
    public void postPayrollInformation(
            ITestHandler iTestHandler) throws IOException {
        var input = iTestHandler.readFromFile(
           "testcases/restassured/inputfromfile/updatePayrrollInformation/request.json"
        );

        RestAssured.given()
                .contentType(ContentType.JSON)
                .port(port)
                .body(input)
                .when()
                .post("/restassured/payroll")
                .then()
                .assertThat()
                .statusCode(200)
                .body("amount", equalTo(2500.0F));
    }
}
