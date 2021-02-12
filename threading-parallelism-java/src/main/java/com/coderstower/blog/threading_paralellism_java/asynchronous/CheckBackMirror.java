package com.coderstower.blog.threading_paralellism_java.asynchronous;

public class CheckBackMirror implements Runnable {
  @Override
  public void run() {
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
    }
  }
}
