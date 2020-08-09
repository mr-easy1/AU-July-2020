package com.junit.myservice;

import com.junit.entity.User;

public interface MyService {
	   public boolean addUser(User user);
	   public boolean checkName(String name);
	   public boolean checkEmail(String email);
	   public boolean checkAge(int age);
	   

}
