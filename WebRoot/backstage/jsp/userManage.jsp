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
  
  <body>
    <div id="table" class="tpl-block">
                    <div class="am-g">
                        <div class="am-u-sm-12 am-u-md-6">
                            <div class="am-btn-toolbar">
                                <div class="am-btn-group am-btn-group-xs">
                                    <button type="button" id="add" class="am-btn am-btn-default am-btn-success"><span class="am-icon-plus"></span> 新增</button>
                                    <button type="button" id="refresh" class="am-btn am-btn-default am-btn-secondary"><span class="am-icon-refresh"></span> 刷新</button>                                
                                    <button type="button" id="delete" class="am-btn am-btn-default am-btn-danger"><span class="am-icon-trash-o"></span> 删除</button>
                                </div>
                            </div>
                        </div>
                        <div class="am-u-sm-12 am-u-md-3">
                            
                        </div>
                        <div class="am-u-sm-12 am-u-md-3">
                            <div class="am-input-group am-input-group-sm">
                                <input type="text" id="searchData" class="am-form-field">
                                <span class="am-input-group-btn">
						            <button id="search" class="am-btn  am-btn-default am-btn-success tpl-am-btn-success am-icon-search" type="button"></button>
						         </span>
                            </div>
                        </div>
                    </div>
                    <div class="am-g">
                        <div class="am-u-sm-12">
                            <form class="am-form">
                                <table class="am-table am-table-striped am-table-hover table-main">
                                    <thead>
                                        <tr>
                                            <th class="table-check"><input type="checkbox" class="tpl-table-fz-check"></th>
                                            <th class="table-id">ID</th>
                                            <th class="table-title">用户名</th>
                                            <th class="table-type">密码</th>
                                            <th class="table-author">类型</th>
                                            <th class="table-date">注册时间</th>
                                            <th class="table-type">email</th>
                                            <th class="table-type">头像</th>
                                            <th class="table-set">操作</th>
                                        </tr>
                                    </thead>
                                    <tbody id="tbody">
                                        
                                    </tbody>
                                </table>
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
   		
                            </form>
                        </div>

                    </div>
                </div>
  </body>
  <script  type="text/javascript"  charset="utf-8" src="backstage/assets/js/jquery.min.js"></script>
   <script  type="text/javascript"  charset="utf-8" src="backstage/assets/js/common.js"></script>
   <script  type="text/javascript"  charset="utf-8" src="backstage/assets/js/userManage/userManage.js"></script>
    <script src="backstage/assets/js/amazeui.min.js"></script>
  
  
</html>
