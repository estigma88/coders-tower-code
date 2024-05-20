package com.coderstower.blog.a_case_integration_tests.application.reuseconfig;

import com.coderstower.blog.a_case_integration_tests.extension.ITestHandler;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class UpdatePayrollInformationTest extends ITestConfiguration {

    @Test
    public void postPayrollInformation(
            ITestHandler iTestHandler) throws IOException {
        var input = iTestHandler.readFromFile(
                "testcases/rest/outputfromfile/updatePayrrollInformation/request.json"
        );

        var actual = RestAssured.given()
                .contentType(ContentType.JSON)
                .port(port)
                .body(input)
                .when()
                .post("/section3/payroll")
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .asString();

        iTestHandler.assertEqualsJSON(
                "testcases/rest/outputfromfile/updatePayrrollInformation/response.json",
            actual
        );
    }
}
