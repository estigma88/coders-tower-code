package com.coderstower.blog.java_collections_hashmap_vs_treemap;

import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

import java.util.TreeMap;

@State(Scope.Benchmark)
public class TreeMapExecutionPlan
        extends ExecutionPlan {

  public TreeMap<Integer, Integer> treeMap;

  @Setup(Level.Iteration)
  public void treeMapSetUp() {
    treeMap = new TreeMap<>(randomCollection);
  }
}

