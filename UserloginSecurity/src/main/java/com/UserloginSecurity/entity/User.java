package com.UserloginSecurity.entity;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="User_Table")
public class User implements UserDetails{
	
	@Id
	private int userId;
	private String userName;
	private String emailId;
	private String password;
	private String userPhoneNo;
	
	
	public String getUserName() {
		return userName;
	}

	

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", useremailId=" + emailId + ", userPassword="
				+ password + ", userPhoneNo=" + userPhoneNo + "]";
	}
	
	@ManyToMany(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
	@JoinTable(name ="user_role" ,
	joinColumns = @JoinColumn(name="user",referencedColumnName = "userId"),
	inverseJoinColumns = @JoinColumn(name="role" , referencedColumnName = "id")
			)
	private List<Role> roles ;

	


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	
		List<SimpleGrantedAuthority> authories = this.roles.stream()
				.map(role-> new SimpleGrantedAuthority(role.getName()))
				.collect(Collectors.toList());
		return authories;
	}


	@Override
	public String getUsername() {
		return this.emailId;
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




}
