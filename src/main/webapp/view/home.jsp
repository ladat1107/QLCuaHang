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
	<div class="container">
		<div class="row">
			<div class="col">
				<nav aria-label="breadcrumb">
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a href="home">Home</a></li>
						<li class="breadcrumb-item active" aria-current="page">Category</li>
					</ol>
				</nav>
			</div>
		</div>
	</div>
	<div class="row">
		<c:forEach var="i" items="${listproduct}">
			<div class="col-12 col-md-6 col-lg-4">
				<div class="card">
					<img class="card-img-top" src="${i.imageLink}" alt="Card image cap">
					<div class="card-body">
						<h4 class="card-title">
							<a href="detail?id=${i.productID}">${i.productName}</a>
						</h4>
						<p class="card-text">${i.description}</p>
						<div class="row">
							<div class="col">
								<p class="btn btn-danger btn-block">${i.price}đ</p>
							</div>
							<div class="col">
								<a href="#" class="btn btn-success btn-block">Add to cart</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
		<div class="col-12">
			<nav aria-label="...">
				<ul class="pagination">
					<li class="page-item disabled"><a class="page-link" href="#"
						tabindex="-1">Previous</a></li>
					<li class="page-item"><a class="page-link" href="#">1</a></li>
					<li class="page-item active"><a class="page-link" href="#">2
							<span class="sr-only">(current)</span>
					</a></li>
					<li class="page-item"><a class="page-link" href="#">3</a></li>
					<li class="page-item"><a class="page-link" href="#">Next</a></li>
				</ul>
			</nav>
		</div>

	</div>
</body>
</html>