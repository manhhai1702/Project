package com.example.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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
	    
	    s_mst_user_entity result = session.get(s_mst_user_entity.class, id);
	    return result;
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

	@Override
	public String findMaxStaffCd() {
		Session session = this.sessionFactory.getCurrentSession();
	    List<s_mst_user_entity> resultList = session.createQuery("FROM s_mst_user_entity", s_mst_user_entity.class).getResultList();
	    String value = resultList.get(resultList.size()-1).getStaff_cd();
	    return value;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public s_mst_user_entity findByStaffcd(String staff_cd) {
		Session session = this.sessionFactory.getCurrentSession();
		
		try {
			Query query = session.createQuery("FROM s_mst_user_entity  WHERE staff_cd = :staff_cd");
			query.setParameter("staff_cd", staff_cd);
			s_mst_user_entity result = (s_mst_user_entity) query.getSingleResult();
			return result;
		}catch (Exception e) {
			 e.getStackTrace();
		}
	    
	    return null;
	}

//	@SuppressWarnings("rawtypes")
//	@Override
//	public s_mst_user_entity findlogin(String staff_cd, String staff_password) {
//		Session session = this.sessionFactory.getCurrentSession();
//		
//		try {
//			Query query = session.createQuery("FROM s_mst_user_entity  WHERE staff_cd = :staff_cd AND staff_password = :staff_password");
//			query.setParameter("staff_cd", staff_cd);
//			query.setParameter("staff_password", staff_password);
//			s_mst_user_entity result = (s_mst_user_entity) query.getSingleResult();
//			return result;
//		}catch (Exception e) {
//			 e.getStackTrace();
//		}
//	    
//	    return null;
//	}

}
