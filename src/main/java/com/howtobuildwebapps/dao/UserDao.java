package com.howtobuildwebapps.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.howtobuildwebapps.domain.User;

@Repository
public class UserDao {

	@Resource
	private HibernateTemplate hibernateTemplate;
	
	@Autowired
	private SessionFactory sessionFactory;

	public void saveUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.save(user);
	}
	
	@SuppressWarnings("unchecked")
	public List<User> getUsers() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from User").list();
	}
}

