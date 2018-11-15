<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" />
</head>
<body onload="saveit()">
	<%@include file="headernav.jsp"%>
	<div style="padding-left: 100px">
		<h1>ADD A BOOK</h1>
		<form style="width: 300px" action="insert" method="post">
			<input class="form-control" type="text" id="isbnid" name="givenisbn"
				placeholder="Enter ISBN"></input> <br /> <br /> <input type="text"
				name="giventitle" placeholder="Enter Book Title"
				class="form-control" id="booktitleid"></input> <br /> <br /> <input
				class="form-control" type="text" id="authorid" name="givenauthor"
				placeholder="Enter Author Name"></input> <br /> <br /> <input
				type="text" class="form-control" id="priceid" name="givenprice"
				placeholder="Enter Price"></input> <br /> <br /> <input
				class="form-control" type="text" id="catid" name="givencat"
				placeholder="Enter Category"></input> <br /> <br /> <input
				type="submit" class="btn btn-primary" value="Save Book"> <br />
		</form>
	</div>
	<script>
		function saveit() {
	<%String respo = (String) request.getAttribute("status");
			if (respo == "no") {%>
		alert("Sorry UnSuccessfull");
	<%} else if (respo == "yes") {%>
		alert("Successfull Added");
	<%}%>
		}
	</script>
	<script type="text/javascript" src="js/bootstrap.js"></script>
	<script type="text/javascript" src="js/query.js"></script>
</body>
</html>