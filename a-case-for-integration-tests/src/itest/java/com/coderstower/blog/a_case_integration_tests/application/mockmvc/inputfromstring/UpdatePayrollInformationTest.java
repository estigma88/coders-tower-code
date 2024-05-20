package com.coderstower.blog.a_case_integration_tests.application.mockmvc.inputfromstring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("itest")
public class UpdatePayrollInformationTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void postPayrollInformation() throws Exception {
        var input = """
                {
                    "id": 1,
                    "date": "2024-05-06T02:02:05",
                    "amount": 1500
                }
                """;

        mockMvc.perform(
                        post("/restassured/payroll")
                                .content(input)
                                .contentType(
                                        MediaType.APPLICATION_JSON
                                )
                )
                .andExpect(status().isOk())
                .andExpect(
                        jsonPath(
                                "$.amount"
                        )
                                .value(
                                        2500.0F
                                )
                );
    }
}
