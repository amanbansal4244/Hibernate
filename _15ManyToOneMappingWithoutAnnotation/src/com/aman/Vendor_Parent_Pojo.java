package com.aman;
import java.util.Set;
/****
 * In many to one relationship, when ever child object is loaded from the database then automatically
 *  the parent object will also be loaded from the database. Let us an example on selecting single child object with its parent object.
 *  But remember, in many to one we can see 2 types of object loadings (selecting)
 *  		proxy
 *  		early loading
 *  
 *  In many to one relationship, the lazy attribute (in mapping xml) values are either proxy or false.  
 *  If we write lazy=”false” then when ever child object is loading then immediately parent object will also be loading from the database.
 *  The default value of lazy is proxy, means here when ever child object is loaded then parent object is not loaded immediately, 
 *  but a proxy object will be loaded with it (logical object)
 *  
 *  When ever the parent object is accessed then at that moment that parent object will be loaded from the database.
 */
public class Vendor_Parent_Pojo {
	private int vendorId;
	private String vendorName;

	public int getVendorId() {
		return vendorId;
	}
	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	} }