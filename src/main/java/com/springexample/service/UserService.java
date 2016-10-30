package com.springexample.service;
import org.springframework.stereotype.Service;
@Service
public class UserService {
	public Integer multiply(int a, int b){
		int res = a*b;
		System.out.println(a+ "*" + b +"= " + res);
		return res;
	}
}
