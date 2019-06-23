package com.coderstower.blog.factory_methods_decoupling_ioc_container_abstraction.abstraction;

public class Service {
    private final Repository repository;

    public Service(Repository repository) {
        this.repository = repository;
    }
}
