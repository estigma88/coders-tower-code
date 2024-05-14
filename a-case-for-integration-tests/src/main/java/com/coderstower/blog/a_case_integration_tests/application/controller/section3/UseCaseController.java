package com.coderstower.blog.a_case_integration_tests.application.controller.section3;


import com.coderstower.blog.a_case_integration_tests.application.controller.PayrollInformation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/section3")
public class UseCaseController {
    private Double currentPayroll = 1000d;

    @RequestMapping(path = "/payroll", method = RequestMethod.POST)
    public PayrollInformation add(@RequestBody PayrollInformation payrollInformation) {
        var newPayrollInformation = new PayrollInformation(
                payrollInformation.id(),
                payrollInformation.date(),
                payrollInformation.amount() + currentPayroll
        );

        return newPayrollInformation;
    }
}
