package com.coderstower.blog.java_collections_array_list_vs_linked_list.addition;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import static com.coderstower.blog.java_collections_array_list_vs_linked_list.Utils.*;
import static org.assertj.core.api.Assertions.assertThat;

public class ArrayListVsLinkedListAdditionStartTest {

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

      arrayListTime += addToStart(arrayList,
              valueAdded);
      linkedListTime += addToStart(linkedList,
              valueAdded);
    }

    printResults("AddToStart", arrayListTime,
            linkedListTime);

    assertThat(calculateAverage(linkedListTime))
            .isLessThan(
                    calculateAverage(arrayListTime));
  }

  private long addToStart(List<Integer> list,
                          Integer value) {
    return calculateTime(() -> list
            .add(0, value));
  }
}
