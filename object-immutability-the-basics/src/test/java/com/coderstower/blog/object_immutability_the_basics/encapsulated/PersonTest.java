package com.coderstower.blog.object_immutability_the_basics.encapsulated;

import org.junit.Test;

import java.time.LocalDate;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class PersonTest {
    @Test
    public void create_setAccess_newPerson() {
        Person daniel = new Person();
        daniel.setName("Daniel");
        daniel.setAddress("Daniel's Address");
        daniel.setBirthDate(LocalDate.of(1988, 9, 8));

        Person rafael = new Person();
        rafael.setName("Rafael");
        rafael.setAddress("Rafael's Address");
        rafael.setBirthDate(LocalDate.of(1970, 9, 8));
    }

    /**
     * This method tests the inconsistent data in a concurrent environment, where we have a mutable systems
     * <p>
     * You must run this method multiple times to see how it behaves. You cannot predict
     * which address the Service1 will read each time due to Service2 is changing its share value.
     *
     * @throws InterruptedException
     */
    @Test
    public void concurrency_setAddress_inconsistentResults() throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            Person daniel = new Person();
            daniel.setName("Daniel");
            daniel.setAddress("Street 25");
            daniel.setBirthDate(LocalDate.of(1988, 9, 8));

            Service1 service1 = new Service1(daniel);
            Service2 service2 = new Service2(daniel);

            ScheduledExecutorService scheduled = Executors.newScheduledThreadPool(2);

            scheduled.schedule(service1, generateTime(), TimeUnit.MILLISECONDS);
            scheduled.schedule(service2, generateTime(), TimeUnit.MILLISECONDS);

            Thread.sleep(2050);


            for (String info1 : service1.getInfo()) {
                System.out.println(info1);
                assertThat(info1).isEqualTo("Service1 address: Street 25");
            }
        }
    }

    private long generateTime() {
        return (long) (Math.random() * 2000);
    }
}