<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<div class="card bg-light mb-3">
		<div class="card-header bg-primary text-white text-uppercase">
			<i class="fa fa-list"></i> Categories
		</div>
		<ul class="list-group category_block">
			<c:forEach var="i" items="${numpro}">
				<li class="list-group-item"><a href="findbycate?id=${i.categoryID}">${i.categoryName}</a></li>
			</c:forEach>
		</ul>
	</div>
	<div class="card bg-light mb-3">
		<div class="card-header bg-success text-white text-uppercase">Last
			product</div>
		<div class="card-body">
			<img class="img-fluid"
				src="https://dummyimage.com/600x400/55595c/fff" />
			<h5 class="card-title">Product title</h5>
			<p class="card-text">Some quick example text to build on the card
				title and make up the bulk of the card's content.</p>
			<p class="bloc_left_price">99.00 $</p>
		</div>
	</div>

</body>
</html>