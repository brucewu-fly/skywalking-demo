package com.aliyun.skywalkingdemo.demo03;

import org.apache.skywalking.apm.toolkit.trace.ActiveSpan;
import org.apache.skywalking.apm.toolkit.trace.Trace;
import org.apache.skywalking.apm.toolkit.trace.TraceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

  private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

  @RequestMapping("/hello")
  public String hello() {
    LOGGER.info("hello");
    f1();
    f2();
    return "Hello from Spring Boot!";
  }

  @Trace
  private void f1() {
    LOGGER.info("f1");
    ActiveSpan.tag("t1", "v1");
    System.out.println("traceId：" + TraceContext.traceId());
    try {
      Thread.sleep(1000);
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("f1");
  }

  @Trace
  private void f2() {
    LOGGER.info("f2");
    try {
      Thread.sleep(500);
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("f2");
  }
}