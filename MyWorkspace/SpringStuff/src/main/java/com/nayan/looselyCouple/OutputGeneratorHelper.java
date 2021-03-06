package com.nayan.looselyCouple;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OutputGeneratorHelper {
	
	Map<String,OutputGenerator> mapOfOG;

	@Autowired
	public void init(List<OutputGenerator> listOG){
		mapOfOG = new HashMap<String, OutputGenerator>();
		for(OutputGenerator og : listOG){
			mapOfOG.put(og.getClass().getSimpleName(), og);
		}
	}
	
	public void generateOutput(String type){
		System.out.println("generating output");
		mapOfOG.get(type).generateOutput();
	}
	
	
	
	
}
