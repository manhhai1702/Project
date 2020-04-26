package com.example.controller;

import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.example.config.JwtTokenProvider;
import com.example.entities.s_mst_user_entity;
import com.example.service.UserService;

@EnableWebSecurity
@RestController
public class UserAPI<SimpleGrantedAuthority> {
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
	    public RedirectView saveUser(s_mst_user_entity userEntity) {
	         userService.save(userEntity);
	         return new RedirectView("../user-list");
	    }
	//save
	  @RequestMapping(value={"/api/user-update-API"})
	  @PostMapping
	    public RedirectView updateUser(s_mst_user_entity userEntity) {
	         userService.update(userEntity);
	         return new RedirectView("../user-list");
	    }
	  
	//delete user by id
	  @RequestMapping(value={"/api/user-delete-API"})
	  @GetMapping
	  public RedirectView deleteUser(@RequestParam int id) {
	    userService.delete(id);
	    return new RedirectView("../user-list");
	  }
	   
	  @Autowired
	 	private AuthenticationManager authenticationManager;
 
	  @RequestMapping(value={"/api/user-login"})
	  @PostMapping
	    public ResponseEntity<?> authenticateUser(@RequestParam String staff_cd,  String staff_password) {

	        Authentication authentication = authenticationManager.authenticate(
	                new UsernamePasswordAuthenticationToken(
	                		staff_cd,
	                		staff_password
	                )
	        );

	        SecurityContextHolder.getContext().setAuthentication(authentication);

	        String jwt = JwtTokenProvider.generateToken(authentication);
	        return ResponseEntity.ok(jwt);
	    }
	  
	  

}
