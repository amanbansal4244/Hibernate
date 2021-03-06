package com.aman;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name ="EmployeeBackUp_Annotation")
public class EmployeeBackUp {
	
	@Id
	@GeneratedValue
	@Column(name="EID")
	private int id;
	@Column(name="EFirstName")
	private String firstName;
	private String lastName;
	@Column(name="ESalary")
	private int salary;

	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
