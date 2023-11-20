<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Table - Product</title>
<style>
/* CSS cho phân trang */
#pagination {
	text-align: center;
	margin-top: 20px;
}

#pagination button {
	margin: 5px;
}
</style>
</head>
<body>
	<main>
		<h1 class="mt-4">Tables Product</h1>
		<ol class="breadcrumb mb-4">
			<li class="breadcrumb-item"><a href="index.html">Dashboard</a></li>
			<li class="breadcrumb-item active">Product</li>
		</ol>
		<div class="card mb-4">
			<div class="card-body">
				<a href="<c:url value='/adminInsertProduct'/>">
					<button type="button" class="btn btn-dark">
						<i class="ace-icon fa fa-pencil"></i> Add new Product
					</button>
				</a>
			</div>
		</div>
		<div class="card mb-4">
			<div class="card-header">
				<i class="fas fa-table me-1"></i> DataTable Product
			</div>
			<div class="card-body">
				<table id="datatablesSimple">
					<!-- id="datatablesSimple" -->
					<thead>
						<tr>
							<th>ProductID</th>
							<th>ProductName</th>
							<th>Description</th>
							<th>Price</th>
							<th>Image</th>
							<th>CategoryID</th>
							<th>SellerID</th>
							<th>Amount</th>
							<th>Stock</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="i" items="${listProd}">
							<tr>
								<td>${i.productID}</td>
								<td>${i.productName}</td>
								<td>${i.description}</td>
								<td>${i.price}</td>
								<td><img src="${i.imageLink}" alt="Hình ảnh sản phẩm"  width="300" height="200"/></td>
								<td>${i.category.categoryID}</td>
								<td>${i.sellerID}</td>
								<td>${i.amount}</td>
								<td>${i.stoke}</td>
								<td>
									<div class="hidden-sm hidden-xs btn-group">
										<a
											href="<c:url value='/updateProduct?productID=${i.productID}'/>">
											<button class="btn btn-xs btn-info btn-sm">
												<i class="ace-icon fa fa-pencil"></i>
											</button>
										</a> <a
											href="<c:url value='/deleteProduct?productID=${i.productID}'/>">
											<button type="button" class="btn btn-xs btn-info btn-sm"
												id="liveToastBtn">
												<i class="ace-icon fa fa-trash"></i>
											</button>
										</a>
									</div>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</main>
</body>
</html>