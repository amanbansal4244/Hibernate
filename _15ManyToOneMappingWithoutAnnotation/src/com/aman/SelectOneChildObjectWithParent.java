package com.aman;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
 
public class SelectOneChildObjectWithParent {
 
 public static void main(String args[])
 {
 
 Configuration cfg = new Configuration();
 cfg.configure("hibernate.cfg.xml"); 
 
 SessionFactory factory = cfg.buildSessionFactory();
 Session session = factory.openSession(); 
 
 Object o = session.get(Customer_Child_Pojo.class, new Integer(506));
 Customer_Child_Pojo c = (Customer_Child_Pojo)o;
 
 System.out.println(c.getCustomerName());
 Vendor_Parent_Pojo v=c.getParentObjects();
 System.out.println(v.getVendorName()); 
 
     session.close();
     System.out.println("many to one select is done..!!");
     factory.close();       
 
 }
}
