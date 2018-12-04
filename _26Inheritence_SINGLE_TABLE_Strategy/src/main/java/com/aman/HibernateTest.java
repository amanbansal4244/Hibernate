package com.aman;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
 
public class HibernateTest {
	
	@SuppressWarnings("unused")
	public void test() {

		/****
		 * In Hibernate 3.6, “org.hibernate.cfg.AnnotationConfiguration” is deprecated, 
		 * and all its functionality has been moved to “org.hibernate.cfg.Configuration“.
		 * So , you can safely replace your “AnnotationConfiguration” with “Configuration” class.
		 */
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file

		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		Transaction tx= session.beginTransaction();
		
		Vehicle vehicle1 = new Vehicle();
		vehicle1.setVehicleName("Car");
		
		TwoWheeler twoWheelerVehicle = new TwoWheeler();
		twoWheelerVehicle.setVehicleName("Bike");
		twoWheelerVehicle.setSteeringTwoWheeler("Bike Steering Handle");
		
		FourWheeler fourWheelerVehicle = new FourWheeler();
		fourWheelerVehicle.setVehicleName("Porsche");
		fourWheelerVehicle.setSteeringFourWheeler("Porsche Steering Wheel");

		session.save(vehicle1);
		session.save(twoWheelerVehicle);
		session.save(fourWheelerVehicle);
		
		tx.commit();
		session.close();
		
	}
	
	public static void main(String[] args) {
		new HibernateTest().test();
	}
}

