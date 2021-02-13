package student.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.entity.Student;
import student.service.impl.StudentServiceImpl;

/**
 * Servlet implementation class AddStudentServlet
 */
public class AddStudentServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		int no = Integer.parseInt(request.getParameter("sno"));
		String name = request.getParameter("sname");
		int age = Integer.parseInt(request.getParameter("sage"));
		String address = request.getParameter("saddress");
		
		Student student = new Student(no,name,age,address);
		
		StudentServiceImpl studentService = new StudentServiceImpl();
		boolean result = studentService.addStudent(student);
		PrintWriter out = response.getWriter();
//		if(result) {
//			out.println("增加成功！");
//			response.sendRedirect("QueryServlet");
//		}else {
//			out.println("增加失败！");
//			response.sendRedirect("QueryServlet");
//		}
		if(!result) {
			request.setAttribute("error", "addError");
		}else {
			request.setAttribute("error", "noError");
		}
		request.getRequestDispatcher("QueryServlet").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
