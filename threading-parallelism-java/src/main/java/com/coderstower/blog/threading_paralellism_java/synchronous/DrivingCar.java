package com.coderstower.blog.threading_paralellism_java.synchronous;

public class DrivingCar {
  public static void main(String[] args) {
    long startTime = System.currentTimeMillis();

    CheckBackMirror checkBackMirror = new CheckBackMirror();
    Accelerating accelerating = new Accelerating();

    checkBackMirror.run();
    accelerating.run();

    long endTime = System.currentTimeMillis();

    System.out.println(((endTime - startTime) / 1000) + " seconds");
  }
}
