package com.coderstower.blog.object_immutability_the_basics.immutable;

import java.util.ArrayList;
import java.util.List;

public class Service2 implements Runnable {
    private Person person;
    private List<String> info;

    public Service2(Person person) {
        this.person = person;
        this.info = new ArrayList<>();
    }

    @Override
    public void run() {
        try {
            Thread.sleep((long) (Math.random() * 1000));
        } catch (InterruptedException e) {
        }

        person = person.setAddress("Street 70");

        info.add("Service2 address: " + person.getAddress());
    }

    public List<String> getInfo() {
        return info;
    }
}
