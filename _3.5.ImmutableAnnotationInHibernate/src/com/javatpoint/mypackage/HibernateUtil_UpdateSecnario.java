package com.javatpoint.mypackage;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
public class HibernateUtil_UpdateSecnario {
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
		session.refresh(c1);

		c1.setMobileNumber("8888888888");

		session.beginTransaction();
		/****
		 * In the example entity ContactNumber has the mobile number 7777777777 and now we have updated to 8888888888 and
		 *  when we print the value result will be 7777777777. So hibernate did not allow to update the entity because it is immutable. 
		 *  You can test also removing @Immutable annotation, in this case update will be allowed
		 */
		session.update(c1);

		session.getTransaction().commit();
		session.refresh(c1);
		System.out.println(c1.getMobileNumber());
	}
} 