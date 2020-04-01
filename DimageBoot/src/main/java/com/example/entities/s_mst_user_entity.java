package com.example.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "s_mst_user")
public class s_mst_user_entity {
  @Id
  @Column(name = "user_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int user_id;
  
  @Column(name = "staff_cd")
  private String staff_cd;
  
  @Column(name = "staff_password")
  private String staff_password;
  
  @Column(name = "staff_name")
  private String staff_name;
  
  @Column(name = "staff_add", nullable = true)
  private String staff_add;
  
  @Column(name = "staff_birthday", nullable = true)
  private String staff_birthday;
  
  @Column(name = "staff_mobile", nullable = true)
  private String staff_mobile;
  
  @Column(name = "staff_role")
  private String staff_role;
  
  @Column(name = "delete_flag")
  private String delete_flag;
  
  @Column(name = "create_date")
  private String create_date;
  
  @Column(name = "update_date")
  private String update_date;
//getter - setter
  
public int getUser_id() {
	return user_id;
}

public void setUser_id(int user_id) {
	this.user_id = user_id;
}

public String getStaff_cd() {
	return staff_cd;
}

public void setStaff_cd(String staff_cd) {
	this.staff_cd = staff_cd;
}

public String getStaff_password() {
	return staff_password;
}

public void setStaff_password(String staff_password) {
	this.staff_password = staff_password;
}

public String getStaff_name() {
	return staff_name;
}

public void setStaff_name(String staff_name) {
	this.staff_name = staff_name;
}

public String getStaff_add() {
	return staff_add;
}

public void setStaff_add(String staff_add) {
	this.staff_add = staff_add;
}

public String getStaff_birthday() {
	return staff_birthday;
}

public void setStaff_birthday(String staff_birthday) {
	this.staff_birthday = staff_birthday;
}

public String getStaff_mobile() {
	return staff_mobile;
}

public void setStaff_mobile(String staff_mobile) {
	this.staff_mobile = staff_mobile;
}

public String getStaff_role() {
	return staff_role;
}

public void setStaff_role(String staff_role) {
	this.staff_role = staff_role;
}

public String getDelete_flag() {
	return delete_flag;
}

public void setDelete_flag(String delete_flag) {
	this.delete_flag = delete_flag;
}

public String getCreate_date() {
	return create_date;
}

public void setCreate_date(String create_date) {
	this.create_date = create_date;
}

public String getUpdate_date() {
	return update_date;
}

public void setUpdate_date(String update_date) {
	this.update_date = update_date;
}
  
  
  
}