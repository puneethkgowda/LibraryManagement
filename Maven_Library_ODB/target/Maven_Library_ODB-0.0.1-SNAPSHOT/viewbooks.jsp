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
<body>
	<%@include file="headernav.jsp"%>
	<div style="padding-left: 100px">
		<h2>SHOW ALL LIBRARY DATA</h2>
		<br>
		<table class="table" id="mytable">
			<tr>
				<th>ISBN</th>
				<th>BOOK TITLE</th>
				<th>BOOK PRICE</th>
				<th>AUTHOR</th>
				<th>CATeGORY</th>
			</tr>
		</table>
	</div>
	<script type="text/javascript" src="js/bootstrap.js"></script>
	<script type="text/javascript" src="js/query.js"></script>
</body>
</html>