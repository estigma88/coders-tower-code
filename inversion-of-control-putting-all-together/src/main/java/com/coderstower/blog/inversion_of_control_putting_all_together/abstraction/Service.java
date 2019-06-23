package com.coderstower.blog.inversion_of_control_putting_all_together.abstraction;

public class Service {
    private final Repository repository;

    public Service(Repository repository) {
        this.repository = repository;
    }
}
