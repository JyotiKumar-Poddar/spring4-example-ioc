package com.springexample.app.bean.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.springexample.app.bean.FirstInterface;

public class FirstImpl implements FirstInterface {
	
	private SecondImpl impl;
	@Autowired
	public void setImpl(SecondImpl impl) {
		System.out.println("==========Set method called setImpl=============");
		this.impl = impl;
	}
	public void printMessage() {
		System.out.println("=======FirstImpl========"+impl);
	}

}
