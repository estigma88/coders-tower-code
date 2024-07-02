package com.coderstower.blog.a_case_integration_tests.application.postgres;

import org.springframework.data.repository.CrudRepository;

public interface PayrollInformationRepository extends CrudRepository<PayrollInformationEntity, Integer> {
}