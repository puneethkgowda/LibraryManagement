package com.journaldev.jsf.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import com.journaldev.jsf.dao.UserDAO;

@ManagedBean

public class UserBean {
	private String username;
	private String password;
	private String role;
	private int userid;
	private boolean update;
	
	
	public UserBean() {
	}

	public boolean isUpdate() {
		return update;
	}

	public void setUpdate(boolean update) {
		this.update = update;
	}
	
	public int getUserId() {
		return userid;
	}

	public void setUserId(int userid) {
		this.userid = userid;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String SaveUser() throws Exception {
		UserDAO userDAO = new UserDAO();
		
		userDAO.SaveUser(getUsername(), getPassword(), getRole());
		return "";
	}
}
