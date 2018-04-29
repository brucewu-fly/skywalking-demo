package com.aliyun.skywalkingdemo.demo06;

import org.apache.skywalking.apm.toolkit.trace.Trace;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloLog {

  private static final Logger LOGGER = LoggerFactory.getLogger(HelloLog.class);

  @Trace
  private void sayHello(String helloTo) {
    LOGGER.info("sayHello " + helloTo);
    String helloStr = formatString(helloTo);
    printHello(helloStr);
  }

  @Trace
  private String formatString(String helloTo) {
    LOGGER.info("formatString " + helloTo);
    return String.format("Hello, %s", helloTo);
  }

  @Trace
  private void printHello(String helloStr) {
    LOGGER.info("printHello " + helloStr);
    System.out.println(helloStr);
  }

  public static void main(String[] args) {
    new HelloLog().sayHello("log");
  }

}
