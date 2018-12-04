package com.aman;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


@Entity
@Table(name ="Employee_MoreAnnotation")
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="EID")
	private int id;
	
	/****
	 * The @Embedded annotation is used to specify the Address entity should be stored in the STUDENT table as a component.
	 * and this is optional since we have marked Address class as @Embeddable
	 * We just write here, because its gives more clarification to developer that this Address entity
	 * is going to store in the STUDENT table as a component.
	 * 
	 * @AttributeOverride -> In this example.,I am overriding the name of field 'streetName' column name of Address class
	 *  with name 'HOME_STREET_NAME'
	 *  
	 *  Note : If we want to use same column name as defined in Address class then use only @Embedded annotation.
	 */
	@Embedded
	@AttributeOverride(name="streetName",column=@Column(name="HOME_STREET_NAME"))
	private Address home_address;
	
	/****
	 * If we need to override two property of any object, the we should wrap the @AttributeOverride to  @AttributeOverrides
	 * @AttributeOverrides specifies the array of @AttributeOverride
	 */
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="streetName",column=@Column(name="OFFICE_STREET_NAME")),
		@AttributeOverride(name="city",column=@Column(name="OFFICE_CITY_NAME")),
		@AttributeOverride(name="state",column=@Column(name="OFFICE_STATE")),
		@AttributeOverride(name="zipcode",column=@Column(name="OFFICE_ZIPCODE"))
	})
	private Address office_address;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Address getHome_address() {
		return home_address;
	}
	public void setHome_address(Address home_address) {
		this.home_address = home_address;
	}
	public Address getOffice_address() {
		return office_address;
	}
	public void setOffice_address(Address office_address) {
		this.office_address = office_address;
	}
}
