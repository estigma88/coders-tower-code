package com.coderstower.blog.java_collections_hashmap_vs_treemap.get;


import com.coderstower.blog.java_collections_hashmap_vs_treemap.ExecutionPlan;
import com.coderstower.blog.java_collections_hashmap_vs_treemap.HashMapExecutionPlan;
import com.coderstower.blog.java_collections_hashmap_vs_treemap.TreeMapExecutionPlan;
import com.coderstower.blog.java_collections_hashmap_vs_treemap.Utils;
import org.junit.Test;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.results.Result;
import org.openjdk.jmh.results.RunResult;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Objects;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

import static com.coderstower.blog.java_collections_hashmap_vs_treemap.Utils.amountData;
import static org.assertj.core.api.Assertions.assertThat;

public class HashMapVsTreeMapGetTest {

  @Test
  public void get()
          throws RunnerException, IOException {
    Utils.populateToFile();

    Options opt = new OptionsBuilder()
            .include(
                    HashMapVsTreeMapGetTest.class
                            .getSimpleName())
            .detectJvmArgs()
            .build();

    Collection<RunResult> runResults = new Runner(opt)
            .run();

    Result hashMapResult = Utils
            .find("hashMap",
                    runResults);
    Result treeMapResult = Utils
            .find("treeMap",
                    runResults);

    assertThat(hashMapResult.getScore())
            .isLessThan(treeMapResult.getScore());
  }

  @Benchmark
  @Measurement(iterations = Utils.amountIterations, batchSize = 1, time = 1)
  @BenchmarkMode(Mode.SingleShotTime)
  @Fork(1)
  @Warmup(iterations = 10)
  @OutputTimeUnit(TimeUnit.MILLISECONDS)
  public HashMap<Integer, Integer> hashMap(
          HashMapExecutionPlan executionPlan) {
    HashMap<Integer, Integer> hashMap = executionPlan.hashMap;

    hashMap.get(ExecutionPlan.element);

    return hashMap;
  }

  @Benchmark
  @Measurement(iterations = Utils.amountIterations, batchSize = 1, time = 1)
  @BenchmarkMode(Mode.SingleShotTime)
  @Fork(1)
  @Warmup(iterations = 10)
  @OutputTimeUnit(TimeUnit.MILLISECONDS)
  public TreeMap<Integer, Integer> treeMap(
          TreeMapExecutionPlan executionPlan) {
    TreeMap<Integer, Integer> treeMap = executionPlan.treeMap;

    treeMap.get(ExecutionPlan.element);

    return treeMap;
  }

  @Test
  public void hashing(){
    System.out.println(Objects.hash("A"));
    System.out.println(Objects.hash("B"));
    System.out.println(Objects.hash("C"));
    System.out.println(Objects.hash("D"));
    System.out.println(Objects.hash("E"));
  }
}
