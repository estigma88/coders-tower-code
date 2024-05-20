package com.coderstower.blog.a_case_integration_tests.application.reuseconfig;

import com.coderstower.blog.a_case_integration_tests.extension.ITestHandler;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class UpdatePayrollInformationTest extends ITestConfiguration {

    @Test
    public void postPayrollInformation(
            ITestHandler iTestHandler) throws Exception {
        var input = iTestHandler.readFromFile(
                "testcases/rest/outputfromfile/updatePayrrollInformation/request.json"
        );

        String actual = mockMvc.perform(
                        post("/restassured/payroll")
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
                "testcases/rest/outputfromfile/updatePayrrollInformation/response.json",
                actual
        );
    }
}
