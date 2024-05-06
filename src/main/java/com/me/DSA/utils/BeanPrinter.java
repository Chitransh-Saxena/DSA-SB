package com.me.DSA.utils;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class BeanPrinter implements CommandLineRunner {

    private final ApplicationContext context;

    public BeanPrinter(ApplicationContext context) {
        this.context = context;
    }

    @Override
    public void run(String... args) {
//        String[] beanNames = context.getBeanDefinitionNames();
//        for (String beanName : beanNames) {
//            System.out.println(beanName);
//        }
    }
}
