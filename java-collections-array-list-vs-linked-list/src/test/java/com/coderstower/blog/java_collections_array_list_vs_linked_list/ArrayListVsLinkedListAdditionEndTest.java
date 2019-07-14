package com.coderstower.blog.java_collections_array_list_vs_linked_list;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import static com.coderstower.blog.java_collections_array_list_vs_linked_list.Utils.*;
import static org.assertj.core.api.Assertions.assertThat;

public class ArrayListVsLinkedListAdditionEndTest {
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

    assertThat(calculateAverage(linkedListTime))
            .isLessThan(
                    calculateAverage(arrayListTime));
  }

  private long addToEnd(List<Integer> list,
                        Integer value) {
    return calculateTime(() -> list
            .add(value));
  }
}
