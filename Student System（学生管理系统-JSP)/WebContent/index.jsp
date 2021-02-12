<%@page import="student.entity.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学生信息列表</title>
<link rel="stylesheet" href="CSS/index.css">
</head>
<body>
		<%
			String name = (String)session.getAttribute("name");
			if(name != null){
				out.print("<script> alert('欢迎您'+name+'!'); </script>");
			}
			session.removeAttribute("name");
		%>
		
			
		<%	
			String error = (String)request.getAttribute("error");
			if(error != null){
				if(error.equals("addError")){
		%>
			<script type="text/javascript">
				alert("增加失败！");
			</script>
		<% 
				}else if(error.equals("noError")){
		%>
			<script type="text/javascript">
				alert("增加成功！");
			</script>
		<% 
				}else if(error.equals("addError_d")){
		%>
			<script type="text/javascript">
				alert("删除失败！");
			</script>
		<%
				}else if(error.equals("noError_d")){
		%>
			<script type="text/javascript">
				alert("删除成功！");
			</script>
		<% 
				}
				request.removeAttribute("error");
				//response.sendRedirect("QueryServlet");
			}
		%>
		
		
		
		<h1>学生基本信息</h1>
		<table border = "1px">
			<tr>
				<th>学号</th>
				<th>姓名</th>
				<th>年龄</th>
				<th>操作</th>
			</tr>
			
			<%
				List<Student> students = (List<Student>)request.getAttribute("student");
				for(Student student : students){
			%>
				<tr>
					<td><a href="QueryOneStudentServlet?sno=<%=student.getSno()%>"><%=student.getSno()%></a></td>
					<td><%=student.getSname() %></td>
					<td><%=student.getSage() %></td>
					<td><a href="DeleteStudentServlet?sno=<%=student.getSno()%>">删除</a></td>
				</tr>			
			<%
				}
			%>
			
		</table>
		<div class="class"><a  href = "addStudent.jsp">新增</a></div>
		
</body>
</html>