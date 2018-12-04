package com.aman;
import java.util.HashSet;
import java.util.Set;
 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
 
public class ForOurLogic_InsertQuery { 
 
 public static void main(String args[])
 {
	 Configuration cfg = new AnnotationConfiguration();
	 cfg.configure("hibernate.cfg.xml"); 

	 SessionFactory factory = cfg.buildSessionFactory();
	 Session ses = factory.openSession(); 

	 Categories c1 = new Categories();
	 c1.setCategoryId(1);
	 c1.setCategoryName("cat 1");

	 Categories c2=new Categories();
	 c2.setCategoryId(2);
	 c2.setCategoryName("cat 2");

	 Item i1=new Item();
	 Item i2 = new Item();

	 i1.setItemId(101);
	 i1.setItemName("item1");

	 i2.setItemId(102);
	 i2.setItemName("item2");

	 Set  s =new HashSet();
	 s.add(i1);
	 s.add(i2);

	 c1.setItems(s);
	 c2.setItems(s);

	 Transaction tx = ses.beginTransaction();
	 ses.save(c1);
	 ses.save(c2);
	 tx.commit();
	 System.out.println("Man to Many using annotations been done...!!!!!");
	 ses.close();
 }
 
}
