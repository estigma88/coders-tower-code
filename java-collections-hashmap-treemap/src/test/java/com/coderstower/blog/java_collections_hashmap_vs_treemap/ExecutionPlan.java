package com.coderstower.blog.java_collections_hashmap_vs_treemap;

import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.coderstower.blog.java_collections_hashmap_vs_treemap.Utils.amountData;

@State(Scope.Benchmark)
public class ExecutionPlan {
  public int element = amountData / 2;

  public Map<Integer, Integer> randomCollection;

  @Setup(Level.Trial)
  public void collectionSetUp() throws IOException {
    randomCollection = Files
            .readAllLines(Paths.get(Utils.fileName))
            .stream().map(Integer::parseInt).collect(
                    Collectors.toMap(Function.identity(), Function.identity()));
  }
}

