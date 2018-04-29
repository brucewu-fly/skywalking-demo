package com.aliyun.skywalkingdemo.demo05;

import io.opentracing.ActiveSpan;
import io.opentracing.Tracer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloOpenTracing {

  private static final Logger LOGGER = LoggerFactory.getLogger(HelloOpenTracing.class);

  private Tracer tracer = new org.apache.skywalking.apm.toolkit.opentracing.SkywalkingTracer();

  public void helloOpenTracing() {
    try (ActiveSpan activeSpan = tracer.buildSpan("helloOpenTracing").startActive()) {
      activeSpan.setTag("t1", "v1");
      System.out.println("helloOpenTracing");
      LOGGER.info("helloOpenTracing");
      f1();
      f2();
    }
  }

  private void f1() {
    try (ActiveSpan activeSpan = tracer.buildSpan("f1").startActive()) {
      activeSpan.log("log_event_f1");
      LOGGER.info("f1");
      try {
        Thread.sleep(1000);
      } catch (Exception e) {
        e.printStackTrace();
      }
      System.out.println("f1");
    }
  }

  private void f2() {
    try (ActiveSpan activeSpan = tracer.buildSpan("f2").startActive()) {
      activeSpan.log("log_event_f2");
      LOGGER.info("f");
      try {
        Thread.sleep(500);
      } catch (Exception e) {
        e.printStackTrace();
      }
      System.out.println("f2");
    }
  }

  public static void main(String[] args) {
    new HelloOpenTracing().helloOpenTracing();
  }

}
