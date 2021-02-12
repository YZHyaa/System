package users.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import users.entity.Users;
import users.service.IUsersService;
import users.service.impl.UsersServiceImpl;

public class AddUsersServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		IUsersService service = new UsersServiceImpl();
		
		int uid = Integer.parseInt(request.getParameter("id"));
		int upwd = Integer.parseInt(request.getParameter("pwd"));
		String uname = request.getParameter("name");
		Users users = new Users(uid, upwd, uname);
		
		if(service.addUsers(users)) {
			request.getSession().setAttribute("error","none");
		}else {
			request.getSession().setAttribute("error", "had");
		}
		response.sendRedirect("login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
