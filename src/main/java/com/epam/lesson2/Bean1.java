package com.epam.lesson2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")
public class Bean1 {

  private final Bean2 bean2;

  @Autowired
  public Bean1(Bean2 bean2) {
    this.bean2 = bean2;
  }

  public void soSmt() {
    System.out.println("Hello world");
  }

  public void init() {
    System.out.println(42);
  }

  @Override
  public String toString() {
    return "Bean1{}";
  }

  public void preDestroy() {

  }
}
