package com.springexample.app.bean.impl;

import org.springframework.beans.factory.annotation.Value;

import com.springexample.app.bean.IMessageBean;


public class MessageBean implements IMessageBean {

	@Value("Welcome to the world of Spring !")
	private String greetingMessage;
	
	@Value("Hi There! ")
	private String greetingTime;

	@Override
	public String toString() {
		return "MessageBean [greetingMessage=" + greetingMessage
				+ ", greetingTime=" + greetingTime + "]";
	}
	
	public void printMesage() {
		System.out.println(toString());
		
	}
	
}
