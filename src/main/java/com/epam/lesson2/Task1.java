package com.epam.lesson2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Task1 {

  public static void main(String[] args) {
    ApplicationContext classPathXmlApplicationContext = new AnnotationConfigApplicationContext("com.epam.lesson2");
    System.out.println(classPathXmlApplicationContext.getBean(Bean1.class));
    System.out.println(classPathXmlApplicationContext.getBean("bean1"));
  }
}
