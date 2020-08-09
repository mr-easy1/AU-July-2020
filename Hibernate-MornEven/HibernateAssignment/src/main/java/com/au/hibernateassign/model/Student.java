package com.au.hibernateassign.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Student {

		@Id
		@GeneratedValue
		private Integer studentID;
		
		private String studentName;
		
		private String phonenumber;
//		
//		@OneToMany(mapped by=""studentBooks)
//		private List<Book> studentBooks;
		
		@OneToOne(cascade = CascadeType.PERSIST)
		private Book studentBook;
		
//			@OneToMany(cascade = CascadeType.PERSIST)
//		private List<Book> studentBooks;
		
		
//
//		
//
//		public List<Book> getStudentBooks() {
//			return studentBooks;
//		}
//
//		public void setStudentBooks(List<Book> studentBooks) {
//			this.studentBooks = studentBooks;
//		}

//		public List<Book> getStudentBooks() {
//			return studentBooks;
//		}
//
//		public void setStudentBooks(List<Book> studentBooks) {
//			this.studentBooks = studentBooks;
//		}

		public Book getStudentBook() {
			return studentBook;
		}

		public void setStudentBook(Book studentBook) {
			this.studentBook = studentBook;
		}

		public Integer getStudentID() {
			return studentID;
		}

		public void setStudentID(Integer studentID) {
			this.studentID = studentID;
		}

		public String getStudentName() {
			return studentName;
		}

		public void setStudentName(String studentName) {
			this.studentName = studentName;
		}

		public String getPhonenumber() {
			return phonenumber;
		}

		public void setPhonenumber(String phonenumber) {
			this.phonenumber = phonenumber;
		}


		
}
