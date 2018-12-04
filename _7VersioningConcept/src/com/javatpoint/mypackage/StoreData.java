package com.javatpoint.mypackage;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.javatpoint.mypackage.Employee;

public class StoreData {
	public static void main(String[] args) {

		//creating configuration object
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file

		//creating session factory object
		SessionFactory factory=cfg.buildSessionFactory();

		//creating session object
		Session session=factory.openSession();

		Employee e1=new Employee();
		e1.setId(323); // its gives unique attribute in class to the primary key of the DB table.
		e1.setFirstName("amawwn12222");
		e1.setLastName("bansal22212");

		/**We can write below two line code outside transaction body as well but we have to commit on transaction to save the data in DB.
		 * because by default in hibernate, auto commit is false.
		 */
		//session.save(e1);
		session.persist(e1);

		//creating transaction object
		Transaction t=session.beginTransaction();

		//We can write below two line code within transaction body as well.
		//session.save(e1);
		//session.persist(e1);
		t.commit();

		session.close();
		factory.close();
		System.out.println("successfully saved");

}
}
