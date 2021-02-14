package com.coderstower.blog.threading_paralellism_java.medium;

public class ThreadInheritance extends Thread {
  @Override
  public void run() {
    System.out.println(
            "This is a thread with inheritance: " + Thread
                    .currentThread()
                    .getName());
  }
}
