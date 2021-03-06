package com.example.service;

import java.util.List;

import com.example.entities.s_mst_user_entity;

public interface UserService{
	public List<s_mst_user_entity> findAll();
	
	public String maxStaffCd();
	
	public s_mst_user_entity findById(final int id) ;
	
	public s_mst_user_entity findByStaffcd(final String staff_cd) ;
	
	public void save(final s_mst_user_entity userEntity);
	
	public void update(final s_mst_user_entity userEntity);
	
	public void delete(final int id);
	
	public s_mst_user_entity loginUser(String Staff_cd, String Pass) ;
	
}


