package com.coderstower.blog.java_collections_array_list_vs_linked_list.addition;


import com.coderstower.blog.java_collections_array_list_vs_linked_list.ExecutionPlan;
import org.junit.Test;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.results.RunResult;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertFalse;


public class ArrayListVsLinkedListAdditionEndTest {
  @Test
  public void add_end() throws RunnerException {
    Options opt = new OptionsBuilder()
            .include(
                    ArrayListVsLinkedListAdditionEndTest.class
                            .getSimpleName())
            //.jvmArgs("-Xms3g", "-Xmx3g")
            .build();
    Collection<RunResult> runResults = new Runner(opt)
            .run();
    assertFalse(runResults.isEmpty());
  }

  @Benchmark
  @Measurement(iterations = 3)
  @BenchmarkMode(Mode.AverageTime)
  @Fork(1)
  @Warmup(iterations = 0)
  @OutputTimeUnit(TimeUnit.MICROSECONDS)
  public void add(ExecutionPlan executionPlan) {
    ArrayList<Integer> list = executionPlan.arrayList;

    list.add(executionPlan.element);
  }

  /*@Benchmark
  @BenchmarkMode(Mode.All)
  @Fork(1)
  @Warmup(iterations = 0)
  @OutputTimeUnit(TimeUnit.MICROSECONDS)
  public void measureAll() throws InterruptedException {
    TimeUnit.MILLISECONDS.sleep(100);
  }*/
}
