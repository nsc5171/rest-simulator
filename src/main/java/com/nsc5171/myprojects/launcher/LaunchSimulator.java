package com.nsc5171.myprojects.launcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class LaunchSimulator {

    public static void main(String[] a){
        ApplicationContext context=SpringApplication.run(LaunchSimulator.class);
        String[] beans=context.getBeanDefinitionNames();
        Arrays.sort(beans);
        for(String s:beans){
            System.out.println(s);
        }
    }
}
