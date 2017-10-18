<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
	<base href="<%=basePath%>">
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>登录</title>
	<link rel="stylesheet" href="module/css/login.css">
    <link rel="icon" type="image/png" href="module/img/loginFavicon.png">
	
	<script type="text/javascript" src="module/js/jquery.js"></script>
	<script type="text/javascript" src="module/js/cookie.js"></script>
	<script type="text/javascript" src="module/js/main/login.js"></script>
</head>
<body>
	<div class="loginName"></div>
	<div class="loginBox">
		
		<input type="text" id="name" class="center name" placeholder="杂货铺号"/>
		<input type="password" id="password" class="center password"  placeholder="密码"/>
		<p class="remind"></p>
	</div>
		<button class="center login" id="loginOk">登录</button>
		<button class="center register" id="register">注册</button>
</body>
</html>