package com.coderstower.blog.dependency_injection_solving_the_inversion_of_control_complexity.abstraction;

import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class Service {
    private final Repository repository;

    @Autowired
    public Service(Repository repository) {
        this.repository = repository;
    }
}
