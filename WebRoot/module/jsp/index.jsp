<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>首页</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">	
    <link rel="icon" type="image/png" href="module/img/favicon.png">
	<link rel="stylesheet" href="module/jsp/header/header.css">
	<link rel="stylesheet" href="module/jsp/center/center.css">
	<link rel="stylesheet" href="module/css/index.css">
	<link rel="stylesheet" href="module/css/common.css">
	<link rel="stylesheet" type="text/css" href="module/css/comment.css">
	<script src="module/js/jquery.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript" src="module/js/cookie.js"></script>
	<script type="text/javascript" src="module/unit/webuploade/webuploader.js"></script>
    <script type="text/javascript" src="module/js/upload.js"></script>
	<script src="module/js/common.js" type="text/javascript" charset="utf-8" ></script>
	<script src="module/jsp/header/header.js" type="text/javascript" charset="utf-8"></script><!-- 头部 -->
	<script src="module/jsp/center/center.js" type="text/javascript" charset="utf-8"></script>
	<script src="module/js/index.js" type="text/javascript" charset="utf-8" ></script>

	<!-- 插件 -->
	<script type="text/javascript" src="module/unit/ckeditor/ckeditor.js"></script>
	<link rel="stylesheet" type="text/css" href="module/unit/webuploade/style.css" />
	<link rel="stylesheet" type="text/css" href="module/unit/webuploade/webuploader.css" />
	<script src="module/unit/webuploade/webuploade.js" type="text/javascript" charset="utf-8" ></script>
	<script src="module/js/content.js" type="text/javascript" charset="utf-8" ></script><!-- 引用最后一步 公共组件调用 -->
</head>
<body>
	<!-- <canvas id="canvas">您的浏览器不支持，请升级最新的版本!</canvas> -->
	<header id="header"></header>
	<div class="center">
		<div class="left">
		<ul id="publishPostBar" class="m-nav2">
            <li class="user">
                    <a id="toUser" href="module/jsp/main/personHomepage.jsp"><img id='headImg' src="module/img/touxiang/zhangwanqing.jpg"></a>
            </li>
                <li><a class="publishlink n21" href="javascript:void" >文字</a></li>
                <li><a class="publishlink n22" href="javascript:void" >图片</a></li>
                <li><a class="publishlink n23" href="javascript:void">长文章</a></li>
        </ul>
        <div id="caozuo">
	        <!-- 写文字 -->
	        <div id='writeText'>
	        	<textarea id="TextArea1" name="TextArea1" cols="20" rows="2" class="ckeditor"></textarea>
	        	<button class="button" id="uptextdown">发布</button>
	        </div>
	        <!-- 图片上传 -->
			 <div id="wrapper">
			 	<textarea  type='textarea' class='titleArea' id="picContent" placeholder='说说图片的故事'></textarea>
			 	<input id="pictureID" type="hidden" value="none">
		        <div id="container">
					<!--头部，相册选择和格式选择 -->
					<div id="uploader">
						<div class="queueList">
							<div id="dndArea" class="placeholder">
								<div id="filePicker"></div>
								<p>或将照片拖到这里，单次最多可选300张</p>
							</div>
						</div>
						<div class="statusBar" style="display: none;">
							<div class="progress">
								<span class="text">0%</span> <span class="percentage"></span>
							</div>
							<div class="info"></div>
							<div class="btns">
								<div id="filePicker2"></div>
								<div class="uploadBtn">开始上传</div>
							</div>
						</div>
					</div>
				</div>
				<button class="button" id="upPicturedown">发布</button>
	        </div>
	        <!-- 文章 -->
	        <div id="articleText">
	        	<input id="articleTitle" type="text" class="titleArea" placeholder="标题">
	        	<textarea id="TextArea2" cols="20" rows="2" class="ckeditor"></textarea>
	        	<button id="articleButton" class="button">发布</button>
	        </div>
        </div>
        <div class="leftInformation">
        
        	
		</div><!-- leftinfomation -->
		</div><!-- left -->
		<div class="rightContent">
			<div class="userInfo">
				<h4>永无岛</h4>
				<ul>
					<li>文章<span>5</span></li>
					<li>喜欢<span>2</span></li>
					<li>关注<span>0</span></li>
				</ul>
			</div>
			<div class="remen">
				<p>热门</p>
				<ul>
					<li>喜欢</li>
					<li>喜欢</li>
					<li>关注</li>
				</ul>
			</div>
		
		</div><!-- rightContent -->
	</div>


</body>
	
</html>
