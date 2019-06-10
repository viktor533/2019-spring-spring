package com.epam.lesson3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

  public static void main(String[] args) {
    AnnotationConfigApplicationContext annotationConfigApplicationContext
        = new AnnotationConfigApplicationContext("com.epam.lesson3");
    HelloWorldService bean = annotationConfigApplicationContext
        .getBean(HelloWorldService.class);
    System.out.println(bean.doSmt("hello_world"));
  }
}
