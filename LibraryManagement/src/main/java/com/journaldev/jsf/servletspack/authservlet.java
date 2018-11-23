package com.journaldev.jsf.servletspack;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.journaldev.jsf.util.SessionUtils;
import com.journaldev.jsf.dao.LoginDAO;

public class authservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("username") == "" || request.getParameter("password") == "") {
			System.out.println("empty");
			request.setAttribute("status", "no");
		} else {

			String user = (String) request.getParameter("username");
			String pwd = (String) request.getParameter("password");
			boolean valid = false;
			try {
				valid = LoginDAO.validate(user, pwd);
			} catch (Exception e) {
				request.setAttribute("status", "no");
			}
			if (valid) {
				HttpSession session = SessionUtils.getSession();
				session.setAttribute("username", user);
				request.setAttribute("status", "yes");
				getServletContext().getRequestDispatcher("/viewbooks.xhtml").forward(request, response);
				// resp.sendRedirect(reqt.getContextPath() + "/faces/login.xhtml");
			} else {
				request.setAttribute("status", "no");
			}

		}
		// getServletContext().getRequestDispatcher("/index.jsp").forward(request,
		// response);
		// resp.sendRedirect(reqt.getContextPath() + "/faces/login.xhtml");

	}

}
