package hcmute.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hcmute.entity.User;
import hcmute.services.IUsersService;
import hcmute.services.UsersServiceImpl;

@WebServlet(urlPatterns = { "/login", "/waiting", "/logout", "/register" })
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 309477873660146094L;
	IUsersService userService = new UsersServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();
		if (url.contains("login")) {
			getLogin(req, resp);
		} else if (url.contains("waiting")) {
			getWaiting(req, resp);
		} else if (url.contains("logout")) {
			getLogout(req, resp);
		}

		else if (url.contains("register")) {
			req.getRequestDispatcher("/view/register.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();
		if (url.contains("login")) {
			postLogin(req, resp);
		} else if (url.contains("register")) {
			postRegister(req, resp);
		}
	}

	private void getLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		// check session
		HttpSession session = req.getSession();
		if (session != null && session.getAttribute("User") != null) {
			resp.sendRedirect(req.getContextPath() + "/waiting");
			return;
		}
		// check cookies
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("email")) {
					session = req.getSession(true);
					session.setAttribute("email", cookie.getValue());
					resp.sendRedirect(req.getContextPath() + "/waiting");
					return;
				}
			}
		}
		req.getRequestDispatcher("/view/login.jsp").forward(req, resp);
	}

	private void postLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String alert = "";
		if (email.isEmpty() || password.isEmpty()) {
			alert = "Tài khoản hoặc mật khẩu không đúng";
			req.setAttribute("message", alert);
			req.getRequestDispatcher("/view/login.jsp").forward(req, resp);
			return;
		}
		User user = userService.login(email, password);
		if (user != null) {
			HttpSession session = req.getSession();
			session.setAttribute("User", user);
			resp.sendRedirect(req.getContextPath() + "/waiting");
		} else {
			alert = "Tài khoản hoặc mật khẩu không đúng";
			req.setAttribute("message", alert);
			req.getRequestDispatcher("/view/login.jsp").forward(req, resp);
		}
	}

	private void getWaiting(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if (session != null && session.getAttribute("User") != null) {
			User user = (User) session.getAttribute("User");
			if (user.getIsAdmin() == 0) {
				resp.sendRedirect("home");
			} else if (user.getIsAdmin() == 1) {
				resp.sendRedirect("home");
			}
		} else {
			resp.sendRedirect("login");
		}
	}

	private void getLogout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();

//		// Remove session attributes
//		session.removeAttribute("User");
//		// Process cookies
//		Cookie[] cookies = req.getCookies();
//		if (cookies != null) {
//			for (Cookie cookie : cookies) {
//				if (hcmute.util.constant.COOKIE_REMEMBER.equals(cookie.getName())) {
//					cookie.setMaxAge(0); // Remove the cookie
//					resp.addCookie(cookie); // Update the response with the removed cookie
//					break;
//				}
//			}
//		}
		// Redirect to the login page AFTER handling cookies and session
		resp.sendRedirect(req.getContextPath() + "/login");
	}

	private void postRegister(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");

		// String email = req.getParameter("email");
		String passwd = req.getParameter("passwd");
		String fullname = req.getParameter("fullname");

		User userNew = new User();
		userNew.setUserName(fullname);
		userNew.setPassword(passwd);
		userService.insert(userNew);

		resp.sendRedirect("login");

	}
}
