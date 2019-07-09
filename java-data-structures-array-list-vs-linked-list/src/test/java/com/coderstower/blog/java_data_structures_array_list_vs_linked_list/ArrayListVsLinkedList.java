package com.coderstower.blog.java_data_structures_array_list_vs_linked_list;


import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class ArrayListVsLinkedList {
  private final int amountData = 10000000;
  private final int amountIterations = 10;

  @Test
  public void sort() {
    long arrayListTime = 0;
    long linkedListTime = 0;

    for (int i = 1; i <= amountIterations; i++) {
      Collection<Integer> data = populate(amountData);

      ArrayList<Integer> arrayList = new ArrayList<>(
              data);
      LinkedList<Integer> linkedList = new LinkedList<>(
              data);

      arrayListTime += sort(arrayList);
      linkedListTime += sort(linkedList);
    }
    printResults("Sort", arrayListTime,
            linkedListTime);
  }

  @Test
  public void add_end() {
    long arrayListTime = 0;
    long linkedListTime = 0;
    int valueAdded = amountData / 2;

    for (int i = 1; i <= amountIterations; i++) {
      Collection<Integer> data = populate(amountData);

      ArrayList<Integer> arrayList = new ArrayList<>(
              data);
      LinkedList<Integer> linkedList = new LinkedList<>(
              data);
      arrayListTime += addToEnd(arrayList, valueAdded);
      linkedListTime += addToEnd(linkedList,
              valueAdded);
    }

    printResults("AddToEnd", arrayListTime,
            linkedListTime);
  }

  @Test
  public void remove_end() {
    long arrayListTime = 0;
    long linkedListTime = 0;

    for (int i = 1; i <= amountIterations; i++) {
      Collection<Integer> data = populate(amountData);

      ArrayList<Integer> arrayList = new ArrayList<>(
              data);
      LinkedList<Integer> linkedList = new LinkedList<>(
              data);
      arrayListTime += removeToEnd(arrayList);
      linkedListTime += removeToEnd(linkedList);
    }

    printResults("removeToEnd", arrayListTime,
            linkedListTime);
  }

  @Test
  public void remove_middle() {
    long arrayListTime = 0;
    long linkedListTime = 0;

    for (int i = 1; i <= amountIterations; i++) {
      Collection<Integer> data = populate(amountData);

      ArrayList<Integer> arrayList = new ArrayList<>(
              data);
      LinkedList<Integer> linkedList = new LinkedList<>(
              data);
      arrayListTime += removeToMiddle(arrayList);
      linkedListTime += removeToMiddle(linkedList);
    }

    printResults("removeToMiddle", arrayListTime,
            linkedListTime);
  }

  @Test
  public void remove_first() {
    long arrayListTime = 0;
    long linkedListTime = 0;

    for (int i = 1; i <= amountIterations; i++) {
      Collection<Integer> data = populate(amountData);

      ArrayList<Integer> arrayList = new ArrayList<>(
              data);
      LinkedList<Integer> linkedList = new LinkedList<>(
              data);
      arrayListTime += removeToFirst(arrayList);
      linkedListTime += removeToFirst(linkedList);
    }

    printResults("removeToFirst", arrayListTime,
            linkedListTime);
  }

  @Test
  public void add_middle() {
    long arrayListTime = 0;
    long linkedListTime = 0;
    int valueAdded = amountData / 2;

    for (int i = 1; i <= amountIterations; i++) {
      Collection<Integer> data = populate(amountData);

      ArrayList<Integer> arrayList = new ArrayList<>(
              data);
      LinkedList<Integer> linkedList = new LinkedList<>(
              data);

      arrayListTime += addToMiddle(arrayList, valueAdded);
      linkedListTime += addToMiddle(linkedList,
              valueAdded);
    }

    printResults("AddToMiddle", arrayListTime,
            linkedListTime);
  }

  @Test
  public void add_first() {
    long arrayListTime = 0;
    long linkedListTime = 0;
    int valueAdded = amountData / 2;

    for (int i = 1; i <= amountIterations; i++) {
      Collection<Integer> data = populate(amountData);

      ArrayList<Integer> arrayList = new ArrayList<>(
              data);
      LinkedList<Integer> linkedList = new LinkedList<>(
              data);

      arrayListTime += addToFirst(arrayList, valueAdded);
      linkedListTime += addToFirst(linkedList,
              valueAdded);
    }

    printResults("addToFirst", arrayListTime,
            linkedListTime);
  }

  @Test
  public void iterate() {
    long arrayListTime = 0;
    long linkedListTime = 0;

    for (int i = 1; i <= amountIterations; i++) {
      Collection<Integer> data = populate(amountData);

      ArrayList<Integer> arrayList = new ArrayList<>(
              data);
      LinkedList<Integer> linkedList = new LinkedList<>(
              data);

      arrayListTime += iterate(arrayList);
      linkedListTime += iterate(linkedList);
    }

    printResults("iterate", arrayListTime,
            linkedListTime);
  }

  @Test
  public void contains() {
    long arrayListTime = 0;
    long linkedListTime = 0;
    int valueSearched = amountData / 2;

    for (int i = 1; i <= amountIterations; i++) {
      Collection<Integer> data = populate(amountData);

      ArrayList<Integer> arrayList = new ArrayList<>(
              data);
      LinkedList<Integer> linkedList = new LinkedList<>(
              data);

      arrayListTime += contains(arrayList, valueSearched);
      linkedListTime += contains(linkedList, valueSearched);
    }

    printResults("contains", arrayListTime,
            linkedListTime);
  }

  private long contains(List<Integer> list,
                        int valueSearched) {
    return calculateTime(() -> list.contains(valueSearched));
  }

  private long iterate(List<Integer> list) {
    return calculateTime(() -> {
      for(Integer data: list);
    });
  }

  private long addToFirst(List<Integer> list,
                           Integer value) {
    return calculateTime(() -> list
            .add(0,  value));
  }

  private long addToMiddle(List<Integer> list,
                        Integer value) {
    return calculateTime(() -> list
            .add(value,  value));
  }

  private long addToEnd(List<Integer> list,
                        Integer value) {
    return calculateTime(() -> list
            .add(value));
  }

  private long removeToFirst(List<Integer> list) {
    return calculateTime(() -> list
            .remove(0));
  }

  private long removeToMiddle(List<Integer> list) {
    return calculateTime(() -> list
            .remove(amountData/2));
  }

  private long removeToEnd(List<Integer> list) {
    return calculateTime(() -> list
            .remove(amountData - 1));
  }

  private long sort(List<Integer> list) {
    return calculateTime(() -> list
            .sort(Comparator.naturalOrder()));
  }

  private Collection<Integer> populate(int amount) {
    return new Random()
            .ints()
            .limit(amount)
            .boxed()
            .collect(Collectors.toList());
  }

  private void printResults(String operation,
                            long arrayListTime,
                            long linkedListTime) {
    System.out.println(
            "[" + operation + "] Amount Data: " + amountData);
    System.out.println(
            "[" + operation + "] Amount Iterations: " + amountIterations);
    System.out.println(
            "[" + operation + "] Average ArrayList (ms): " + (arrayListTime / (float) amountIterations));
    System.out.println(
            "[" + operation + "] Average LinkedList (ms): " + (linkedListTime / (float) amountIterations));
  }

  private long calculateTime(Runnable runnable) {
    long start = System.nanoTime();
    runnable.run();
    long end = System.nanoTime();
    return (end - start) / 1000000;
  }
}
