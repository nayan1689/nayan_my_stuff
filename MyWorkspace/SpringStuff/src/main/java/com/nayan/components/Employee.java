package com.nayan.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Employee {
	
	Address add;
	Project project;

	Employee(Project m3){
		this.project=m3;
	}
	
	
	Employee(){
    	System.out.println("calling default constructor...");
	}
	
    @Autowired	
	Employee(Address add,Project m3){
    	System.out.println("calling constructor..."+add+"  "+m3);
		this.add=add;
		this.project=m3;
	}

	public Address getAdd() {
		return add;
	}

	@Autowired
	public void setAdd(Address add) {
		 System.out.println("calling add setter..."+add);
		this.add = add;
	}

	public Project getProject() {
		return project;
	}

	 @Autowired
	public void setProject(Project project) {
		this.project = project;
		System.out.println("calling project setter..."+project);
	}

}
