package com.coderstower.blog.java_collections_hashmap_vs_treemap;

import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

import java.util.HashMap;

@State(Scope.Benchmark)
public class HashMapExecutionPlan
        extends ExecutionPlan {

  public HashMap<Integer, Integer> hashMap;

  @Setup(Level.Iteration)
  public void hasMapSetUp() {
    hashMap = new HashMap<>(randomCollection);
  }
}

