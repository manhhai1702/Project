package com.example.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.entities.s_mst_user_entity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

//@SuppressWarnings("serial")
//public class UserCustomDetails extends org.springframework.security.core.userdetails.User {
//	
//    private s_mst_user_entity user;

//    public UserCustomDetails(s_mst_user_entity user){
//
//        super(user.getStaff_cd(), user.getStaff_password(), Arrays.asList(new SimpleGrantedAuthority("ROLE_"+user.getStaff_role())));
//    }

//}
public class UserCustomDetails implements UserDetails {
    private int user_id;

    private String staff_cd;

    @JsonIgnore
    private String staff_password;

    private Collection<? extends GrantedAuthority> authorities;

    public UserCustomDetails(int id, String username,  String password, Collection<? extends GrantedAuthority> authorities) {
        this.user_id = id;
        this.staff_cd = username;
        this.staff_password = password;
        this.authorities = authorities;
    }

   

	public static UserCustomDetails create(s_mst_user_entity user) {
        List<GrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority("ROLE_"+user.getStaff_role()));

        return new UserCustomDetails(
                user.getUser_id(),
                user.getStaff_cd(),
                user.getStaff_password(),
                authorities
        );
    }

    public int getId() {
        return user_id;
    }
    
    @Override
    public String getUsername() {
        return staff_cd;
    }

    @Override
    public String getPassword() {
        return staff_password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        UserCustomDetails that = (UserCustomDetails) o;
//        return Objects.equals(user_id, that.user_id);
//    }
//
//    @Override
//    public int hashCode() {
//
//        return Objects.hash(user_id);
//    }
}