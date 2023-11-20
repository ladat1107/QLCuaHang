package hcmute.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hcmute.entity.Product;
import hcmute.services.CategoryServiceImpl;
import hcmute.services.ICategoryService;
import hcmute.services.IProductService;
import hcmute.services.ProductServiceImpl;



@WebServlet(urlPatterns = { "/listProduct","/insertProduct", "/updateProduct", "/deleteProduct"})
public class ProductController extends HttpServlet {
	IProductService prodService = new ProductServiceImpl();
	ICategoryService cateService = new CategoryServiceImpl();
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();
		if (url.contains("listProduct")) {
			findAllProduct(req, resp);
		}else if(url.contains("insertProduct")) {
			req.getRequestDispatcher("/view/insertProduct.jsp").forward(req, resp);
		} else if(url.contains("updateProduct")) {
			getInfoProduct(req,resp);
		} else if(url.contains("deleteProduct")) {
			try {
				deleteProduct(req,resp);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			resp.sendRedirect("listProduct");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String url = req.getRequestURI().toString();
		if (url.contains("insertProduct")) {
			createProduct(req, resp);
		} else if(url.contains("updateProduct")) {
			updateProduct(req, resp);
		}
		resp.sendRedirect("listProduct");
	}

	
	private void findAllProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Product> listprod = prodService.findAllProduct();
		req.setAttribute("listProd", listprod);
		RequestDispatcher rd = req.getRequestDispatcher("/view/listProduct.jsp");
		rd.forward(req, resp);
	}
	
	private void getInfoProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int proID = Integer.parseInt(req.getParameter("productID"));
		Product product = prodService.getone(proID); 
	
		req.setAttribute("pro", product);
		RequestDispatcher rd = req.getRequestDispatcher("/view/updateProduct.jsp");
		rd.forward(req, resp);
	}
	
	private void deleteProduct(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		int proID = Integer.parseInt(req.getParameter("productID"));
		prodService.delete(proID);
	}
	
	private void createProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int proID = Integer.parseInt(req.getParameter("productID"));
		String name = req.getParameter("productName");
		String description = req.getParameter("productDescription");
		int price = Integer.parseInt(req.getParameter("productPrice"));
		String image = req.getParameter("productImage");
		int cateID = Integer.parseInt(req.getParameter("cateID"));
		int sellerID = Integer.parseInt(req.getParameter("sellerID"));
		int Amount = Integer.parseInt(req.getParameter("amount"));
		int stoke = Integer.parseInt(req.getParameter("stock"));
		
		Product product = new Product();
		product.setProductID(proID);
		product.setProductName(name);
		product.setDescription(description);
		product.setPrice(price);
		product.setImageLink(image);
		product.setCategory(cateService.getone(cateID));
		product.setSellerID(sellerID);
		product.setAmount(Amount);
		product.setStoke(stoke);
		prodService.insert(product);
	}
	
	private void updateProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int proID = Integer.parseInt(req.getParameter("productID"));
		String name = req.getParameter("productName");
		String description = req.getParameter("productDescription");
		int price = Integer.parseInt(req.getParameter("productPrice"));
		String image = req.getParameter("productImage");
		int cateID = Integer.parseInt(req.getParameter("cateID"));
		int sellerID = Integer.parseInt(req.getParameter("sellerID"));
		int Amount = Integer.parseInt(req.getParameter("amount"));
		int stock = Integer.parseInt(req.getParameter("stock"));
		
		Product product = new Product();
		product.setProductID(proID);
		product.setProductName(name);
		product.setDescription(description);
		product.setPrice(price);
		product.setImageLink(image);
		product.setCategory(cateService.getone(cateID));
		product.setSellerID(sellerID);
		product.setAmount(Amount);
		product.setStoke(stock);
		prodService.update(product);
	}
}

