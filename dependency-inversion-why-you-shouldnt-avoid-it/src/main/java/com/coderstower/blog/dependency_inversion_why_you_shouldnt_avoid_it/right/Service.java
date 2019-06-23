package com.coderstower.blog.dependency_inversion_why_you_shouldnt_avoid_it.right;

public class Service {
    private Repository repository;

    public Service() {
        this.repository = new MySQLRepository();
    }
}
