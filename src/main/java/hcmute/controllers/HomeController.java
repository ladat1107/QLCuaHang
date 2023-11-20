package hcmute.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hcmute.entity.Category;
import hcmute.entity.Product;
import hcmute.models.CateAndNum;
import hcmute.services.CategoryServiceImpl;
import hcmute.services.ICategoryService;
import hcmute.services.IProductService;
import hcmute.services.ProductServiceImpl;

@WebServlet(urlPatterns = { "/home", "/findbycate", "/findtopsale", "/detail"})
public class HomeController extends HttpServlet {
	// goi cac phuong thuc trong service
	ICategoryService cateService = new CategoryServiceImpl();
	IProductService proService = new ProductServiceImpl();
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();
		findAllCate(req, resp);
		if (url.contains("home"))
			findTopPro(req, resp);
		else if(url.contains("findbycate"))
			findByCate(req, resp);
		else if(url.contains("findtopsale"))
			findTopSale(req, resp);
		else if(url.contains("detail"))
			ShowDetail(req, resp);
		
	}


	private void findTopPro(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Product> listproduct = proService.find10();
		
		req.setAttribute("listproduct", listproduct);
		
		RequestDispatcher rd = req.getRequestDispatcher("/view/home.jsp");
		rd.forward(req, resp);
	}
	private void findByCate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		List<Product> listproduct = proService.findByCate(id);
		
		req.setAttribute("listproduct", listproduct);
		
		RequestDispatcher rd = req.getRequestDispatcher("/view/home.jsp");
		rd.forward(req, resp);
	}
	
	private void findTopSale(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Product> listproduct = proService.findsale();
		
		req.setAttribute("listproduct", listproduct);
		RequestDispatcher rd = req.getRequestDispatcher("/view/home.jsp");
		rd.forward(req, resp);
	}
	
	private void ShowDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		Product product = proService.fineOne(id);
		req.setAttribute("product", product);
		RequestDispatcher rd = req.getRequestDispatcher("/view/detail.jsp");
		rd.forward(req, resp);
	}
	
	
	private void findAllCate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Category> numpro = cateService.findALL();
		
		req.setAttribute("numpro", numpro);	
		
	}
}
