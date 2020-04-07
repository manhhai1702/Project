package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entities.s_mst_user_entity;
import com.example.service.UserService;


@Controller
public class APIUserController {
  @Autowired
  private UserService userService;
  
  @RequestMapping(value={"/login"})
  public String login(Model model) {
    //model.addAttribute("listUser", userService.findAll());
    return "login";
  }
 
  @RequestMapping(value={"/user-list"})
  public String listUser() {
    //model.addAttribute("listUser", userService.findAll());
    return "list";
  }

  @RequestMapping("/user-create")
  public String insertUser(Model model) {
    
    return "create";
  }
  @RequestMapping("/user-view/{id}")
  public String viewUser() {
	//s_mst_user_entity userEntity = userService.findById(id);
    //model.addAttribute("userEntity", userEntity);
    return "view";
  }
  
}