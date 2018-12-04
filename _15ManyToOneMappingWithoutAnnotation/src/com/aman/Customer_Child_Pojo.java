package com.aman;
public class Customer_Child_Pojo 
{
	private int customerId;
	private String customerName;
	
	private Vendor_Parent_Pojo parentObjects;

	public Vendor_Parent_Pojo getParentObjects() {
		return parentObjects;
	}
	public void setParentObjects(Vendor_Parent_Pojo parentObjects) {
		this.parentObjects = parentObjects;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}}