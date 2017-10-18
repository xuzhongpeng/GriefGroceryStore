<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'HotMessage.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <link rel="icon" type="image/png" href="module/img/favicon.png">
	<link rel="stylesheet" href="module/jsp/header/header.css">
	<link rel="stylesheet" href="module/jsp/center/center.css">
	<link rel="stylesheet" href="module/css/common.css">	
	<link rel="stylesheet" type="text/css" href="module/css/comment.css">
	<link rel="stylesheet" type="text/css" href="module/css/HotMessage/HotMessage.css">
	
	<script src="module/js/jquery.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript" src="module/js/cookie.js"></script>
	<!-- <script src="header/canvas.js" type="text/javascript" charset="utf-8"></script> --><!-- 背景 -->
	<script src="module/js/common.js" type="text/javascript" charset="utf-8" ></script><!-- 引用第一步 -->
	<script src="module/jsp/header/header.js" type="text/javascript" charset="utf-8"></script><!-- 头部 -->
	<script src="module/jsp/center/center.js" type="text/javascript" charset="utf-8"></script>
	<script src="module/js/content.js" type="text/javascript" charset="utf-8" ></script>
	<script src="module/js/main/HotMessage.js" type="text/javascript" charset="utf-8" ></script>
</head>
<body>
	<header id="header"></header>
	<div class="center"></div>
</body>
</html>