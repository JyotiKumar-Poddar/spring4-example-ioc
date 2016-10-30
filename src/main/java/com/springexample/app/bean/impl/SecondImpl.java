package com.springexample.app.bean.impl;

import com.springexample.app.bean.SecondInterfacae;

public class SecondImpl implements SecondInterfacae {
	
	private FirstImpl firstImpl;
	public void setFirstImpl(FirstImpl firstImpl) {
		System.out.println("==========Set method called setFirstImpl=============");
		this.firstImpl = firstImpl;
	}

	
	public void printMessage() {
		System.out.println("====SecondImpl====="+firstImpl);
	}
	
}
