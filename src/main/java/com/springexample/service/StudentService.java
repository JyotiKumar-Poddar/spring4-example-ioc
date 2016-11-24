package com.springexample.service;

import com.springexample.aspect.JournalActivity;

public class StudentService {
	
	@JournalActivity(value="Journal activity tracing ;)")
	public void printData(){
		System.out.println("==========***********************==========");
	}
}
