package com.aliyun.skywalkingdemo.demo01;

public class Hello {

  private void sayHello(String helloTo) {
    System.out.println("hello " + helloTo);
  }

  public static void main(String[] args) {
    String helloTo = "bruce";
    new Hello().sayHello(helloTo);
  }
}
