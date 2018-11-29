package com.journaldev.jsf.beans;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.journaldev.jsf.dao.UserDAO;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import com.journaldev.jsf.beans.UserBean;

@ManagedBean
@ViewScoped
public class UserCrudController {
	private List<UserBean> userbeanlist = null;
	private UserDAO userDAO = null;

	private UserBean Currentuser = null;

	@PostConstruct
	private void init() {

		if (userbeanlist == null) {
			userbeanlist = new ArrayList<UserBean>();
		}
		if (userDAO == null) {
			userDAO = new UserDAO();
			// userDAO.Connect_To_DB();
		}
		try {
			//userbeanlist.clear();
			userbeanlist.addAll(userDAO.showusers());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error in getting the list of users");
		}
	}

	public List<UserBean> getuserbean() {
		return userbeanlist;
	}

	public void setuserbean(List<UserBean> userbean) {
		this.userbeanlist = userbean;
	}

	public void updateRow(UserBean ee) {
		// Currentuser = new UserBean();
		Currentuser = ee;
		ee.setUpdate(true);
	}

	public void saveuser() {
		//Currentuser = null;
		
		System.out.println("should print");
		System.out.println(Currentuser);
		userDAO.updateuser(Currentuser);
		try {
			userbeanlist.clear();
			userbeanlist.addAll(userDAO.showusers());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error in getting the list of users");
		}
	}

	public void deleteuser(UserBean bb) {
		Currentuser = null;
		Currentuser = bb;
		try {
			userDAO.deleteuser(bb.getUserId());
			userbeanlist.clear();
			try {
				userbeanlist.addAll(userDAO.showusers());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Error in getting the list of users");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error deleting users");
		}
	}

	/*
	 * public void insertRow() { UserBean bb4insert = new UserBean();
	 * userDAO.adduser(UserBean); }
	 */
}
