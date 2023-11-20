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
import hcmute.services.CategoryServiceImpl;
import hcmute.services.ICategoryService;

@WebServlet(urlPatterns = { "/listCate", "/addCategory", "/updateCategory", "/deleteCategory" })
public class CategoryController extends HttpServlet {
	// goi cac phuong thuc trong service
	ICategoryService cateService = new CategoryServiceImpl();
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();
		if (url.contains("listCate"))
			findAll(req, resp);
		else if (url.contains("addCategory")) {
			RequestDispatcher rd = req.getRequestDispatcher("/view/addCategory.jsp");
			rd.forward(req, resp);
		}
		else if(url.contains("updateCategory")) {
			int id = Integer.parseInt(req.getParameter("id"));
			Category model = cateService.findOne(id);
			req.setAttribute("cate", model);
			RequestDispatcher rd = req.getRequestDispatcher("/view/updateCategory.jsp");
			rd.forward(req, resp);
		}
		else if(url.contains("deleteCategory")) {
			delete(req,resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();
		if (url.contains("addCategory")) {
			insert(req,resp);
		}
		else if(url.contains("updateCategory")) {
			update(req,resp);
		}
	}

	private void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Category> listcate = cateService.findALL();
		// đẩy dữ liệu ra view
		req.setAttribute("listcate", listcate);
		// view nhan du lieu
		RequestDispatcher rd = req.getRequestDispatcher("/view/listCategory.jsp");
		rd.forward(req, resp);
	}
	
	private void insert(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		//Nhan du lieu tu form
		int cateID =Integer.parseInt(req.getParameter("cateID")) ;
		String cateName = req.getParameter("cateName");
		String images = req.getParameter("images");
		
		Category cate = new Category();
		cate.setCategoryID(cateID);
		cate.setCategoryName(cateName);
		cate.setIcon(images);
		
		cateService.insert(cate);
		//tra ve view
		resp.sendRedirect("listCate");
	}
	
	private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		//Nhan du lieu tu form
		int id = Integer.parseInt(req.getParameter("cateID"));
		String cateName = req.getParameter("cateName");
		String images = req.getParameter("images");
		
		
		Category cate = new Category();
		cate.setCategoryID(id);
		cate.setCategoryName(cateName);
		cate.setIcon(images);
		
		cateService.update(cate);
		resp.sendRedirect("listCate");
	}

	private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		try {
			cateService.delete(id);
			req.setAttribute("message", "Xoa thanh cong");
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("message", "Xoa that bai");
		}
		resp.sendRedirect("listCate");
	}
	
}
