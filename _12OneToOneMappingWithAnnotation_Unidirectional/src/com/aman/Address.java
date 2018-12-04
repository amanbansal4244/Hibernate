package com.aman;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
 
@Entity
@Table(name="Address_Annotation")
public class Address {

	@Id
	@Column(name="addrid")
	private  int addressId;

	@Column(name="place",length=10)
	private String place;

	/****
	 *Main concept of hibernate relations is to getting the relation between parent and child class objects.
	* Cascade atturibute is mandatory, when ever we apply relationship between objects, cascade attribute transfers operations done on one object 
	* onto its related child objects.
	* If we write cascade = “all” then changes at parent class object will be effected to child class object too, 
	* if we write cascade = “all” then all operations like insert, delete, update at parent object will be effected to child object also
	* Example: if we apply insert(or update or delete) operation on parent class object, then child class objects will also be stored into the database.
	* default value of cascade =”none” means no operations will be transfers to the child class.
	
	*joinColumns(name="stu_id")) -> using this foreign key name of Student table("student_annotation") in Address table("Address_Annotation")
	* 							   will be "stu_id". If we don't write then hibernate will automatically creates new column for FK in
	* 							   Address table("Address_Annotation") and this annotation is optional.
	* 
	 */
	@OneToOne(targetEntity=Student.class,cascade=CascadeType.ALL)
	@JoinColumn(name="stu_id",referencedColumnName="sid") // In DB, column name would be displaying with name 'stu_id' instead of 'sid'
	private  Student  parent;

	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public Student getParent() {
		return parent;
	}
	public void setParent(Student parent) {
		this.parent = parent;
	}

}
