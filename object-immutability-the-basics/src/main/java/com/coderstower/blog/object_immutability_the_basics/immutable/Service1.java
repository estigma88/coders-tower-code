package com.coderstower.blog.object_immutability_the_basics.immutable;

import java.util.ArrayList;
import java.util.List;

public class Service1 implements Runnable {
    private Person person;
    private List<String> info;

    public Service1(Person person) {
        this.person = person;
        this.info = new ArrayList<>();
    }

    @Override
    public void run() {
        info.add("Service1 address: " + person.getAddress());

        try {
            Thread.sleep((long) (Math.random() * 1000));
        } catch (InterruptedException e) {
        }

        info.add("Service1 address: " + person.getAddress());
    }

    public List<String> getInfo() {
        return info;
    }
}
