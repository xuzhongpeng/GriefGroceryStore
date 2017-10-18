<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
 <base href="<%=basePath%>">
<html>
<head>
<meta charset="UTF-8">
<title>Uploader</title>
<link rel="stylesheet" type="text/css" href="module/unit/webuploade/webuploader.css" />
<link rel="stylesheet" type="text/css" href="module/unit/webuploade/style.css" />
<script src="module/js/jquery.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" src="module/js/cookie.js"></script>
<script type="text/javascript" src="module/unit/webuploade/webuploader.js"></script>
<script type="text/javascript" src="module/js/main/headImgUpload.js"></script>
</head>

<body>
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
</body>
</html>