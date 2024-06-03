package com.coderstower.blog.a_case_integration_tests.application.postgres;


import com.coderstower.blog.a_case_integration_tests.application.PayrollInformation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/postgres")
public class UseCasePostgresController {
    private final PayrollInformationRepository payrollInformationRepository;

    public UseCasePostgresController(
            PayrollInformationRepository payrollInformationRepository) {
        this.payrollInformationRepository = payrollInformationRepository;
    }

    @RequestMapping(
            path = "/payroll",
            method = RequestMethod.POST
    )
    public PayrollInformation add(
            @RequestBody PayrollInformation payrollInformation) {
        var newPayrollInformation = new PayrollInformationEntity();
        newPayrollInformation.setId(
                payrollInformation.id());
        newPayrollInformation.setDate(
                payrollInformation.date());
        newPayrollInformation.setAmount(
                payrollInformation.amount());

        payrollInformationRepository.save(newPayrollInformation);

        return payrollInformation;
    }
}
