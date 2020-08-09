package com.au.hibernateassign;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.au.hibernateassign.model.Account;
import com.au.hibernateassign.model.User;

public class EntityDetails {
	
//Initialization of the entity 	
	public void entityDetails(Session session, Account a1, Account a2, Account a3)
	{
		
		// Adding two users into the db using User class 
		
        User u1 = new User();
        u1.setUserId(1);
        u1.setUserName("aalam");

        User u2 = new User();
        u2.setUserId(2);
        u2.setUserName("kalam");
        
        //account 1 for user 1
        a1.setAccountId(1);
        a1.setAmount(3000);
        a1.setAccountUser(u1);
        
        //account 2 for user 2
        a2.setAccountId(2);
        a2.setAmount(600);
        a2.setAccountUser(u2); 
        
        //account 3 for user 2
        a3.setAccountId(3);
        a3.setAmount(3000);
        a3.setAccountUser(u2); 
        

        Transaction firsttransaction = session.beginTransaction();

        session.persist(u1);
        session.persist(u1);
        session.persist(u1);
        session.persist(u1);
        session.persist(u1);
//        session.save(u2);
//        session.save(a1);
//        session.save(a2);
//        session.save(a3);

        firsttransaction.commit();

		
	}
	
	
	
}
