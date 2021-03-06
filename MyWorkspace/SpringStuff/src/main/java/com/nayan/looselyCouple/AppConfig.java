package com.nayan.looselyCouple;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractApplicationContext;


@Configuration
@ComponentScan(basePackages="com.nayan.looselyCouple")
public class AppConfig {

	public static void main(String[] args) {
		
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		((OutputGeneratorHelper)context.getBean("outputGeneratorHelper")).generateOutput("JasonGenerator");

	}

}
