package com.example.service;

import java.util.List;

import com.example.entities.s_mst_user_entity;

public interface UserService{
	public List<s_mst_user_entity> findAll();
	public s_mst_user_entity findById(final int id) ;
	public void save(final s_mst_user_entity userEntity);
	public void update(final s_mst_user_entity userEntity);
	public void delete(final int id);
	
}


//import java.util.List;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.example.dao.UserDao;
//import com.example.entities.s_mst_user_entity;
//@Service
//@Transactional
//public class UserService {
//	
//  @Autowired
//  private UserDao userDAO;
//  
//  public List<s_mst_user_entity> findAll() {
//    return userDAO.findAll();
//  }
//  public s_mst_user_entity findById(final int id) {
//    return userDAO.findById(id);
//  }
//  public void save(final s_mst_user_entity userEntity) {
//	  userDAO.save(userEntity);
//  }
//  public void update(final s_mst_user_entity userEntity) {
//	  userDAO.update(userEntity);
//  }
//  public void delete(final int id) {
//	  s_mst_user_entity userEntity = userDAO.findById(id);
//    if (userEntity != null) {
//    	userDAO.delete(userEntity);
//    }
//  }
//}