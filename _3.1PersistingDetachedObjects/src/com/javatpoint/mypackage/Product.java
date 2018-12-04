package com.javatpoint.mypackage;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name ="PProduct")
@org.hibernate.annotations.Entity(selectBeforeUpdate=true)
public class Product {
	
	@Id
	@GeneratedValue
	@Column(name="PID")
	private int id;
	@Column(name="PPrice")
	private String price;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	
}
