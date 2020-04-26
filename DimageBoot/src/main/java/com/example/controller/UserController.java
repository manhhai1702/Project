package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class UserController {

  
  @RequestMapping(value={"/","/home"})
  public String home(Model model) {
    return "home";
  }
  @RequestMapping(value={"/login"})
  public String login(Model model) {
    return "login_user";
  }
  @RequestMapping(value={"/loginAdmin"})
  public String loginAdmin(Model model) {
    return "login_admin";
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
  @RequestMapping("/403")
  public String accessDenied403() {
    return "403";
  }

}