package com.coderstower.blog.a_case_integration_tests.application.textcontextcache;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@ActiveProfiles("itest")
public class FirstContextTest {
    @Test
    public void contextUp() {

    }
}
