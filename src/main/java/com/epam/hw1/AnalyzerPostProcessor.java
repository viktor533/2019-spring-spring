package com.epam.hw1;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class AnalyzerPostProcessor implements BeanPostProcessor {

    private SystemAnalyzer systemAnalyzer = new SystemAnalyzer();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        systemAnalyzer.start();
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        systemAnalyzer.finishAnalyzer();
        return bean;
    }

}
