package com.epam.lesson2;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class EpamLabBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

  @Override
  public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
    System.out.println("43");
    System.out.println("I'm real beanfactory post proc");
    System.out.println(beanFactory.getBeanClassLoader());
    if (!beanFactory.containsBean("bean1")) {
      throw new RuntimeException("very important bean always should be in context!1!!");
    }
  }
}
