package com.epam.lesson3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VerySimpleHelloWorldService implements HelloWorldService {

  private final VerySimpleHelloWorldService service;

  @Autowired
  public VerySimpleHelloWorldService(VerySimpleHelloWorldService service) {
    this.service = service;
  }

  @Override
  @Logging
  public String doSmt(String name) {
    String smt = name.concat("smt");
    service.secondMethod();
    return smt;
  }

  @Override
  public void secondMethod() {
    System.out.println("some");
  }
}
