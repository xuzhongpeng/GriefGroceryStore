<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html>

<head>
    <base href="<%=basePath%>">
    

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>解忧杂货铺后台管理</title>
    <meta name="description" content="这是一个 index 页面">
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="icon" type="image/png" href="backstage/assets/i/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="backstage/assets/i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="Amaze UI" />
    <link rel="stylesheet" href="backstage/assets/css/amazeui.min.css" />
    <link rel="stylesheet" href="backstage/assets/css/admin.css">
    <link rel="stylesheet" href="backstage/assets/css/app.css">
    <script src="backstage/assets/js/echarts.min.js"></script>
    <script src="backstage/assets/js/cookie.js"></script>
</head>

<body data-type="index" id="default">


    <header class="am-topbar am-topbar-inverse admin-header">
        <div class="am-topbar-brand">
            <a href="javascript:;" class="tpl-logo">
                <img src="backstage/assets/img/logo.png" alt="">
            </a>
        </div>
        <div class="am-icon-list tpl-header-nav-hover-ico am-fl am-margin-right">

        </div>

        <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only" data-am-collapse="{target: '#topbar-collapse'}"><span class="am-sr-only">导航切换</span> <span class="am-icon-bars"></span></button>

        <div class="am-collapse am-topbar-collapse" id="topbar-collapse">

            <ul class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list tpl-header-list">                
                <li class="am-hide-sm-only"><a href="javascript:;" id="admin-fullscreen" class="tpl-header-list-link"><span class="am-icon-arrows-alt"></span> <span class="admin-fullText">开启全屏</span></a></li>

                <li class="am-dropdown" data-am-dropdown data-am-dropdown-toggle>
                    <a class="am-dropdown-toggle tpl-header-list-link" href="javascript:;">
                        <span id="userName11" class="tpl-header-list-user-nick">禁言小张</span><span class="tpl-header-list-user-ico"> 
                        <img id="headImg" src="backstage/assets/img/user01.png"></span>
                    </a>
                    <ul class="am-dropdown-content">
                        <li><a href="#"><span class="am-icon-bell-o"></span> 资料</a></li>
                        <li><a href="#"><span class="am-icon-cog"></span> 设置</a></li>
                        <li><a href="backstage/login.html"><span class="am-icon-power-off"></span> 退出</a></li>
                    </ul>
                </li>
                <li><a href="backstage/login.html" class="tpl-header-list-link"><span class="am-icon-sign-out tpl-header-list-ico-out-size"></span></a></li>
            </ul>
        </div>
    </header>







    <div class="tpl-page-container tpl-page-header-fixed">


        <div class="tpl-left-nav tpl-left-nav-hover">
            <div class="tpl-left-nav-title">
                列表
            </div>
            <div class="tpl-left-nav-list">
                <ul class="tpl-left-nav-menu">
                    <li class="tpl-left-nav-item">
                        <a href="backstage/jsp/userManage.jsp" class="nav-link active">
                            <i class="am-icon-users"></i>
                            <span>用户管理</span>
                        </a>
                    </li>
                    <li class="tpl-left-nav-item">
                        <a href="backstage/jsp/dailyManage.jsp" class="nav-link tpl-left-nav-link-list">
                            <i class="am-icon-square-o"></i>
                            <span>日常管理</span>                           
                        </a>
                    </li>

                    <li class="tpl-left-nav-item">
                        <a href="backstage/jsp/pictureManage.jsp" class="nav-link tpl-left-nav-link-list">
                            <i class="am-icon-picture-o"></i>
                            <span>图片管理</span>                           
                        </a>
                    </li>
                     <li class="tpl-left-nav-item">
                        <a href="backstage/jsp/comment.jsp" class="nav-link tpl-left-nav-link-list">
                            <i class="am-icon-commenting-o"></i>
                            <span>评论管理</span>                           
                        </a>
                    </li>

                    <li class="tpl-left-nav-item">
                        <a href="backstage/assets/login.html" class="nav-link tpl-left-nav-link-list">
                            <i class="am-icon-key"></i>
                            <span>登录</span>

                        </a>
                    </li>
                </ul>
            </div>
        </div>
<!-- 右边内容 -->
        <div class="tpl-content-wrapper">            
            <ol class="am-breadcrumb">
                <li><a href="#" class="am-icon-home">首页</a></li>
                <li><a href="#">分类</a></li>
                <li class="am-active">内容</li>
            </ol>
           	<iframe src="backstage/jsp/userManage.jsp" id="iframeId" frameborder="0" scrolling="no"
           	 style="width: 100%;min-height:500px;"></iframe>


        </div>
        <script>

</script>
    <script src="backstage/assets/js/jquery.min.js"></script>
    <script src="backstage/assets/js/amazeui.min.js"></script>
    <script src="backstage/assets/js/iscroll.js"></script>
    <script src="backstage/assets/js/app.js"></script>
    <script src="backstage/assets/js/userManage/default.js"></script>
</body>

</html>