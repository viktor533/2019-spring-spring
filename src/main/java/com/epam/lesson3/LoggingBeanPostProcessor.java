package com.epam.lesson3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class LoggingBeanPostProcessor implements BeanPostProcessor {

  private final Map<String, Object> beans = new HashMap<>();

  @Override
  public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
    Class<?> beanClass = bean.getClass();
    for (Method method : beanClass.getMethods()) {
      Logging declaredAnnotation = method.getDeclaredAnnotation(Logging.class);
      if (declaredAnnotation != null) {
        beans.put(beanName, bean);
      }
    }
    return bean;
  }

  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    for (String key : beans.keySet()) {
      if (beanName.equals(key)) {
        return Proxy
            .newProxyInstance(bean.getClass().getClassLoader(), bean.getClass().getInterfaces(),
                (proxy1, method, args) -> {
                  long init = System.currentTimeMillis();
                  System.out.println(init);
                  Object result = method.invoke(bean, args);
                  long res = System.currentTimeMillis();
                  System.out.println(res - init);
                  return result;
                });
      }
    }
    return bean;
  }
}
