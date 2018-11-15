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
		<h1>delete A BOOK</h1>
		<form style="width: 300px">
			<select class="form-control" name="cars" id="byy">
				<option value="isbn">Delete by ISBN</option>
				<option value="booktitle">Delete by Book Title</option>
				<option value="author">Delete by Book Author</option>
			</select><br> <br> <input class="form-control" type="text"
				id="isbnid" placeholder="Enter Here"> <br> <br>
		</form>
		<button type="button" class="btn btn-danger" onclick="deleteit()">Delete</button>
	</div>
	<script type="text/javascript" src="js/bootstrap.js"></script>
	<script type="text/javascript" src="js/query.js"></script>
</body>
</html>