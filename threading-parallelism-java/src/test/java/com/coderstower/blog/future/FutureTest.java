package com.coderstower.blog.future;


import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

public class FutureTest {

  @Test
  public void basicFuture()
          throws InterruptedException,
          ExecutionException, TimeoutException {
    ExecutorService executor = Executors
            .newSingleThreadExecutor();

    Future<String> future = executor.submit(() -> {
      System.out.println(" Thread: " + Thread
              .currentThread().getName());
      return "Finished";
    });

    //Block until result is ready
    var result = future.get();
    //Block until result is ready or timeout
    //var result = future.get(1, TimeUnit.SECONDS);
    //Cancel the task
    future.cancel(true);
    //Check if was cancelled
    future.isCancelled();
    //Check if is done
    future.isDone();
  }

  @Test
  public void completableFuture()
          throws InterruptedException,
          ExecutionException, TimeoutException {
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
