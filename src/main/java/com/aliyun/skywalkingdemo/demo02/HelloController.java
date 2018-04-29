package com.aliyun.skywalkingdemo.demo02;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

  @RequestMapping("/hello")
  public String hello() {
    // f1，f2 并不会被记录
    f1();
    f2();
    return "Hello from Spring Boot!";
  }

  private void f1() {
    try {
      Thread.sleep(1000);
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("f1");
  }

  private void f2() {
    try {
      Thread.sleep(500);
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("f2");
  }
}
