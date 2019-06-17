package com.coderstower.blog.object_immutability_the_basics.immutable;

public class Service1 implements Runnable {
    private Person person;

    public Service1(Person person) {
        this.person = person;
    }

    @Override
    public void run() {
        System.out.println("Service1 first time querying address: " + person.getAddress());

        try {
            Thread.sleep((long) (Math.random() * 1000));
        } catch (InterruptedException e) {
        }

        System.out.println("Service1 second time querying address: " + person.getAddress());
    }
}
