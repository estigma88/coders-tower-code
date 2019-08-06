package com.coderstower.blog.java_collections_array_list_vs_linked_list.getsort;


import com.coderstower.blog.java_collections_array_list_vs_linked_list.ArrayListExecutionPlan;
import com.coderstower.blog.java_collections_array_list_vs_linked_list.LinkedListExecutionPlan;
import com.coderstower.blog.java_collections_array_list_vs_linked_list.Utils;
import org.junit.Test;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.results.Result;
import org.openjdk.jmh.results.RunResult;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;


public class ArrayListVsLinkedListSortTest {
  @Test
  public void sort()
          throws RunnerException, IOException {
    Utils.populateToFile();

    Options opt = new OptionsBuilder()
            .include(
                    ArrayListVsLinkedListSortTest.class
                            .getSimpleName())
            .detectJvmArgs()
            .build();

    Collection<RunResult> runResults = new Runner(opt)
            .run();

    Result arrayListResult = Utils
            .find("arrayList",
                    runResults);
    Result linkedListResult = Utils
            .find("linkedList",
                    runResults);

    assertThat(arrayListResult.getScore())
            .isLessThan(linkedListResult.getScore());
  }

  @Benchmark
  @Measurement(iterations = Utils.amountIterations, batchSize = 1, time = 1)
  @BenchmarkMode(Mode.SingleShotTime)
  @Fork(1)
  @Warmup(iterations = 10)
  @OutputTimeUnit(TimeUnit.MILLISECONDS)
  public ArrayList<Integer> arrayList(
          ArrayListExecutionPlan executionPlan) {
    ArrayList<Integer> list = executionPlan.arrayList;

    list.sort(Comparator.naturalOrder());

    return list;
  }

  @Benchmark
  @Measurement(iterations = Utils.amountIterations, batchSize = 1, time = 1)
  @BenchmarkMode(Mode.SingleShotTime)
  @Fork(1)
  @Warmup(iterations = 10)
  @OutputTimeUnit(TimeUnit.MILLISECONDS)
  public LinkedList<Integer> linkedList(
          LinkedListExecutionPlan executionPlan) {
    LinkedList<Integer> list = executionPlan.linkedList;

    list.sort(Comparator.naturalOrder());

    return list;
  }
}
