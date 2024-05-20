package com.coderstower.blog.a_case_integration_tests.application.mockmvc.outputfromfile;

import com.coderstower.blog.a_case_integration_tests.extension.ITestExtension;
import com.coderstower.blog.a_case_integration_tests.extension.ITestHandler;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(ITestExtension.class)
@ActiveProfiles("itest")
public class UpdatePayrollInformationTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void postPayrollInformation(ITestHandler iTestHandler) throws Exception {
        var input = iTestHandler.readFromFile(
                "testcases/restassured/inputfromfile/updatePayrrollInformation/request.json"
        );

        String actual = mockMvc.perform(
                        post("/restassured/payroll")
                                .content(input)
                                .contentType(
                                        MediaType.APPLICATION_JSON
                                )
                )
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        iTestHandler.assertEqualsJSON(
                "testcases/restassured/outputfromfile/updatePayrrollInformation/response.json",
                actual
        );
    }
}
