package com.coderstower.blog.java_collections_array_list_vs_linked_list;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class MapTest {
  private Map<String, String> signaturesByClassroom;

  @Before
  public void before() {
    signaturesByClassroom = new HashMap<>();
  signaturesByClassroom = new TreeMap<>();

    signaturesByClassroom.put("A", "Math");
    signaturesByClassroom.put("B", "Math");
    signaturesByClassroom.put("C", "Math");
    signaturesByClassroom.put("D", "Math");
    signaturesByClassroom.put("E", "Math");
  }

  @Test
  public void put_newElement_mapChanged() {
    signaturesByClassroom.put("C", "Art");

    assertThat(signaturesByClassroom.get("C"))
            .isEqualTo("Art");
  }


  @Test
  public void get_oldElement_mapChanged() {
    assertThat(signaturesByClassroom.get("A"))

            .isEqualTo("Math");
  }

  @Test
  public void remove_element_true() {
    assertThat(signaturesByClassroom.remove("A"))
            .isEqualTo("Math");
  }

  @Test
  public void containsKey_element_true() {
    boolean result = signaturesByClassroom
            .containsKey("A");

    assertThat(result).isTrue();
  }


  @Test
  public void keySet() {
    Set<String> keySet = signaturesByClassroom
            .keySet();

    assertThat(new ArrayList<>(keySet)).isEqualTo(
            Arrays.asList("A"));
  }

  @Test
  public void values() {
    Collection<String> values = signaturesByClassroom
            .values();

    assertThat(new ArrayList<>(values)).isEqualTo(
            Arrays.asList("Math"));
  }

  @Test
  public void entries() {
    Set<Map.Entry<String, String>> entries = signaturesByClassroom
            .entrySet();

    assertThat(new ArrayList<>(entries)).isEqualTo(
            Arrays.asList(new AbstractMap.SimpleImmutableEntry("A", "Math")));
  }

}
