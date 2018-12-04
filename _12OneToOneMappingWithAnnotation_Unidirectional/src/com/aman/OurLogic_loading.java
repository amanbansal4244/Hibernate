package com.aman;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class OurLogic_loading {
 
 public static void main(String args[])
 {
 
 Configuration cfg = new AnnotationConfiguration();
 cfg.configure("hibernate.cfg.xml"); 
 
 SessionFactory factory = cfg.buildSessionFactory();
 Session session = factory.openSession(); 
 
        Object o = session.get(Address.class, new Integer(3));
        Address a = (Address)o;
        System.out.println("Address city:"+ a.getPlace());
 
        Student s=a.getParent();
        System.out.println("Student name :"+s.getStudentName());
 
     session.close();
     System.out.println("One to One loading is Done..!!");
     factory.close();
 
 }
}