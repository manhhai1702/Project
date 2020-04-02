package com.example.controller;

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
  @RequestMapping(value={"/login_admin"})
  public String loginAdmin(Model model) {
    //model.addAttribute("listUser", userService.findAll());
    return "login_admin";
  }
  @RequestMapping(value={"/login_action"})
  public String loginAction(Model model) {
    //model.addAttribute("listUser", userService.findAll());
    return "login";
  }
  @RequestMapping(value={"/", "/user-list"})
  public String listUser(Model model) {
    model.addAttribute("listUser", userService.findAll());
    return "list";
  }
  @RequestMapping("/user-save")
  public String insertUser(Model model) {
    model.addAttribute("customer", new s_mst_user_entity());
    return "userEntity-save";
  }
  @RequestMapping("/user-view/{id}")
  public String viewUser(@PathVariable int id, Model model) {
	  s_mst_user_entity userEntity = userService.findById(id);
    model.addAttribute("userEntity", userEntity);
    return "view";
  }
  
  @RequestMapping("/user-update/{id}")
  public String updateUser(@PathVariable int id, Model model) {
	  s_mst_user_entity userEntity = userService.findById(id);
    model.addAttribute("userEntity", userEntity);
    return "userEntity-update";
  }
  @RequestMapping("/saveUser")
  public String doSaveUser(@ModelAttribute("userEntity") s_mst_user_entity userEntity, Model model) {
    userService.save(userEntity);
    model.addAttribute("listUser", userService.findAll());
    return "redirect:customer-list";
  }
  @RequestMapping("/updateUser")
  public String doUpdateUser(@ModelAttribute("userEntity") s_mst_user_entity userEntity, Model model) {
    userService.update(userEntity);
    model.addAttribute("listCustomer", userService.findAll());
    return "userEntity-list";
  }
  
  @RequestMapping("/userDelete/{id}")
  public String doDeleteUser(@PathVariable int id, Model model) {
    userService.delete(id);
    model.addAttribute("listCustomer", userService.findAll());
    return "redirect:/customer-list";
  }
}