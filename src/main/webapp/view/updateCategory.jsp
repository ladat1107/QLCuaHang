<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="updateCategory" method="post">
		<label>Nhap category name:</label>
		<input type="text" name="cateID" value="${cate.categoryID}" readonly="readonly">
		<label>Nhap category name:</label>
		<input type="text" name="cateName" value="${cate.categoryName}">
		<label>Nhap link icon:</label>
		<input type="text" name="images" value="${cate.icon}">
		<input type="submit" value="update category">
	</form>
</body>
</html>