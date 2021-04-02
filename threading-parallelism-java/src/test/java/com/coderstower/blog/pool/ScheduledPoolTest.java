package com.coderstower.blog.pool;


import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledPoolTest {

  @Test
  public void singleThreadPool()
          throws InterruptedException {
    ScheduledExecutorService executor = Executors
            .newSingleThreadScheduledExecutor();
//    ScheduledExecutorService executor = Executors
//            .newScheduledThreadPool(5);

    executor.schedule(() -> System.out.println(
            "Task 1 run once on " + LocalDateTime
                    .now()), 2, TimeUnit.SECONDS);

    executor.scheduleAtFixedRate(() -> System.out.println(
            "Task 2 run each 2 seconds " + LocalDateTime
                    .now()), 2, 2, TimeUnit.SECONDS);

    executor.scheduleWithFixedDelay(() -> System.out.println(
            "Task 3 run after 2 seconds finishing the previous one " + LocalDateTime
                    .now()), 2, 2, TimeUnit.SECONDS);

    Thread.sleep(10000);
  }
}
