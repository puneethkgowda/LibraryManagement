<%@page import="connpackage.ConnectToODB"%>
<%@ page language="java" import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="#">Library Management</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item active"><a class="nav-link"
					href="http://localhost:8080/Maven_Library_ODB/index.jsp">Add
						Books </a></li>
				<li class="nav-item"><a class="nav-link"
					href="http://localhost:8080/Maven_Library_ODB/viewbooks.jsp">View
						Book</a></li>
				<li class="nav-item"><a class="nav-link"
					href="http://localhost:8080/Maven_Library_ODB/updatebook.jsp">Update
						Book</a></li>
				<li class="nav-item"><a class="nav-link"
					href="http://localhost:8080/Maven_Library_ODB/deletebook.jsp">Delete
						Book</a></li>
			</ul>
		</div>
		<label>DB Status : <%
			ConnectToODB dbcm = new ConnectToODB();
			Connection conn = dbcm.getConnResult();
			if (conn == null) {
				out.println("Failed");
			} else {
				out.println("Connection Success with OJDBC");
			}
		%>
		</label>
	</nav>

	<script type="text/javascript" src="js/bootstrap.js"></script>
	<script type="text/javascript" src="js/query.js"></script>
</body>
</html>