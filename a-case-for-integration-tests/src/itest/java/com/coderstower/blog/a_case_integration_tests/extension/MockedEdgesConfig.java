package com.coderstower.blog.a_case_integration_tests.extension;

import com.github.tomakehurst.wiremock.junit5.WireMockExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.system.OutputCaptureExtension;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("itest")
@ContextConfiguration(classes = OverriddenConfiguration.class)
@ExtendWith(ITestExtension.class)
@ExtendWith(OutputCaptureExtension.class)
public abstract class MockedEdgesConfig {
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

    @LocalServerPort
    protected Integer port;
}
