package com.example.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.UserDao;
import com.example.entities.s_mst_user_entity;
import com.example.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDAO;
	
	@Override
	public List<s_mst_user_entity> findAll() {
		 return userDAO.findAll();
	}

	@Override
	public s_mst_user_entity findById(int id) {
		 return userDAO.findById(id);
	}

	@Override
	public void save(s_mst_user_entity userEntity) {
		userDAO.save(userEntity);		
	}

	@Override
	public void update(s_mst_user_entity userEntity) {
		userDAO.update(userEntity);
	}

	@Override
	public void delete(int id) {
		s_mst_user_entity userEntity = userDAO.findById(id);
	    if (userEntity != null) {
	    	userDAO.delete(userEntity);
	    }
	}

}
