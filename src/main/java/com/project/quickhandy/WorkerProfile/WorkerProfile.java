package com.project.quickhandy.WorkerProfile;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class WorkerProfile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int wp_id;
	
	private String firstname;
	private String lastname;
	private String email;
	private String phone;
	private String username;
	private String password;


	public int getWp_id() {
		return wp_id;
	}

	public void setWp_id(int wp_id) {
		this.wp_id = wp_id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	public WorkerProfile(int wp_id, String firstname, String lastname, String email, String phone, String username, String password) {
		this.wp_id = wp_id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phone = phone;
		this.username = username;
		this.password = password;
	}

	public WorkerProfile() {
	}
}
