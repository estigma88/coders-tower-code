package com.coderstower.blog.a_case_integration_tests.extension;

import com.github.tomakehurst.wiremock.junit5.WireMockExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.system.OutputCaptureExtension;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("itest")
@ContextConfiguration(classes = OverriddenConfiguration.class)
@ExtendWith(ITestExtension.class)
@ExtendWith(OutputCaptureExtension.class)
public abstract class ITestConfiguration {
    @RegisterExtension
    static WireMockExtension wm1 = WireMockExtension.newInstance()
            .options(
                    wireMockConfig()
                            .port(8089)
                            .notifier(new SpringSlf4jNotifier())
            )
            .configureStaticDsl(true)
            .failOnUnmatchedRequests(true)
            .build();

    @Autowired
    protected MockMvc mockMvc;
}
