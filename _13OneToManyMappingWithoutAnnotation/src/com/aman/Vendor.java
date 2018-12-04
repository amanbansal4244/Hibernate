package com.aman;
import java.util.Set;
/****
 * According to hibernate, one object of one pojo class related to multiple objects of other pojo
I mean, one [parent] to many [Children], example of one-to-many is some thing category books contains different type of books, 
one vendor contains lot of customers bla bla.
To achieve one-to-many between two pojo classes in the hibernate, then the following two changes are required
In the parent pojo class, we need to take a collection property, the collection can be either Set,List,Map 
(We will see the example on separate collection later)
In the mapping file of that parent pojo class, we need to configure the collection
 * @author bansal
 *
 */
public class Vendor {
 
private int vendorId;
private String vendorName;

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