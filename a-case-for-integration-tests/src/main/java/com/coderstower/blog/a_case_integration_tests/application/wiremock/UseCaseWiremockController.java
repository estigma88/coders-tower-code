package com.coderstower.blog.a_case_integration_tests.application.wiremock;


import com.coderstower.blog.a_case_integration_tests.application.PayrollInformation;
import com.coderstower.blog.a_case_integration_tests.application.PayrollInformationResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import java.net.URI;

@RestController
@RequestMapping(path = "/wiremock")
public class UseCaseWiremockController {
    private final RestClient restClient;
    private final URI payrollURI;

    public UseCaseWiremockController(
            @Value("${payroll.uri}") URI payrollURI,
            RestClient.Builder restClientBuilder) {
        this.payrollURI = payrollURI;
        this.restClient = restClientBuilder.build();
    }

    @RequestMapping(
            path = "/payroll",
            method = RequestMethod.POST
    )
    public PayrollInformationResponse add(
            @RequestBody PayrollInformation payrollInformation) {

        return restClient
                .post()
                .uri(payrollURI)
                .body(payrollInformation)
                .retrieve()
                .body(PayrollInformationResponse.class);
    }
}
