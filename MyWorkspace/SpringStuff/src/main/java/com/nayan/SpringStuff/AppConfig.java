package com.nayan.SpringStuff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
/**
 * Hello world!
 *
 */
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Component;

import com.nayan.components.Employee;
@Configuration
@ComponentScan(basePackages="com.nayan")
@Component
public class AppConfig 
{
	@Autowired
	Employee employee;
    /**
     * @param args
     */
    /**
     * @param args
     */
    public static void main( String[] args )
    {
    
    	AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    	System.out.println(context.getBean("helloWord"));
    	System.out.println("Shutting Down");
    	context.registerShutdownHook();
    	
    	
    }
}
