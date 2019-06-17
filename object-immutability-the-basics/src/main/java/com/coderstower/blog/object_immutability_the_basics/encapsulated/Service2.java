package com.coderstower.blog.object_immutability_the_basics.encapsulated;

public class Service2 implements Runnable {
    private Person person;

    public Service2(Person person) {
        this.person = person;
    }

    @Override
    public void run() {
        try {
            Thread.sleep((long) (Math.random() * 1000));
        } catch (InterruptedException e) {
        }

        person.setAddress("Street 70");

        System.out.println("Service2 first time setting address to 'Street 70'");

        System.out.println("Service2 first time querying address: " + person.getAddress());
    }
}
