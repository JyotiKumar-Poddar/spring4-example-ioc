package com.springexample.app.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springexample.app.bean.HelloWorld;
import com.springexample.app.bean.impl.MessageBean;
import com.springexample.app.service.HelloWorldService;

@SuppressWarnings("restriction")
@Service
public class HelloWorldServiceImpl implements HelloWorldService {
	
	@Autowired
	HelloWorld helloWorld;  //  Injecting bean using @Autowired annotation
	
	@Resource(name="helloWorldBean")  //  Injecting bean using @Resource annotation
	HelloWorld helloWorldAsResource;
	
	@Resource(name="message-bean")
	MessageBean messageBean;
	
	/* (non-Javadoc)
	 * @see com.springbyexample.app.service.impl.helloWorldService#getMessageService()
	 */
	public String getMessageService() {
		System.out.println("=================Using as @Autowired==="
				+ messageBean.toString());
		System.out.println("=================Using as @Resource==="
				+ helloWorldAsResource.getMessage());
		return helloWorld.getMessage();
	}
}
