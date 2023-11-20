<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Table - Product</title>
</head>
<body>
	<main>
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-lg-8">
					<div class="card shadow-lg border-0 rounded-lg mt-5">
						<div class="card-header">
							<h3 class="text-center font-weight-light my-4">Insert Product</h3>
						</div>
						<div class="card-body">
							<form action="insertProduct" method="post">
								<div class="row">
									<div class="col-md-6">
										<div class="form-floating mb-3">
											<input class="form-control" type="text" name="productID" /> 
											<label>Product ID</label>
										</div>
										<div class="form-floating mb-3">
											<input class="form-control" type="text" name="productName" />
											<label>Name</label>
										</div>
										<div class="form-floating mb-3">
											<input class="form-control" type="text" name="productDescription" /> 
											<label>Description</label>
										</div>
										<div class="form-floating mb-3">
											<input class="form-control" type="text" name="productPrice" /> 
											<label>Price</label>
										</div>
										<div class="form-floating mb-3">
											<input class="form-control" type="text" name="productImage" /> 
											<label>Image</label>
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-floating mb-3">
											<input class="form-control" type="text" name="cateID" />
											<label>Category ID</label>
										</div>
										<div class="form-floating mb-3">
											<input class="form-control" type="text" name="sellerID" /> 
											<label>Seller ID</label>
										</div>
										<div class="form-floating mb-3">
											<input class="form-control" type="text" name="amount" /> 
											<label>Amount</label>
										</div>
										<div class="form-floating mb-3">
											<input class="form-control" type="text" name="stock" /> 
											<label>Stock</label>
										</div>
									</div>
								</div>
								<div class="text-center mt-4">
									<input type="submit" class="btn btn-primary" value="Insert" />
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