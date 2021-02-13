package student.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.service.impl.StudentServiceImpl;

public class DeleteStudentServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		int no = Integer.parseInt(request.getParameter("sno")) ;
		
		StudentServiceImpl service = new StudentServiceImpl();
		boolean result = service.deleteStudentBysno(no);
//		if(result) {
//			response.getWriter().println("É¾³ý³É¹¦£¡");
//			response.sendRedirect("QueryServlet");
//		}else {
//			response.getWriter().println("É¾³ýÊ§°Ü£¡");
//		}
		if(!result) {
			request.setAttribute("error", "addError_d");
		}else {
			request.setAttribute("error", "noError_d");
		}
		request.getRequestDispatcher("QueryServlet").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
