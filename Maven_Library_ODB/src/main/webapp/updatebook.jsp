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
	<%@include file="headernav.jsp"%>
	<div style="padding-left: 100px">
		<h1>UPDATE BOOK DETAILS BY ISBN</h1>

		<form style="width: 300px">
			<h3>Enter ISBN to update its details</h3>
			<label>Enter ISBN to Update </label><input class="form-control"
				type="text" id="isbnid"><br> <br>
			<button class="btn btn-info" type="button" onclick="getdetails()">GET
				DETAILS</button>
			<br> <br> <br> <label>Update Book Title </label><input
				class="form-control" type="text" id="titleid"><br> <br>
			<label>Update Book Author </label><input type="text"
				class="form-control" id="authorid"><br> <br> <label>Update
				Book Price </label><input class="form-control" type="text" id="priceid"><br>
			<br>
			<button class="btn btn-info" type="button" onclick="updateit()">UPDATE</button>
		</form>
	</div>
	<script type="text/javascript" src="js/bootstrap.js"></script>
	<script type="text/javascript" src="js/query.js"></script>
</body>
</html>