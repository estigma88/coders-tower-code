package com.coderstower.blog.a_case_integration_tests.application.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/example2")
public class UseCaseExample2Controller {
    private Double currentPayroll = 1000d;

    @RequestMapping(path = "/payroll", method = RequestMethod.POST)
    public PayrollInformation add(PayrollInformation payrollInformation) {
        var newPayrollInformation = new PayrollInformation(
                payrollInformation.id(),
                payrollInformation.date(),
                payrollInformation.amount() + currentPayroll
        );

        return newPayrollInformation;
    }
}
