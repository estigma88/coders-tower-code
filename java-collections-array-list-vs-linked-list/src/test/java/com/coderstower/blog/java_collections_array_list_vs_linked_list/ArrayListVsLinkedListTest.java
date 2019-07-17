package com.coderstower.blog.java_collections_array_list_vs_linked_list;


import org.junit.Ignore;
import org.junit.Test;

import java.util.*;

import static com.coderstower.blog.java_collections_array_list_vs_linked_list.Utils.*;
import static org.assertj.core.api.Assertions.assertThat;

@Ignore
public class ArrayListVsLinkedListTest {
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

    assertThat(linkedListTime).isLessThan(arrayListTime);
  }

  private long addToEnd(List<Integer> list,
                        Integer value) {
    return calculateTime(() -> list
            .add(value));
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

    assertThat(linkedListTime).isLessThan(arrayListTime);
  }

  private long addToMiddle(List<Integer> list,
                           Integer value) {
    return calculateTime(() -> list
            .add(value,  value));
  }

  @Test
  public void add_start() {
    long arrayListTime = 0;
    long linkedListTime = 0;
    int valueAdded = amountData / 2;

    for (int i = 1; i <= amountIterations; i++) {
      Collection<Integer> data = populate(amountData);

      ArrayList<Integer> arrayList = new ArrayList<>(
              data);
      LinkedList<Integer> linkedList = new LinkedList<>(
              data);

      arrayListTime += addToStart(arrayList, valueAdded);
      linkedListTime += addToStart(linkedList,
              valueAdded);
    }

    printResults("addToStart", arrayListTime,
            linkedListTime);

    assertThat(linkedListTime).isLessThan(arrayListTime);
  }

  private long addToStart(List<Integer> list,
                          Integer value) {
    return calculateTime(() -> list
            .add(0,  value));
  }

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

    assertThat(arrayListTime).isLessThan(linkedListTime);
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

    assertThat(linkedListTime).isEqualTo(arrayListTime);
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

    assertThat(linkedListTime).isLessThan(arrayListTime);
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

    assertThat(linkedListTime).isLessThan(arrayListTime);
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

    assertThat(arrayListTime).isLessThan(linkedListTime);
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

    assertThat(arrayListTime).isLessThan(linkedListTime);
  }

  @Test
  public void get() {
    long arrayListTime = 0;
    long linkedListTime = 0;
    int indexSearched = amountData / 2;

    for (int i = 1; i <= amountIterations; i++) {
      Collection<Integer> data = populate(amountData);

      ArrayList<Integer> arrayList = new ArrayList<>(
              data);
      LinkedList<Integer> linkedList = new LinkedList<>(
              data);

      arrayListTime += get(arrayList, indexSearched);
      linkedListTime += get(linkedList, indexSearched);
    }

    printResults("get", arrayListTime,
            linkedListTime);

    assertThat(arrayListTime).isLessThan(linkedListTime);
  }

  private long get(List<Integer> list,
                        int indexSearched) {
    return calculateTime(() -> list.get(indexSearched));
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

}
