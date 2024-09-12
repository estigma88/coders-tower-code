package com.coderstower.blog.a_case_integration_tests.application.wiremock.contract;

import com.coderstower.blog.a_case_integration_tests.extension.ITestConfiguration;
import com.coderstower.blog.a_case_integration_tests.extension.ITestExtension;
import com.coderstower.blog.a_case_integration_tests.extension.ITestHandler;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ActiveProfiles("itest")
@AutoConfigureWireMock(
        stubs = {"classpath:testcases/wiremock/contract/createPayrrollInformation/mocks"},
        port = 0
)
@ExtendWith(ITestExtension.class)
public class CreatePayrollInformationTest extends ITestConfiguration {
    @Value("${wiremock.server.port}")
    private int wiremockPort;

    @Test
    public void postPayrollInformation(
            ITestHandler iTestHandler) throws Exception {
        System.out.println("Wiremock port: " + wiremockPort);

        var input = iTestHandler.readFromFile(
                "testcases/wiremock/contract/createPayrrollInformation/request.json"
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
                "testcases/wiremock/contract/createPayrrollInformation/response.json",
                actual
        );
    }
}
