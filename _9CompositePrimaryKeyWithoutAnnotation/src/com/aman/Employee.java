package com.aman;

import java.io.Serializable;

/**class must implements the Serializable interface if data type of bean is 'primitive' data type if you want to use 'Composite Primary Key'.
 * and class must does not need to implement the Serializable interface if data type of bean is 'Wrapper' data type 
 * if you want to use 'Composite Primary Key'.
 */
public class Employee implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String firstName,lastName;
	private int salary;

	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
