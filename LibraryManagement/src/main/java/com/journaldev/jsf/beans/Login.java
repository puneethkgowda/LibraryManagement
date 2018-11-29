package com.journaldev.jsf.beans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.journaldev.jsf.dao.LoginDAO;
import com.journaldev.jsf.util.SessionUtils;

@ManagedBean
@SessionScoped
public class Login implements Serializable {

	private static final long serialVersionUID = 1094801825228386363L;
	
	private String pwd;
	private String msg;
	private String user;
	private String userId; 
	private String userRole;

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
	
	public String getUserRole() {
		userRole = SessionUtils.getUserRole();
		return userRole;
	}
	
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	
	public String getUserId() {
		userId = SessionUtils.getUserId();
		return userId;
	}
	
	public void setUserId(String userId)
	{
		this.userId = userId;
	}

	//validate login
	public String validateUsernamePassword() {
		boolean valid = false;
		try {
			valid = LoginDAO.validate(user, pwd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (valid) {
			HttpSession session = SessionUtils.getSession();
			session.setAttribute("username", user);
			return "index";
		} else {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Incorrect Username and Passowrd",
							"Please enter correct username and Password"));
			return "login";
		}
	}

	//logout event, invalidate session
	public String logout() {
		HttpSession session = SessionUtils.getSession();
		session.invalidate();
		return "login";
	}
}
