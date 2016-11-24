package com.springexample.service;
import org.springframework.stereotype.Service;

import com.springexample.aspect.JournalActivity;
@Service
public class UserService {
	@JournalActivity() // to implement advice using custom annotation
	public Integer multiply(int a, int b){
		int res = a*b;
		System.out.println(a+ "*" + b +"= " + res);
		return res;
	}
}
