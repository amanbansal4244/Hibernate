package com.aman;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/****
 * According to hibernate, one object of one pojo class related to multiple objects of other pojo,
I mean, one [parent] to many [Children], example of one-to-many is some thing category books contains different type of books, 
one vendor contains lot of customers bla bla.
To achieve one-to-many between two pojo classes in the hibernate, then the following two changes are required
In the parent pojo class, we need to take a collection property, the collection can be either Set,List,Map 
(We will see the example on separate collection later)

 *In the mapping file of that parent pojo class, we need to configure the collection
 *and Vendor class can't have reference variable of Customer because Vendor can have multiple customer.
 *but Customer class can have reference variable of Vendor because Each Customer can have only vendor.
 */
@Entity
@Table(name = "Vendor_Annotation")
public class Vendor{

	@Id
	@Column(name = "VENDOR_ID")
	private int vendorId;

	@Column(name = "vname", length=10)
	private String vendorName;
	/***
	 *  @OneToMany(targetEntity=Customer.class,cascade=CascadeType.ALL)  ->>>> By doing this approach
	 *  Hibernate will be creating one more table(VendorTableName_CustomerTableName) to have relationship between Vendor and Customer.
	 *  
	 *  targetEntity=Customer.class :> (Optional) The entity class that is the target of the association. 
	 *  Optional only if the collection property is defined using Java generics. Must be specified otherwise.
	 */
	@OneToMany(targetEntity=Customer.class,cascade=CascadeType.ALL)
	private Set children;

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
	}

	public Set getChildren() {
		return children;
	}

	public void setChildren(Set children) {
		this.children = children;
	} 

}