package com.springexample.app.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springexample.app.bean.HelloWorld;
import com.springexample.app.bean.impl.MessageBean;
import com.springexample.app.service.helloWorldService;

@Service
public class HelloWorldServiceImpl implements helloWorldService {
	
	@Autowired
	HelloWorld helloWorld;
	
	@Resource(name="helloWorldBean")
	HelloWorld helloWorldAsResource;
	
	@Resource(name="message-bean")
	MessageBean messageBean;
	
	
	/* (non-Javadoc)
	 * @see com.springbyexample.app.service.impl.helloWorldService#getMessageService()
	 */
	public String getMessageService() {

		System.out.println(messageBean.toString());
		System.out.println("=================Using as Resource===");
		System.out.println(helloWorldAsResource.getMessage());
		System.out.println("=================Using as Resource End===");
		return helloWorld.getMessage();
	}
}
