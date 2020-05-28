package dao;

import javax.persistence.EntityTransaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Users;
import utility.HibernateConnectionManager;

public class UserDao implements UserDaoInterface {
	
	private SessionFactory sessionFactory = HibernateConnectionManager.getSessionFactory();

	@Override
	public int signupUser(Users user) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		if(session.save(user)!=null) {
			tx.commit();
			session.close();
			return 1;
		}
		else {
			return 0;
		}
	}


	@Override
	public boolean loginUser(String email, String password) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = (Transaction) session.getTransaction();
			((EntityTransaction) tx).begin();
		}catch(Exception e) {
			if(tx!=null) {
				try {
					tx.rollback();
				}catch(IllegalStateException e1) {
//					 | SystemException
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return true;
	}
}
