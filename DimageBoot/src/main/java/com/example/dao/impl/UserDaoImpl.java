package com.example.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.UserDao;
import com.example.entities.s_mst_user_entity;

@Repository(value = "userDAO")
@Transactional(rollbackFor = Exception.class)
public class UserDaoImpl implements UserDao{
	@Autowired
	private SessionFactory sessionFactory;
	  
	@Override
	public void save(s_mst_user_entity userEntity) {
	    Session session = this.sessionFactory.getCurrentSession();
	    session.save(userEntity);
	}

	@Override
	public void update(s_mst_user_entity userEntity) {
	    Session session = this.sessionFactory.getCurrentSession();
	    session.update(userEntity);
	}

	@Override
	public s_mst_user_entity findById(int id) {
	    Session session = this.sessionFactory.getCurrentSession();
	    return session.get(s_mst_user_entity.class, id);
	}

	@Override
	public void delete(s_mst_user_entity userEntity) {
	    Session session = this.sessionFactory.getCurrentSession();
	    session.remove(userEntity);
	}

	@Override
	public List<s_mst_user_entity> findAll() {
	    Session session = this.sessionFactory.getCurrentSession();
	    List<s_mst_user_entity> resultList = session.createQuery("FROM s_mst_user_entity", s_mst_user_entity.class).getResultList();
	    return resultList;
	}

}
