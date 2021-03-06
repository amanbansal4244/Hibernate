package com.aman;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Cacheable;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


@Entity
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
@Table(name ="Employee_Annotation")
public class Employee {
	
	@Id
	@GeneratedValue
	@Column(name="EID")
	private int id;
	@Column(name="EFirstName")
	private String firstName;
	
	/****
	 * If we don't add @Column annotation then hibernate automatically created column with field name .
	 * or we can add @Basic annotation or don't write any annotation when we don't want to give new name as column name.
	 */
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
