package com.aliyun.skywalkingdemo.demo04;

import org.apache.skywalking.apm.toolkit.trace.Trace;

public class HelloActive {

  @Trace
  private void sayHello(String helloTo) {
    String helloStr = formatString(helloTo);
    printHello(helloStr);
  }

  @Trace
  private String formatString(String helloTo) {
    return String.format("Hello, %s!", helloTo);
  }

  @Trace
  private void printHello(String helloStr) {
    System.out.println(helloStr);
  }

  public static void main(String[] args) {
    if (args.length != 1) {
      throw new IllegalArgumentException("Expecting one argument");
    }
    String helloTo = args[0];
    new HelloActive().sayHello(helloTo);
    try {
      Thread.sleep(1000 * 100);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
