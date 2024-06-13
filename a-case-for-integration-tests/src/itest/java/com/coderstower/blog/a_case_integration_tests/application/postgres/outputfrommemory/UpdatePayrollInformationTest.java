package com.coderstower.blog.a_case_integration_tests.application.postgres.outputfrommemory;

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
                    "classpath:testcases/postgres/outputfrommemory/updatePayrrollInformation/data.sql"
            }
    )
    public void postPayrollInformation(
            ITestHandler iTestHandler) throws Exception {
        var input = iTestHandler.readFromFile(
                "testcases/postgres/outputfrommemory/updatePayrrollInformation/request.json"
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
                "testcases/postgres/outputfrommemory/updatePayrrollInformation/response.json",
                actual
        );

        var expectedEntity = new PayrollInformationEntity();
        expectedEntity.setId(1);
        expectedEntity.setDate(
                LocalDateTime.parse(
                        "2024-05-06T02:02:05"));
        expectedEntity.setAmount(1500.0);

        var currentEntity = payrollInformationRepository.findById(
                1);

        Assertions.assertEquals(expectedEntity,
                currentEntity.get());
    }
}
