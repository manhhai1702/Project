package com.example.model;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.example.entities.s_mst_user_entity;

import java.util.Arrays;

public class MyUserPrincipal extends org.springframework.security.core.userdetails.User {
    private s_mst_user_entity user;

    public MyUserPrincipal(s_mst_user_entity user){
        super(user.getStaff_cd(), user.getStaff_password(), Arrays.asList(new SimpleGrantedAuthority(user.getStaff_role())));
    }
}