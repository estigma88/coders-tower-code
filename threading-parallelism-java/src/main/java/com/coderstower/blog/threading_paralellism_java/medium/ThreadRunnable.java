package com.coderstower.blog.threading_paralellism_java.medium;

public class ThreadRunnable implements Runnable {
  @Override
  public void run() {
    System.out.println(
            "This is a thread with runnable: " + Thread
                    .currentThread()
                    .getName());
  }
}
