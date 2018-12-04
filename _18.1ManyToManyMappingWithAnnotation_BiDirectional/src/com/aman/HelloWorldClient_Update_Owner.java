
package com.aman;

import org.hibernate.Session;
import org.hibernate.Transaction;


public class HelloWorldClient_Update_Owner {
	public static void main(String[] args) {
		
			Session session = HibernateUtil.getSessionFactory().openSession();
        		Transaction txn = session.getTransaction();
        		try {
        			txn.begin();
        	
        			// Updating the owner (Movie)    
		        	Movie movie = (Movie) session.get(Movie.class, 1L);
		        	Actor actor = (Actor) session.get(Actor.class, 2L);
		        	movie.getActors().add(actor);

		        	txn.commit();
        		}	catch(Exception e) {
	        			if(txn != null) { txn.rollback(); }
	        			e.printStackTrace();
        		}	finally {
        				if(session != null) { session.close(); }
        		}
	
	}
}



































