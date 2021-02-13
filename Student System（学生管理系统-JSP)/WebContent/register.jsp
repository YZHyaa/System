<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册</title>
<link rel="stylesheet" href="CSS/register.css">
</head>
<body>
		<form action="AddUsersServlet" method="post">
			<h2>注册</h2>
			账号：<input name = "id" minlength="3" placeholder="请输入账号" maxlength="12" required><br>
			密码：<input name = "pwd" minlength="3" placeholder="请输入密码" maxlength="12" required><br>
			昵称：<input name = "name" minlength="3" placeholder="请输入昵称" maxlength="10" required><br>
			<button type="submit">注册</button>
			<button type="button" onclick="window.location.href='login.jsp'">返回</button>
		</form>
</body>
</html>