<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>


<head>
  <base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<title>个人主页</title>
<link type="text/css" rel="stylesheet" href="module/css/index.css">
<link type="text/css" rel="stylesheet" href="module/css/main/unitperson.css">
    <link rel="icon" type="image/png" href="module/img/favicon.png">

<script src="module/js/jquery.js" type="text/javascript" charset="utf-8"></script>
<script src="module/js/common.js" type="text/javascript" charset="utf-8" ></script>
<script type="text/javascript" src="module/js/main/personHomepage.js"></script>
<style>
/* 链接颜色 */
a{color:#56AAC3;}
.m-post .ctc{font-size:14px;line-height:26px;} 
.m-post .ctc p,.m-post .ctc ul,.m-post .ctc ol,.m-post .ctc blockquote,.m-post .ctc .text,.m-post .ctc .digest{margin:0 0 25px;}
.g-hd{background-image:url(http://127.0.0.1:8080/image/20170919171853914.jpg);height:360px;}
</style>
</head>
<body class="p-homepage">
<div class="boprt a-control" style="top: 0px; opacity: 1;height: 0px;position:fixed;" id="control">
 	<ul>
 	 <!-- <li><a href="module/jsp/index.jsp" class="boprt03" target="_top"><em>取消关注</em></a></li> -->
	 <li><a id="golofterhome" href="module/jsp/index.jsp" class="boprt01" target="_top"><em>返回首页</em></a></li> 
     </ul>
 </div>

<div class="g-doc box">
	<div class="g-hd">&nbsp;</div>
	<div class="g-bd box">
	
		<div class="g-sd">
			<div class="m-hdimg">
				<a class="hdimg img" href="http://inschuanda.lofter.com/">
					<img id='userImg' src="http://127.0.0.1:8080/image/20170919192117100.png" width="96" height="96">
				</a>
			</div>
			<h1 class="m-ttl">
				<a id='userName' href="module/jsp/main/personHomepage.jsp">永无岛</a>
			</h1>
			<p class="m-about">要告诉自己，没有什么东西可以比得过你</p>
			<ul class="m-nav">
				<li><a>email: <span id="email">323@qq.com</span></a></li>
				<li><a>注册时间: <span id="registerTime">2017-10-9 12:20:25</span></a></li>
			</ul>
		</div>
						
		<div class="g-mn">
			<div class="g-mnc box">	
				<div class="m-postlst">

					<!-- <div class="m-post m-post-img">
						<div class="postinner">
							
							<div class="ct">
								<div class="ctc box">
									<div class="pic">	
										<a class="img" href="http://inschuanda.lofter.com/post/1ebda16f_112e6e9f">
											<img src="http://127.0.0.1:8080/image/20170919184020414.jpg">
										</a>
									</div>
								</div>
							</div>
							<div class="info box">
								<a class="date" href="http://inschuanda.lofter.com/post/1ebda16f_112e6e9f">时间：2017-09-19</a>
								<span class="sep">·</span><a class="hot" href="http://inschuanda.lofter.com/post/1ebda16f_112e6e9f">热度：4</a>
							</div>
						</div>
					</div> -->
					
				</div>
			</div>
		</div>
		
	</div>
	<!-- 尾部 -->
	<!-- <div class="g-ft">
		<p class="m-cprt">©&nbsp;<a href="/"></a>&nbsp;|&nbsp;Powered by <a href=""></a></p> 
	</div> -->
</div>

</body>
</html>