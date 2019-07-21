package com.coderstower.blog.java_collections_array_list_vs_linked_list;

import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.stream.Collectors;

import static com.coderstower.blog.java_collections_array_list_vs_linked_list.Utils.amountData;

@State(Scope.Benchmark)
public class ExecutionPlan {
  public int element = amountData / 2;

  public Collection<Integer> randomCollection;

  @Setup(Level.Trial)
  public void collectionSetUp() throws IOException {
    randomCollection = Files
            .readAllLines(Paths.get(Utils.fileName))
            .stream().map(Integer::parseInt).collect(
                    Collectors.toList());
  }
}

