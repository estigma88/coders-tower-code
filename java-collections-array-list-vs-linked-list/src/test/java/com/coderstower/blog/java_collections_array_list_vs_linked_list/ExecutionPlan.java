package com.coderstower.blog.java_collections_array_list_vs_linked_list;

import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Random;
import java.util.stream.Collectors;

@State(Scope.Benchmark)
public class ExecutionPlan {
  public int amountData = 10000000;

  public int element = amountData / 2;

  public Collection<Integer> randomCollection;

  public ArrayList<Integer> arrayList;

  public LinkedList<Integer> linkedList;

  @Setup(Level.Trial)
  public void collectionSetUp() {
    randomCollection = new Random()
            .ints()
            .limit(amountData)
            .boxed()
            .collect(Collectors.toList());
  }

  @Setup(Level.Iteration)
  public void arrayListSetUp() {
    arrayList = new ArrayList<>(randomCollection);
  }

  @Setup(Level.Iteration)
  public void linkedListSetUp() {
    arrayList = new ArrayList<>(randomCollection);
  }
}

