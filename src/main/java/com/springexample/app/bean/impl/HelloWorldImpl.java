package com.springexample.app.bean.impl;

import java.beans.ConstructorProperties;

import com.springexample.app.bean.HelloWorld;

public class HelloWorldImpl implements HelloWorld {

	/* (non-Javadoc)
	 * @see com.springbyexample.app.HelloWorld#getMessage()
	 */
	
	private String ultimateAnswer;
	private int years;

	@ConstructorProperties({"years", "ultimateAnswer"})
	public HelloWorldImpl(int years, String ultimateAnswer) {
		this.years = years;
		this.ultimateAnswer = ultimateAnswer;
	}
	
	public String getMessage() {
		return "Hello World======================="+ultimateAnswer+years;
	}
	
	public void setup() {
		System.out.println("============Setup is called=============");
	}
	
	
	
	public void cleanup() {
		System.out.println("=================Clean up is called================");
	}

}




