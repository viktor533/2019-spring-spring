package com.epam.hw1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class Test1 {

    public static void main(String[] args) {
        ApplicationContext classPathXmlApplicationContext = new AnnotationConfigApplicationContext("com.epam.hw1");
        Bean bean = (Bean)classPathXmlApplicationContext.getBean(MegaRecursiveCalc.class);
//        bean.
        System.out.println();

//        System.out.println(classPathXmlApplicationContext.getBean("bean1"));
    }


}
