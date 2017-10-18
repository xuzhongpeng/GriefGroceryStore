<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <link rel="icon" type="image/png" href="module/img/favicon.png">
	<link rel="stylesheet" href="module/css/amazeui.min.css">
	<link rel="stylesheet" href="module/css/app.css">
	<link rel="stylesheet" href="module/jsp/header/header.css">
	<link rel="stylesheet" href="module/jsp/center/center.css">
	<link rel="stylesheet" href="module/css/common.css">	
	<link rel="stylesheet" type="text/css" href="module/css/main/personalInformation.css">
	
	
	<script src="module/js/jquery.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript" src="module/unit/layer/layer.js"></script>
	<script type="text/javascript" src="module/js/cookie.js"></script>
	<!-- <script src="header/canvas.js" type="text/javascript" charset="utf-8"></script> --><!-- 背景 -->
	<script src="module/js/common.js" type="text/javascript" charset="utf-8" ></script><!-- 引用第一步 -->
	<script src="module/jsp/header/header.js" type="text/javascript" charset="utf-8"></script><!-- 头部 -->
	
	<script src="module/js/main/register.js" type="text/javascript" charset="utf-8" ></script>
	<script type="text/javascript">
	$(function(){
		$("#question").click(function(){
	    	layer.open({
	    	    type: 2,
	    	    area: ['850px', '550px'],
	    	    shade: false,
	    	    title: false,
	    	    content: 'module/jsp/main/uploader.jsp'
	    	});
	    });
	});
</script>
</head>
<body>
	<header id="header"></header>
	<div class="center">
		<div class="dt0">
			<div class="tpl-portlet-components">
                <div class="portlet-title">
                    <div class="caption font-green bold">
                        </span> 注册
                    </div>
                   


                </div>

                <div class="tpl-block">

                    <div class="am-g">
                        <div class="tpl-form-body tpl-form-line">
                            <form class="am-form tpl-form-line-form">
                            	<div class="am-form-group">
                                    <label for="user-name" class="am-u-sm-3 am-form-label">账号<span class="tpl-form-line-small-title">userID</span></label>
                                    <div class="am-u-sm-9">
                                        <input type="text" class="tpl-form-input" id="userID" placeholder="请输入登录号">
                                        
                                    </div>
                                </div>
                                <div class="am-form-group">
                                    <label for="user-name" class="am-u-sm-3 am-form-label">用户名<span class="tpl-form-line-small-title">userName</span></label>
                                    <div class="am-u-sm-9">
                                        <input type="text" class="tpl-form-input" id="user-name" placeholder="请输入用户名">
                                        
                                    </div>
                                </div>

                                <div class="am-form-group">
                                    <label for="user-email" class="am-u-sm-3 am-form-label">登录密码 <span class="tpl-form-line-small-title">password</span></label>
                                    <div class="am-u-sm-9">
                                        <input type="password" id="password" class="am-form-field tpl-form-no-bg" placeholder="登录密码" data-am-datepicker=""/>
                                        
                                    </div>
                                </div>

                                <div class="am-form-group">
                                    <label for="user-phone" class="am-u-sm-3 am-form-label">email <span class="tpl-form-line-small-title"></span></label>
                                    <div class="am-u-sm-9">
                                       <input type="text" id="email" class="am-form-field tpl-form-no-bg" placeholder="email"/>
                                    </div>
                                </div>
                                <div class="am-form-group">
                                    <label for="user-weibo" class="am-u-sm-3 am-form-label">头像 <span class="tpl-form-line-small-title">Images</span></label>
                                    <div class="am-u-sm-9">
                                        <div class="am-form-group am-form-file">
                                            <input type="hidden" id="pictureID">
                                                <img id='myheadImg' src="" style='display:none;width:50px;height:50px;'>
                                            </div>
                                            <input type="button" value="上传图片" id="question" class="webuploader-pick" style="height:33px;font-size:14px;padding:6px 9px;background-color:#cc9898">
                                        </div>

                                    </div>
                                </div>

                                

                                <div class="am-form-group">
                                    <div class="am-u-sm-9 am-u-sm-push-3">
                                        <button type="button" id="puOn" class="am-btn am-btn-primary tpl-btn-bg-color-success ">提交</button>
                                    </div>
                                </div>
                            </form>

                        </div>
                    </div>
                </div>


            </div>
		</div>
	</div>
</body>
</html>