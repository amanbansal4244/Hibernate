package com.aman;
public class Customer {

	private int customerId;
	private String customerName;
	
	private int vendorIdAsFK;//This will be used a foreign key and will store the PK of 'Vendor' table.

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
	}

	public int getVendorIdAsFK() {
		return vendorIdAsFK;
	}
	public void setVendorIdAsFK(int vendorId) {
		this.vendorIdAsFK = vendorId;
	}

}