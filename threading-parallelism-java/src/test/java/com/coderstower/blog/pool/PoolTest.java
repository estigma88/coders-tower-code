package com.coderstower.blog.pool;


import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PoolTest {

  @Test
  public void singleThreadPool()
          throws InterruptedException {
    ExecutorService executor = Executors
            .newSingleThreadExecutor();

    submitTasks(executor);
  }

  @Test
  public void fixPool() throws InterruptedException {
    ExecutorService executor = Executors
            .newFixedThreadPool(5);

    submitTasks(executor);
  }

  @Test
  public void cachedPool()
          throws InterruptedException {
    ExecutorService executor = Executors
            .newCachedThreadPool();

    submitTasks(executor);
  }

  private void submitTasks(ExecutorService executor)
          throws InterruptedException {
    Set<String> threadNames = new HashSet<>();

    for (int i = 0; i < 100; i++) {
      int finalI = i;

      executor.execute(() -> {
        System.out.println(
                "Running: " + finalI + " Thread: " + Thread
                        .currentThread().getName());

        threadNames
                .add(Thread.currentThread().getName());
      });
    }
    Thread.sleep(2000);

    System.out.println();
    System.out.println(
            "# Threads: " + threadNames.size());
    System.out.println("Threads: " + threadNames);
  }
}
