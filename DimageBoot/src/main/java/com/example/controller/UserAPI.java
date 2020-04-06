package com.example.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.s_mst_user_entity;
import com.example.service.UserService;

@RestController
public class UserAPI {
	 @Autowired
	  private UserService userService;
	  //show list
	  @RequestMapping(value={"/api/user-list-API"})
	  @GetMapping
	  public List<s_mst_user_entity> listUserAPI() {
	    return userService.findAll();
	  }
	  //view user by id
	  @RequestMapping(value={"/api/user-view-API"})
	  @GetMapping
	  public s_mst_user_entity viewUserAPI(@RequestParam int id) {
	    return userService.findById(id);
	  }
	  //get max staff_cd
	  @RequestMapping(value={"/api/get-max-staffcd"})
	  @GetMapping
	  public String getMaxStaffcd() { 
	    return userService.maxStaffCd();
	  }
	  //save
	  @RequestMapping(value={"/api/user-save-API"})
	  @PostMapping
	    public String saveAll(s_mst_user_entity userEntity) {
	        //log.info(todos.toString());
	         userService.update(userEntity);
	         return "ok";
	    }
}
