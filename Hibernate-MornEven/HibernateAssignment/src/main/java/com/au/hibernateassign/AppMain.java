package com.au.hibernateassign;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.au.hibernateassign.model.User;
import com.au.hibernateassign.model.Account;
import com.au.hibernateassign.model.Audit;
public class AppMain 
{
    public static void main( String[] args )
    {
    	
    	
//    	System.out.println("test");
    	
    	//1. Adding all the annotated class  
  Configuration config = new Configuration().configure().addAnnotatedClass(User.class).addAnnotatedClass(Account.class)
                .addAnnotatedClass(Audit.class);
  
  SessionFactory sessionFactory = config.buildSessionFactory();
  Session session = sessionFactory.openSession();

  Account a1 = new Account();
  Account a2 = new Account();
  Account a3 = new Account();
  Account a4 = new Account();
  
  //for initialization of the objects
  EntityDetails ed = new EntityDetails();
  ed.entityDetails(session, a1, a2, a3);
  
 
 TransactionDetails t1 = new  TransactionDetails();
 
 // Task1(a): A successful transaction b/w 2 accounts of the same user
 t1.auditTransaction(700, a2, a3, session); //same user
 
 // Task1(b): A successful transaction b/w 2 accounts of different user
  t1.auditTransaction(800, a1, a2, session); 
  
//Task2: A failed transaction b/w 2 accounts. a2 with a3 and a3 with a4
  t1.auditTransaction(2000, a2, a3, session);
  t1.auditTransaction(300, a3, a4, session); 
  
  session.close();
   }
}
