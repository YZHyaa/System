<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登陆</title>
<link rel="stylesheet" href="CSS/login.css">
</head>
<body>
	<%
		String error = (String)session.getAttribute("error");
		if(error != null){
			if(error.equals("nobody")){
	%>
		<script type="text/javascript">
			alert("账号错误！");
		</script>
	<%			
			}else if(error.equals("error")){
	%>
		<script type="text/javascript">
			alert("密码错误！");
		</script>
	<%
			}else if(error.equals("had")){
	%>
		<script type="text/javascript">
			alert("账号已存在！");
		</script>
	<%	
			}else{
	%>
		<script type="text/javascript">
			alert("注册成功！");
		</script>
	<%
			}
		}
		session.removeAttribute("error");
	%>
	
	<form action="CheckUsersServlet" method="post">
		<h2>登陆</h2>
		账号：<input type="text" name="id" placeholder="请输入账号"  required><br><br>
		密码：<input type="password" placeholder="请输入密码" name="pwd"><br><br>
		<button type="submit">登陆</button>
		<button type="button" onclick="window.location.href='register.jsp'">注册</button>
	</form>
</body>
</html>