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
  @RequestMapping(value={"/", "/user-list"})
  public String listCustomer(Model model) {
    model.addAttribute("listUser", userService.findAll());
    return "userEntity-list";
  }
  @RequestMapping("/user-save")
  public String insertCustomer(Model model) {
    model.addAttribute("customer", new s_mst_user_entity());
    return "userEntity-save";
  }
  @RequestMapping("/user-view/{id}")
  public String viewCustomer(@PathVariable int id, Model model) {
	  s_mst_user_entity userEntity = userService.findById(id);
    model.addAttribute("userEntity", userEntity);
    return "userEntity-view";
  }
  
  @RequestMapping("/user-update/{id}")
  public String updateCustomer(@PathVariable int id, Model model) {
	  s_mst_user_entity userEntity = userService.findById(id);
    model.addAttribute("userEntity", userEntity);
    return "userEntity-update";
  }
  @RequestMapping("/saveUser")
  public String doSaveCustomer(@ModelAttribute("userEntity") s_mst_user_entity userEntity, Model model) {
    userService.save(userEntity);
    model.addAttribute("listUser", userService.findAll());
    return "redirect:customer-list";
  }
  @RequestMapping("/updateUser")
  public String doUpdateCustomer(@ModelAttribute("userEntity") s_mst_user_entity userEntity, Model model) {
    userService.update(userEntity);
    model.addAttribute("listCustomer", userService.findAll());
    return "userEntity-list";
  }
  
  @RequestMapping("/userDelete/{id}")
  public String doDeleteCustomer(@PathVariable int id, Model model) {
    userService.delete(id);
    model.addAttribute("listCustomer", userService.findAll());
    return "redirect:/customer-list";
  }
}