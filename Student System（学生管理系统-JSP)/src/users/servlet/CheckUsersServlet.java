package users.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.Session;

import users.entity.Users;
import users.service.IUsersService;
import users.service.impl.UsersServiceImpl;

public class CheckUsersServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		IUsersService service = new UsersServiceImpl();
		
		int id = Integer.parseInt(request.getParameter("id"));
		int pwd = Integer.parseInt(request.getParameter("pwd"));
		Users users = service.queryUsers(id);
		
		if(users == null) {
			request.getSession().setAttribute("error", "nobody");
			response.sendRedirect("login.jsp");
		}
		else if (pwd == users.getUpwd()) {
			request.getSession().setAttribute("name", users.getUname());
			response.sendRedirect("QueryServlet");
		}else {
			request.getSession().setAttribute("error", "error");
			response.sendRedirect("login.jsp");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}