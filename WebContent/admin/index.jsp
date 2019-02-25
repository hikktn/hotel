<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()+ path + "/";%>
  
<!DOCTYPE html >
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">   <%-- 在IE运行最新的渲染模式 --%>
<meta name="viewport" content="width=device-width, initial-scale=1">   <%-- 初始化移动浏览显示 --%>
<meta name="Author" content="Dreamer-1.">
<!-- 引入各种CSS样式表 -->
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
<link rel="stylesheet" href="../css/index.css">	<!-- 修改自Bootstrap官方Demon，你可以按自己的喜好制定CSS样式 -->

<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>后台管理系统</title>
</head>
<body>
<!-- 顶部菜单（来自bootstrap官方Demon）==================================== -->
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
      	<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" >
            	<span class="sr-only">Toggle navigation</span>
            	<span class="icon-bar"></span>
            	<span class="icon-bar"></span>
            	<span class="icon-bar"></span>
			</button>
			<ul class="nav navbar-nav">
	         	<li><a class="navbar-brand" href="index.jsp">蓝桥酒店后台管理系统</a></li>
				<li><a href="#">首页</a></li>
			</ul>
      </div>
      		
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav navbar-right">			            
				<li><a>超级管理员</a></li>
			</ul>
        			
      	</div>
   </div>
</nav>

<!-- 左侧菜单选项========================================= -->
<div class="container" style="margin-top: 30px">
	<div class="row">
		<div class="col-sm-3 col-md-2 sidebar panel-group" id="menu">	
			<ul class="nav nav-pills nav-stacked panel">
				<li class="panel-heading">
				<a href="##"  data-toggle="collapse" data-target="#collapseOne" id="administration" data-parent="#menu">房间管理</a>
				</li>
				<ul id="collapseOne" class="nav nav-list panel-collapse collapse">
					<li><a href="###"> 用户列表</a></li>
				</ul>
                <li data-id="add"><a href="#####"  data-toggle="collapse"  data-target="#collapseTwo" id="administration" data-parent="#menu">添加房间</a></li>
                <ul id="collapseTwo" class="panel-collapse collapse">
					<li><a href="###"> 用户列表</a></li>
				</ul>
                <li data-id="order"><a href="#order">订单管理</a></li>
                <li data-id="bedorwindow"><a href="#bedorwindow">床/窗管理</a></li>
                <li data-id="facilities"><a href="#facilities">设施/标签管理</a></li>
                <li data-id="offers"><a href="#offers">今日特价房</a></li>
			</ul>
		</div>	
	</div>
</div>

</body>
</html>