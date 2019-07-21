package com.coderstower.blog.java_collections_array_list_vs_linked_list;

import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

import java.util.ArrayList;

@State(Scope.Benchmark)
public class ArrayListExecutionPlan
        extends ExecutionPlan {

  public ArrayList<Integer> arrayList;

  @Setup(Level.Iteration)
  public void arrayListSetUp() {
    arrayList = new ArrayList<>(randomCollection);
  }
}

