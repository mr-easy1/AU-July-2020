package com.au.hibernateassign.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.sun.istack.NotNull;

@Entity
@Table
public class Audit {
	
	    @Id
	    @GeneratedValue
	    private Integer transactionId;
	 
	    @NotNull
	    private Integer amount;
	    
        @NotNull
	    @ManyToOne
	    private Account Sender;
	    
	    @NotNull
	    @ManyToOne
	    private Account Receiver;

		public Integer getTransactionId() {
			return transactionId;
		}

		public void setTransactionId(Integer transactionId) {
			this.transactionId = transactionId;
		}

		public Integer getAmount() {
			return amount;
		}

		public void setAmount(Integer amount) {
			this.amount = amount;
		}

		public Account getSender() {
			return Sender;
		}

		public void setSender(Account sender) {
			Sender = sender;
		}

		public Account getReceiver() {
			return Receiver;
		}

		public void setReceiver(Account receiver) {
			Receiver = receiver;
		}
	    
	    
	    
}
