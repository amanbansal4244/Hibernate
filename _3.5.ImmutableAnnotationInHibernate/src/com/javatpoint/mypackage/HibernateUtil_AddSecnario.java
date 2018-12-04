package com.javatpoint.mypackage;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
public class HibernateUtil_AddSecnario {
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
	public static void main(String... args){
		Session session=getSession();
		session.beginTransaction();
		ContactNumber c1=new ContactNumber(1,1,"7777777777");
		session.persist(c1);
		session.getTransaction().commit();
	}
} 