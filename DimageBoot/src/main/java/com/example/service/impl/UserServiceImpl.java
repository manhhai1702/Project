package com.example.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date();
		userEntity.setDelete_flag("0");
		userEntity.setCreate_date(dateFormat.format(date).toString());
		try {
			userDAO.save(userEntity);
		}catch (Exception e){
			e.getStackTrace();
		}
		
	}

	@Override
	public void update(s_mst_user_entity userEntity) {
		userEntity.setDelete_flag("0");
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date();
		userEntity.setUpdate_date(dateFormat.format(date).toString());
		userDAO.update(userEntity);
	}

	@Override
	public void delete(int id) {
		s_mst_user_entity userEntity = userDAO.findById(id);
		if (userEntity != null) {
			userDAO.delete(userEntity);
		}
	}

	@Override
	public String maxStaffCd() {
		String value = userDAO.findMaxStaffCd();
		String[] listvalue = value.split("DSVN");
		int number = Integer.parseInt(listvalue[1]) + 1;
		if (number < 10) {
			value = "DSVN0" + number;
		} else {
			value = "DSVN" + number;
		}
		return value;
	}

	@Override
	public s_mst_user_entity findByStaffcd(String staff_cd) {
		return userDAO.findByStaffcd(staff_cd);
	}

}
