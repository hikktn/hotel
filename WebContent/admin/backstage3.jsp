<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.bootcss.com/layer/3.0.3/mobile/need/layer.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap-fileinput/4.4.2/css/fileinput.min.css">
<title>蓝桥酒店后台管理</title>
</head>
<body>
		<!-- 响应式导航 -->
		<nav class="navbar navbar-default" role="navigation">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#menu">
					<span class="sr-only">展开导航</span> <span class="icon-bar"></span> <span
						class="icon-bar"></span> <span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">蓝桥酒店后台管理</a>
			</div>
			<div class="collapse navbar-collapse" id="menu">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">首页</a></li>
				</ul>
			</div>
		</nav>
		<div class="container" style="margin-top: 30px">
			<div class="row">
				<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2 mouse" id="left-content">
					<ul class="nav nav-pills nav-stacked" id="menu">
						<li class="active"><a href="http://localhost:8080/hotelSystem/rooms/getAll" id="administration">房间管理</a></li>
	                    <li id="add"><a href="http://localhost:8080/hotelSystem/rooms/getAddRoom">添加房间</a></li>
	                    <li id="order"><a href="">订单管理</a></li>
	                    <li id="bedorwindow"><a href="http://localhost:8080/hotelSystem/rooms/bedorwindow">床/窗管理</a></li>
	                    <li id="facilities"><a href="http://localhost:8080/hotelSystem/rooms/facilitiesorlocal">设施/标签管理</a></li>
					</ul>
				</div>
				<div id="right-content" class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
					<div class="mainbox">
					
					</div>
				</div>
				
		</div>
	</div>
</body>
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/layer/3.0.3/layer.js"></script>
<!-- 基于Bootstrap的多图片（文件也可以）上传、预览、删除、缩放、进度...显示 -->
<script src="https://cdn.bootcss.com/bootstrap-fileinput/4.4.2/js/fileinput.min.js "></script>
<script src="https://cdn.bootcss.com/bootstrap-fileinput/4.4.2/js/locales/zh.js " charset="UTF-8"></script>
<script type="text/javascript" src="../js/forward.js"></script>
</html>