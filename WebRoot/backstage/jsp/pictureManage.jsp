<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="backstage/assets/css/amazeui.min.css" />
    <link rel="stylesheet" href="backstage/assets/css/admin.css">
    <link rel="stylesheet" href="backstage/assets/css/app.css">
  </head>
  <style>
.am-u-sm-12 am-u-md-6 am-u-lg-4{
	width: 24%;
}
.tpl-table-images-content {    
    height: 400px;
}
.tpl-table-images-content-i img {
    height: 140px;
}
.tpl-table-images-content .tpl-i-font {
    height: 3em;
}

</style>
<body>

   			 <div  id="table" class="tpl-portlet-components">
                <div class="portlet-title">
                    <div class="caption font-green bold">
                        <span class="am-icon-code"></span> 列表
                    </div>
                    <div class="tpl-portlet-input tpl-fz-ml">
                        <div class="portlet-input input-small input-inline">
                            <div class="input-icon right">
                                <i class="am-icon-search"></i>
                                <input type="text" class="form-control form-control-solid" placeholder="搜索..."> </div>
                        </div>
                    </div>


                </div>
                <div class="tpl-block">
                    <div class="am-g">
                        <div class="am-u-sm-12 am-u-md-6">
                            <div class="am-btn-toolbar">
                                <div class="am-btn-group am-btn-group-xs">
                                    <button type="button"  id="refresh"   class="am-btn am-btn-default am-btn-warning"><span class="am-icon-archive"></span> 刷新</button>
                                    <button type="button"  id="delete" class="am-btn am-btn-default am-btn-danger"><span class="am-icon-trash-o"></span> 删除</button>
                                </div>
                            </div>
                        </div>
                        
                        <div class="am-u-sm-12 am-u-md-3">
                            <div class="am-input-group am-input-group-sm">
                                <input type="text" class="am-form-field">
                                <span class="am-input-group-btn">
            <button class="am-btn  am-btn-default am-btn-success tpl-am-btn-success am-icon-search" type="button"></button>
          </span>
                            </div>
                        </div>
                    </div>
                    <div class="am-g">
                        <div class="tpl-table-images" id="picture">
                            
                            
                           
                            
                            <div class="am-u-lg-12">
                                <div class="am-cf">

                                    <div class="am-fr">
                                        <ul class="am-pagination tpl-pagination">
                                            <li class="am-disabled"><a href="#">«</a></li>
                                            <li class="am-active"><a href="#">1</a></li>
                                            <li><a href="#">2</a></li>
                                            <li><a href="#">3</a></li>
                                            <li><a href="#">4</a></li>
                                            <li><a href="#">5</a></li>
                                            <li><a href="#">»</a></li>
                                        </ul>
                                    </div>
                                </div>
                                <hr>
                            </div>

                        </div>

                    </div>
                </div>
                <div class="tpl-alert"></div>
            </div>
  </body>
  <script  type="text/javascript"  charset="utf-8" src="backstage/assets/js/jquery.min.js"></script>
   <script  type="text/javascript"  charset="utf-8" src="backstage/assets/js/common.js"></script>
   <script  type="text/javascript"  charset="utf-8" src="backstage/assets/js/userManage/pictureManage.js"></script>
    <script src="backstage/assets/js/amazeui.min.js"></script>
</html>
