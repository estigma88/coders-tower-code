package com.coderstower.blog.a_case_integration_tests.application.section1;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles({"itest", "newProfile"})
public class SecondContextTest {
    @Test
    public void contextUp() {

    }
}
