package com.junit.myservice;

import com.junit.entity.User;

public class App {
	
	static MyService myService=new MyServiceImplementation();
	
public static boolean addUser(User user) {
		
		return myService.addUser(user);
	}

public static boolean checkName(String name) {
	return myService.checkName(name);
}


	public static boolean checkEmail(String email) {
		return myService.checkEmail(email);
	}

	public static boolean checkAge(int age) {
		return myService.checkAge(age);
	}

	}
	


