package com.au.hibernateassign;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.au.hibernateassign.model.Account;
import com.au.hibernateassign.model.Audit;

public class TransactionDetails {
	
	public void auditTransaction(int amount, Account account1, Account account2, Session session){

        Transaction transaction = session.beginTransaction();

        Audit audit = new Audit();
        audit.setSender(account1);
        audit.setReceiver(account2);
        audit.setAmount(amount);
        session.save(audit);
        
           //Assumption: Only the successful transactions are saved. 
           //Case: When the user is having sufficient amount in the account.
        if(account1.getAmount() > amount) {
            System.out.println("debit is possible");
            int temp = account1.getAmount() - amount;
            account1.setAmount(temp);

            try {
            	//Case: Crediting to the account is always possible(Assumption: User have atleast 1 rupee in the account)
                if (account2.getAmount() > 0) {
                    int temp1 = account2.getAmount() + amount;
                    account2.setAmount(temp1);
                    System.out.println("**********Transactions committed successfully********"+"Now the current amount="+temp1); 
                    transaction.commit();
                }
            }
            catch(Exception e){
                //Case: Where the receivers account number is not right results to rollback of the transaction
                transaction.rollback();
                System.out.println("********Transactions failed Check once again the receiver's account number*****");
            }
        }
        else {
            System.out.println("Less amount in the Account credit amount first for the debit operation");
            transaction.rollback();
            System.out.println("**********Transaction aborted*********");
        }
    }
	

}
