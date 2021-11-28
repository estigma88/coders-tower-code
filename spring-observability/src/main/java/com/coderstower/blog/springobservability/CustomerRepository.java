package com.coderstower.blog.springobservability;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends
        JpaRepository<CustomerEntity, String> {
}
