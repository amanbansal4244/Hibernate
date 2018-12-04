package com.javatpoint.mypackage;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.Immutable;
import org.hibernate.cfg.AnnotationConfiguration;
public class HibernateUtil_GetSecnario {
	private static final SessionFactory concreteSessionFactory;
	static {
		try {
			concreteSessionFactory = new AnnotationConfiguration()
					.configure().buildSessionFactory();
		} catch (Throwable ex) {
			throw new ExceptionInInitializerError(ex);
		}
	}
	public static Session getSession()
			throws HibernateException {
		return concreteSessionFactory.openSession();
	}
	public static void main(String... args){	Session session=getSession();
	session.beginTransaction();
	ContactNumber c1=new ContactNumber(1,1,"7777777777");
	session.persist(c1);
	session.getTransaction().commit();
	
	Session session1=getSession();
	session1.beginTransaction();
	Object obj = session1.load(ContactNumber.class, new Integer(1));
	ContactNumber e = (ContactNumber)obj;
	session1.getTransaction().commit();
	/****
	 * Note : If you make the class @Immutable or not and print the name of the class, you will see the actual name of the class as "Customer".
	 * You will also see the select queries fired by hibernate to initialize the object.
	 * means by writing @Immutable, we can achieve the lazy loading of hibernate which we can't achieve by making entity class as final.
	 */
	System.out.println("Class Name: "+ e.getClass());
	
	/****
	 * We we write below line then select query would get fired with or without @Immutable annotation at entity class
	 * because we are loading the data.
	 */
	//System.out.println("successfully fetched...." +"First name is:"+ "id:"+ e.getId() + " phone no:" + e.mobileNumber);

	
	}
} 