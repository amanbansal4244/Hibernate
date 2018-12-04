package com.javatpoint.mypackage;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.javatpoint.mypackage.Employee;

public class StoreData {
	public static void main(String[] args) {

		// creating configuration object
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");// populates the data of the configuration file

		// creating session factory object
		SessionFactory factory = cfg.buildSessionFactory();

		// creating session object
		Session session = factory.openSession();

		Employee e1 = new Employee();
		e1.setId(45555); // its gives unique attribute in class to the primary key of the DB table.
		e1.setFirstName("amawwn12");
		e1.setLastName("bansal12");

		/**
		 * We can write below two line code outside transaction body as well but we have
		 * to commit on transaction to save the data in DB. because by default in
		 * hibernate, auto commit is false.
		 * 
		 * 1) First difference between save and persist is there return type. Similar to
		 * save method persist also INSERT records into database but return type of
		 * persist is void while return type of save is Serializable object. 
		 *  
		 * 2) One more thing which differentiate persist and save method in Hibernate is that
		 * is there behavior on outside of transaction boundaries. persist() method
		 * guarantees that it will not execute an INSERT statement if it is called
		 * outside of transaction boundaries. save() method does not guarantee the same,
		 * it returns an identifier, and if an INSERT has to be executed to get the
		 * identifier (e.g. "identity" generator), this INSERT happens immediately, no
		 * matter if you are inside or outside of a transaction.
		 * 
		 * 3) Fourth difference between save and persist method in Hibernate is related
		 * to previous difference on save vs persist. Because of its above behavior of
		 * persist method outside transaction boundary, its useful in long-running
		 * conversations with an extended Session context. On the other hand save method
		 * is not good in a long-running conversation with an extended Session context.
		 * 
		 */
		int id = (Integer) session.save(e1);
		/****
		 * In save, we can have id back without committing into DB and play with ID
		 * but in persists we can't have id back. So persist generally uses in bulk operation where we don't need 
		 * to alter the id again and again and where we need to insert the data in bulk.
		 */
		Object obj = session.load(Employee.class, id);
		Employee e = (Employee) obj;
		// e.setId(92);
		e.setFirstName("aaaaaa");
		session.update(e);
		System.out.println("ID:" + id);
		// session.persist(e1);

		// creating transaction object
		Transaction t = session.beginTransaction();

		// We can write below two line code within transaction body as well.
		// session.save(e1);
		// session.persist(e1);
		t.commit();

		session.close();
		factory.close();
		System.out.println("successfully saved");

	}
}
