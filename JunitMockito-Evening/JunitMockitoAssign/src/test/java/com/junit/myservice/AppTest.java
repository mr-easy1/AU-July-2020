package com.junit.myservice;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;

import com.junit.entity.User;

public class AppTest {

//	@Test
//	public void test() {
//		fail("Not yet implemented");
//	}
	

	  @InjectMocks
	  App app;
	  
	  
	  @Test
	  public void adduser()
	  {
		User user = new User();
		user.setName("aalam");
		user.setEmail("aalam@gmail.com");
		user.setAge(24);
		user.setCity("pnb");
		Assert.assertEquals(true, App.addUser(user));
	  }
	  
	  @Test
	  public void addUserNull()
	  {
		  User user = null;
		  Assert.assertEquals(false,App.addUser(user));
	  }	
		
	  @Test
	  public void checkNameValid()
	  {
		  String name = "aalam";
		  Assert.assertEquals(true,App.checkName(name));
	  }	 
	  @Test
	  public void checkNameInValidSpecialCharacter()
	  {
		  String name = "aalam#aalam";
		  Assert.assertEquals(false,App.checkName(name));
	  }
	  
	  
	  
	  @Test
	  public void checkEmailValid()
	  {
		  String email = "aalam123@gmail.com";
		  Assert.assertEquals(true,App.checkEmail(email));
	  }

	  @Test
	  public void checkEmailInValid()
	  {
		  String email = "aalam123@gmail..com";
		  Assert.assertEquals(false,App.checkEmail(email));
	  }
	  
	  @Test
	  public void checkAgeValid()
	  {
		  int age = 24;	  
		  Assert.assertEquals(true,App.checkAge(age));
	  }

	  @Test
	  public void checkAgeMinInvalid()
	  {
		  int age = 0;	  
		  Assert.assertEquals(false,App.checkAge(age));
	  }

	  @Test
	  public void checkAgeMaxInvalid()
	  {
		  int age = 101;	  
		  Assert.assertEquals(false,App.checkAge(age));
	  }
	  
	  @Test
	  public void checkAgeMaxValid()
	  {
		  int age = 100;	  
		  Assert.assertEquals(true,App.checkAge(age));
	  }
	  

	

}
