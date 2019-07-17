package com.coderstower.blog.java_collections_array_list_vs_linked_list;

import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@Ignore
public class ListTest {

  @Test
  public void add_newElement_listChanged() {
    List<Integer> list = new ArrayList<>(
            Arrays.asList(1, 5, 5, 9, 8, 10, 8));
    /*List<Integer> list = new LinkedList<>(
            Arrays.asList(1, 5, 5, 9, 8, 10, 8));*/

    list.add(9);

    assertThat(list).isEqualTo(
            Arrays.asList(1, 5, 5, 9, 8, 10, 8, 9));
  }

  @Test
  public void contains_element_true() {
    List<Integer> list = new ArrayList<>(
            Arrays.asList(1, 5, 5, 9, 8, 10, 8));
    /*List<Integer> list = new LinkedList<>(
            Arrays.asList(1, 5, 5, 9, 8, 10, 8));*/

    boolean result = list.contains(8);

    assertThat(result).isTrue();
  }

  @Test
  public void remove_element_true() {
    List<Integer> list = new ArrayList<>(
            Arrays.asList(1, 5, 5, 9, 8, 10, 8));
    /*List<Integer> list = new LinkedList<>(
            Arrays.asList(1, 5, 5, 9, 8, 10, 8));*/

    boolean result = list.remove((Object) 8);

    assertThat(result).isTrue();
    assertThat(list).isEqualTo(
            Arrays.asList(1, 5, 5, 9, 10, 8));
  }


  @Test
  public void add_elementToIndex_listChanged() {
    List<Integer> list = new ArrayList<>(
            Arrays.asList(1, 5, 5, 9, 8, 10, 8));
    /*List<Integer> list = new LinkedList<>(
            Arrays.asList(1, 5, 5, 9, 8, 10, 8));*/

    list.add(3, 9);

    assertThat(list).isEqualTo(
            Arrays.asList(1, 5, 5, 9, 9, 8, 10, 8));
  }


  @Test
  public void get_elementFromIndex_true() {
    List<Integer> list = new ArrayList<>(
            Arrays.asList(1, 5, 5, 9, 8, 10, 8));
    /*List<Integer> list = new LinkedList<>(
            Arrays.asList(1, 5, 5, 9, 8, 10, 8));*/

    Integer elem = list.get(3);

    assertThat(elem).isEqualTo(9);
  }

  @Test
  public void remove_elementFromIndex_listChanged() {
    List<Integer> list = new ArrayList<>(
            Arrays.asList(1, 5, 5, 9, 8, 10, 8));
    /*List<Integer> list = new LinkedList<>(
            Arrays.asList(1, 5, 5, 9, 8, 10, 8));*/

    Integer elem = list.remove(3);

    assertThat(elem).isEqualTo(9);
    assertThat(list).isEqualTo(
            Arrays.asList(1, 5, 5, 8, 10, 8));
  }

  @Test
  public void sort_naturalOrder_listChanged() {
    List<Integer> list = new ArrayList<>(
            Arrays.asList(1, 5, 5, 9, 8, 10, 8));
    /*List<Integer> list = new LinkedList<>(
            Arrays.asList(1, 5, 5, 9, 8, 10, 8));*/

    list.sort(Comparator.naturalOrder());

    assertThat(list).isEqualTo(
            Arrays.asList(1, 5, 5, 8, 8, 9, 10));
  }

}
