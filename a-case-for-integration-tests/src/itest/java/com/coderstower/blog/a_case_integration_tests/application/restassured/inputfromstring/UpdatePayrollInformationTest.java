package com.coderstower.blog.a_case_integration_tests.application.restassured.inputfromstring;

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
public class UpdatePayrollInformationTest {
    @LocalServerPort
    protected Integer port;

    @Test
    public void postPayrollInformation() {
        var input = """
                {
                    "id": 1,
                    "date": "2024-05-06T02:02:05",
                    "amount": 1500
                }
                """;

        RestAssured.given()
                .contentType(ContentType.JSON)
                .port(port)
                .body(input)
                .when()
                .post("/section3/payroll")
                .then()
                .assertThat()
                .statusCode(200)
                .body("amount", equalTo(2500.0F));
    }
}
