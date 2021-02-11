package com.coderstower.blog.threading_paralellism_java.medium;

public class Main {
  public static void main(String[] args) {
    System.out.println(
            "Thread name: " + Thread.currentThread()
                    .getName());

    ThreadInheritance threadInheritance = new ThreadInheritance();
    threadInheritance.start();

    ThreadRunnable runnable = new ThreadRunnable();
    Thread threadRunnable = new Thread(runnable);
    threadRunnable.start();
  }
}
