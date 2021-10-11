package com.coderstower.blog.parallelism;


import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.IntBinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.StreamSupport;

public class ParalellismTest {

  @Test
  public void noWrongParallel()
          throws InterruptedException {
    long nanosStart = System.nanoTime();

    OptionalInt total = IntStream.range(1, 1_000_000)
            .map(i -> i*i)
            .reduce(Integer::sum);

    long nanosEnd = System.nanoTime();

    System.out.println("Result = " + total.getAsInt());
    System.out.println("Time ms= " + ((nanosEnd - nanosStart)/1_000_000));
  }

  @Test
  public void wrongParallel()
          throws InterruptedException {
    long nanosStart = System.nanoTime();

    OptionalInt total = IntStream.range(1, 1_000_000)
            .parallel()
            .map(i -> i*i)
            .reduce(Integer::sum);

    long nanosEnd = System.nanoTime();

    System.out.println("Result = " + total.getAsInt());
    System.out.println("Time ms= " + ((nanosEnd - nanosStart)/1_000_000));
  }

  @Test
  public void noParallelGood()
          throws InterruptedException {
    long nanosStart = System.nanoTime();

    long total = IntStream.range(1, 1_000_000)
            .map(i -> i * i)
            .boxed()
            .filter(integer -> integer % 2 == 0)
            .count();

    long nanosEnd = System.nanoTime();

    System.out.println("Result = " + total);
    System.out.println("Time ms= " + ((nanosEnd - nanosStart)/1_000_000));
  }

  @Test
  public void parallelGood()
          throws InterruptedException {
    long nanosStart = System.nanoTime();

    long total = IntStream.range(1, 1_000_000)
            .parallel()
            .map(i -> i * i)
            .boxed()
            .filter(integer -> integer % 2 == 0)
            .count();

    long nanosEnd = System.nanoTime();

    System.out.println("Result = " + total);
    System.out.println("Time ms= " + ((nanosEnd - nanosStart)/1_000_000));
  }
}
