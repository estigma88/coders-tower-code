package com.coderstower.blog.object_immutability_the_basics.immutable;

import org.junit.Test;

import java.time.LocalDate;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class PersonTest {
    @Test
    public void create_setAccess_newPerson() {
        Person daniel = new Person("MockName", "MockAddress", null);
        daniel = daniel.setName("Daniel");
        daniel = daniel.setAddress("Daniel's Address");
        daniel = daniel.setBirthDate(LocalDate.of(1988, 9, 8));

        Person rafael = new Person("MockName", "MockAddress", null);
        rafael = rafael.setName("Rafael");
        rafael = rafael.setAddress("Rafael's Address");
        rafael = rafael.setBirthDate(LocalDate.of(1970, 9, 8));
    }

    /**
     * This method tests the consistent data in a concurrent environment, where we have an immutable system
     * <p>
     * You must run this method multiple times to see how it behaves. You can predict
     * which address the Service1 will read each time spite of Service2 is changing its value.
     *
     * @throws InterruptedException
     */
    @Test
    public void concurrency_setAddress_consistentResults() throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            Person daniel = new Person("Daniel", "Street 25", LocalDate.of(1988, 9, 8));

            Service1 service1 = new Service1(daniel);
            Service2 service2 = new Service2(daniel);

            ScheduledExecutorService scheduled = Executors.newScheduledThreadPool(2);

            scheduled.schedule(service1, generateTime(), TimeUnit.MILLISECONDS);
            scheduled.schedule(service2, generateTime(), TimeUnit.MILLISECONDS);

            Thread.sleep(2050);
        }
    }

    private long generateTime() {
        return (long) (Math.random() * 2000);
    }
}