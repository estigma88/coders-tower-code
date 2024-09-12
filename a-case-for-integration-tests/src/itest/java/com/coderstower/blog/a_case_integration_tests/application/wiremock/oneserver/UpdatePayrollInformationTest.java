package com.coderstower.blog.a_case_integration_tests.application.wiremock.oneserver;

import com.coderstower.blog.a_case_integration_tests.extension.ITestConfiguration;
import com.coderstower.blog.a_case_integration_tests.extension.ITestHandler;
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class UpdatePayrollInformationTest extends ITestConfiguration {

    @Test
    public void postPayrollInformation(
            ITestHandler iTestHandler,
            WireMockRuntimeInfo wireMockRuntimeInfo) throws Exception {
        iTestHandler.loadWiremockMocks(
                wireMockRuntimeInfo,
                "testcases/wiremock/oneserver/updatePayrrollInformation"
        );

        var input = iTestHandler.readFromFile(
                "testcases/wiremock/oneserver/updatePayrrollInformation/request.json"
        );

        String actual = mockMvc.perform(
                        post("/wiremock/payroll")
                                .content(input)
                                .contentType(
                                        MediaType.APPLICATION_JSON
                                )
                )
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        iTestHandler.assertEqualsJSON(
                "testcases/wiremock/oneserver/updatePayrrollInformation/response.json",
                actual
        );
    }
}
