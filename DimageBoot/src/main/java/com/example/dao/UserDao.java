package com.example.dao;

import java.util.List;

import com.example.entities.s_mst_user_entity;

public interface UserDao {

	public void save(final s_mst_user_entity userEntity);
	public void update(final s_mst_user_entity userEntity);
	public s_mst_user_entity findById(final int id);
	public s_mst_user_entity findByStaffcd(final String staff_cd);
	public void delete(final s_mst_user_entity userEntity) ;
	public List<s_mst_user_entity> findAll();
	public String findMaxStaffCd();
}




