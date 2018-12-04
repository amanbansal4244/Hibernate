package com.aman;
import javax.persistence.Column;

import javax.persistence.Embeddable;

/****
 * @Embeddable annotation is used to specify the Address class will be used as a component. 
 * The Address class cannot have a primary key of its own, it uses the enclosing class primary key.
 *  and it tells to hibernate that, don’t create a new table for me for Address class.
 */
@Embeddable
public class Address {
	@Column(name = "ADDRESS_STREET_NAME", nullable = false, length=250)
	private String streetName;
	@Column(name = "ADDRESS_CITY", nullable = false, length=50)
	private String city;
	@Column(name = "ADDRESS_STATE", nullable = false, length=50)
	private String state;
	@Column(name = "ADDRESS_ZIPCODE", nullable = false, length=10)
	private String zipcode;
	
	public Address() {
	}
	
	public Address(String streetName, String city, String state, String zipcode) {
		this.streetName = streetName;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}

	
	public String getStreetName() {
		return this.streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	
	public String getCity() {
		return this.city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getState() {
		return this.state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	public String getZipcode() {
		return this.zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
}

