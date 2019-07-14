package com.coderstower.blog.java_collections_array_list_vs_linked_list;

import java.util.Collection;
import java.util.Random;
import java.util.stream.Collectors;

public class Utils {

  public static final int amountData = 10000000;
  public static final int amountIterations = 10;

  public static Collection<Integer> populate(int amount) {
    return new Random()
            .ints()
            .limit(amount)
            .boxed()
            .collect(Collectors.toList());
  }

  public static void printResults(String operation,
                            long arrayListTime,
                            long linkedListTime) {
    System.out.println(
            "[" + operation + "] Amount Data: " + amountData);
    System.out.println(
            "[" + operation + "] Amount Iterations: " + amountIterations);
    System.out.println(
            "[" + operation + "] Average ArrayList (ms): " + calculateAverage(
                    arrayListTime));
    System.out.println(
            "[" + operation + "] Average LinkedList (ms): " + (calculateAverage(
                    linkedListTime)));
  }

  public static float calculateAverage(
          long totalTime) {
    return totalTime / (float) amountIterations;
  }

  public static long calculateTime(Runnable runnable) {
    long start = System.nanoTime();
    runnable.run();
    long end = System.nanoTime();
    return (end - start) / 1000000;
  }
}
