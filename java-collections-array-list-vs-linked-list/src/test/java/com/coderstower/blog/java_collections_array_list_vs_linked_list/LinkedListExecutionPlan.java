package com.coderstower.blog.java_collections_array_list_vs_linked_list;

import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

import java.util.ArrayList;
import java.util.LinkedList;

@State(Scope.Benchmark)
public class LinkedListExecutionPlan
        extends ExecutionPlan {

  public LinkedList<Integer> linkedList;

  @Setup(Level.Iteration)
  public void linkedListSetUp() {
    linkedList = new LinkedList<>(randomCollection);
  }
}

