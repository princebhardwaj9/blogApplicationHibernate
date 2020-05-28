package dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import model.Blog;
import utility.HibernateConnectionManager;

public class BlogDao implements BlogDaoInterface {
	
	private SessionFactory sessionFactory = HibernateConnectionManager.getSessionFactory();
	
	@Override
	public void insertBlog(Blog blog) throws SQLException {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(blog);
		tx.commit();
		session.close();
	}

	@Override
	public Blog selectBlog(int blogid) throws Exception {
		Session session = this.sessionFactory.openSession();
		Blog blog = session.get(Blog.class, blogid);
		session.close();
		return blog;
	}

	@Override
	public List<Blog> selectAllBlog() {
		Session session = this.sessionFactory.openSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Blog> query = cb.createQuery(Blog.class);
		Root<Blog> root = query.from(Blog.class);
		query.select(root);
		Query<Blog> q = session.createQuery(query);
		List<Blog> listBlog = q.getResultList();
		return listBlog;
	}

	@Override
	public void deleteBlog(int blogid) throws SQLException {
		System.out.println(blogid);
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Blog blog = session.get(Blog.class, blogid);
		session.delete(blog);
		tx.commit();
		session.close();
	}

	@Override
	public void updateBlog(Blog blog) throws SQLException, Exception {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(blog);
		tx.commit();
		session.close();
	}

}