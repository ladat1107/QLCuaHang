<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${message != null }">
		<span>${message}</span>
	</c:if>
	<c:if test="${error != null }">
		<span>${error}</span>
	</c:if>
	<table border="1" style="width: 1000px">
		<thead>
			<th>ID</th>
			<th>name</th>
			<th>Icon</th>
			<th>Action</th>
		</thead>
		<tbody>
			<c:forEach var="i" items="${listcate}">
				<tr>
					<td>${i.categoryID}</td>
					<td>${i.categoryName}</td>
					<td>${i.icon}</td>
					<td><a href="updateCategory?id=${i.categoryID}">Update</a> || <a
						href="deleteCategory?id=${i.categoryID}"> Delete</a> </td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>