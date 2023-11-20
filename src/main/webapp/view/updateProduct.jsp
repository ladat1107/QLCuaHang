<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<main>
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-lg-8">
					<div class="card shadow-lg border-0 rounded-lg mt-5">
						<div class="card-header">
							<h3 class="text-center font-weight-light my-4">Update Product</h3>
						</div>
						<div class="card-body">
							<form action="updateProduct" method="post">
								<div class="row">
									<div class="col-md-6">
										<div class="form-floating mb-3">
											<input class="form-control" type="text" name="productID" value = "${pro.productID}"/>
											<label>Product ID</label>
										</div>
										<div class="form-floating mb-3">
											<input class="form-control" type="text" name="productName"value = "${pro.productName}" /> 
											<label>Name</label>
										</div>
										<div class="form-floating mb-3">
											<input class="form-control" type="text" name="productDescription" value = "${pro.description}"/>
											<label>Description</label>
										</div>
										<div class="form-floating mb-3">
											<input class="form-control" type="text" name="productPrice" value = "${pro.price}"/> 
											<label>Price</label>
										</div>
										<div class="form-floating mb-3">
											<input class="form-control" type="text" name="productImage" value = "${pro.imageLink}"/> 
											<label>Image</label>
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-floating mb-3">
											<input class="form-control" type="text" name="cateID" value = "${pro.category.categoryID}"/> 
											<label>Category ID</label>
										</div>
										<div class="form-floating mb-3">
											<input class="form-control" type="text" name="sellerID" value = "${pro.sellerID}"/> 
											<label>Seller ID</label>
										</div>
										<div class="form-floating mb-3">
											<input class="form-control" type="text" name="amount" value = "${pro.amount}"/> 
											<label>Amount</label>
										</div>
										<div class="form-floating mb-3">
											<input class="form-control" type="text" name="stock" value = "${pro.stoke}" /> 
											<label>Stock</label>
										</div>
									</div>
								</div>
								<div class="text-center mt-4">
									<input type="submit" class="btn btn-primary" value="Update" />
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</main>
</body>
</html>