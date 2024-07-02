package com.coderstower.blog.a_case_integration_tests.application.postgres.outputfromfile;

import com.coderstower.blog.a_case_integration_tests.application.postgres.PayrollInformationEntity;
import com.coderstower.blog.a_case_integration_tests.application.postgres.PayrollInformationRepository;
import com.coderstower.blog.a_case_integration_tests.application.reuseconfig.ITestConfiguration;
import com.coderstower.blog.a_case_integration_tests.extension.ITestHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class UpdatePayrollInformationTest extends ITestConfiguration {
    @Autowired
    private PayrollInformationRepository payrollInformationRepository;

    @Test
    @Sql(
            scripts = {
                    "classpath:testcases/postgres/clean.sql",
                    "classpath:testcases/postgres/outputfromfile/updatePayrrollInformation/data.sql"
            }
    )
    public void postPayrollInformation(
            ITestHandler iTestHandler) throws Exception {
        var input = iTestHandler.readFromFile(
                "testcases/postgres/outputfromfile/updatePayrrollInformation/request.json"
        );

        String actual = mockMvc.perform(
                        post("/postgres/payroll")
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
                "testcases/postgres/outputfromfile/updatePayrrollInformation/response.json",
                actual
        );

        var currentEntity = payrollInformationRepository.findById(
                1).orElseThrow();

        iTestHandler.assertEqualsJSON(
                "testcases/postgres/outputfromfile/updatePayrrollInformation/expectedData.json",
                currentEntity);
    }
}
