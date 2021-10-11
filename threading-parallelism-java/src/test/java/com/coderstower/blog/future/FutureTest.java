package com.coderstower.blog.future;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

public class FutureTest {

    @Test
    public void basicFuture()
            throws InterruptedException, ExecutionException, TimeoutException {
        ExecutorService executor = Executors
                .newSingleThreadExecutor();

      Future<String> future = executor.submit(() -> {
        System.out.println(" Thread: " + Thread
                .currentThread().getName());

        return "Finished";
      });

      future.get();
      future.get(1, TimeUnit.SECONDS);
      future.cancel(true);
      future.isCancelled();
      future.isDone();

      Assertions.assertFalse(true);
    }

  @Test
  public void completableFuture()
          throws InterruptedException, ExecutionException, TimeoutException {
    ExecutorService executor = Executors
            .newSingleThreadExecutor();

    Future<String> completableFuture =
            CompletableFuture.completedFuture("Hello");

    CompletableFuture.supplyAsync(() -> {
      System.out.println(" Thread: " + Thread
              .currentThread().getName());

      return "Finished 1";
    }, executor);

  }
}
