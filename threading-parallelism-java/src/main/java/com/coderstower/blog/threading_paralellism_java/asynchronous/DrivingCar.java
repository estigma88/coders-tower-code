package com.coderstower.blog.threading_paralellism_java.asynchronous;

public class DrivingCar {
  public static void main(String[] args)
          throws InterruptedException {
    long startTime = System.currentTimeMillis();

    CheckBackMirror checkBackMirror = new CheckBackMirror();
    Thread checkBackMirrorThread = new Thread(checkBackMirror);

    Accelerating accelerating = new Accelerating();
    Thread acceleratingThread = new Thread(accelerating);

    checkBackMirrorThread.start();
    acceleratingThread.start();

    checkBackMirrorThread.join();
    acceleratingThread.join();

    long endTime = System.currentTimeMillis();

    System.out.println(((endTime - startTime) / 1000) + " seconds");
  }
}
