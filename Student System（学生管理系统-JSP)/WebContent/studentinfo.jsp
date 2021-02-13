<%@page import="student.entity.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="CSS/student.css">
</head>
<body>
		<%
			Student student = (Student)request.getAttribute("student");
		%>
		<form action="UpdateStudentServlet">
			学号：<input type = "text" name = "sno" value = "<%=student.getSno()%>" readonly="readonly"><br>
			姓名：<input type = "text" name = "sname" value = "<%=student.getSname()%>"><br>
			年龄：<input type = "text" name = "sage" value = "<%=student.getSage()%>"><br>
			地址：<input type = "text" name = "saddress" value = "<%=student.getSaddress()%>"><br>
			<input type = "submit" value="修改"/>
			<button type="button" onclick="window.location.href='index.jsp'">返回</button>
		</form>
</body>
</html>