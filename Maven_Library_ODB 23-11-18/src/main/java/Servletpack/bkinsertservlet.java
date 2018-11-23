package Servletpack;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connpackage.BookCrudOpeation;

public class bkinsertservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("givenisbn") == "" || request.getParameter("giventitle") == ""
				|| request.getParameter("givenauthor") == "" || request.getParameter("givenprice") == ""
				|| request.getParameter("givencat") == "") {
			System.out.println("empty");
			request.setAttribute("status", "no");
		} else {
			/*
			 * CrudBookBasee crudbookbasee = new CrudBookBasee(); int bkisbn =
			 * Integer.parseInt(request.getParameter("givenisbn")); String bkname = (String)
			 * request.getParameter("giventitle"); String bkauthor = (String)
			 * request.getParameter("givenauthor"); int bkprice =
			 * Integer.parseInt(request.getParameter("givenprice")); String bkcat = (String)
			 * request.getParameter("givencat"); String result =
			 * crudbookbasee.insertnow(bkisbn, bkname, bkauthor, bkprice, bkcat);
			 * System.out.println(request.getParameter("givenisbn")); if
			 * (result.equals("Success")) { request.setAttribute("status", "yes"); } else {
			 * request.setAttribute("status", "no"); }
			 */

		}
		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);

	}

}

/*
 * (request.getParameter("givenisbn")==null||request.getParameter("giventitle")=
 * =null||request.getParameter("givenauthor")==null||request.getParameter(
 * "givenprice")==null||request.getParameter("givencat")==null)
 */