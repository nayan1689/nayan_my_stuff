package com.nayan.components;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
public class Project {

	String projectName;
	
	Project(){
		System.out.println("Project.Project()"+this);
		
	}
	
}
