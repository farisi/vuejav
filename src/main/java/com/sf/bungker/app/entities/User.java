package com.sf.bungker.app.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Table(name = "users")
@Entity
public class User implements Serializable {
	
	public User() {}
	
	public User(String email, String name, String username, String password, boolean is_enabled, List<Role> roles) {
		super();
		this.email = email;
		this.name = name;
		this.username = username;
		this.password = password;
		this.is_enabled = is_enabled;
		this.roles = roles;
	}

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(unique = true)
	private String email;
	
	private String name;
	
	@Column(unique = true)
	private String username;
	
	private String password;
	
	private boolean is_enabled;
	
	private Date created_at;
	
	private Date updated_at;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="role_user",joinColumns = {@JoinColumn(name="user_id")}, inverseJoinColumns = {@JoinColumn(name="role_id")})
	private Collection<Role> roles;

	@OneToOne(mappedBy = "user",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private UserProfile userProfile;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isIs_enabled() {
		return is_enabled;
	}

	public void setIs_enabled(boolean is_enabled) {
		this.is_enabled = is_enabled;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}	
}
