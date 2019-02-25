<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap-fileinput/4.4.2/css/fileinput.min.css">
<link rel="stylesheet" href="/hotelSystem/css/backstage.css">
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>  
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!-- 基于Bootstrap的多图片（文件也可以）上传、预览、删除、缩放、进度...显示 -->
<script src="https://cdn.bootcss.com/bootstrap-fileinput/4.4.2/js/fileinput.min.js "></script>
<script src="https://cdn.bootcss.com/bootstrap-fileinput/4.4.2/js/locales/zh.js " charset="UTF-8"></script>
<script type="text/javascript" src="/hotelSystem/js/backstage.js"></script>
<title>蓝桥酒店后台管理</title>
</head>
<body>
<div>
	<!-- 响应式导航 -->
	  <nav class="navbar navbar-default" role="navigation"> 
	    <div class="navbar-header">
	        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#menu">
	            <span class="sr-only">展开导航</span>
	            <span class="icon-bar"></span>
	            <span class="icon-bar"></span>
	            <span class="icon-bar"></span> 
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
            <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3 mouse">
                <ul class="nav nav-pills nav-stacked userMenu">
                    <li role="administration" class="active" data-id="administration"><a href="#administration">房间管理</a></li>
                    <li role="presentation" data-id="add"><a href="#add">添加房间</a></li>
                    <li role="presentation" data-id="order"><a href="#order">订单管理</a></li>
                    <li role="presentation" data-id="bedorwindow"><a href="#bedorwindow">床/窗管理</a></li>
                    <li role="presentation" data-id="facilities"><a href="#facilities">设施/标签管理</a></li>
                    <li role="presentation" data-id="offers"><a href="#offers">今日特价房</a></li>
                </ul>
            </div>
			<div id="contenet" class="col-lg-9 col-md-9 col-sm-9 col-xs-9"></div>
        </div>
        
        
    </div>
</div>
</body>
<script type="text/javascript">
$(function() {
	 $(".userMenu").on("click", "li", function() {
         var sId = $(this).data("id"); //获取data-id的值
         window.location.hash = sId; //设置锚点
         loadInner(sId);
     });
	 function loadInner(sId) {
         var sId = window.location.hash;
         var pathn, i;
         switch(sId) {
             case "#administration":
                 pathn = "admin/administration.jsp";
                 i = 0;
                 break;
             case "#add":
                 pathn = "add.jsp";
                 i = 1;
                 break;
             case "#order":
                 pathn = "order.jsp";
                 i = 2;
                 break;
             case "#bedorwindow":
                 pathn = "bedorwindow.jsp";
                 i = 3;
                 break;
             case "#facilities":
                 pathn = "facilities.jsp";
                 i = 3;
                 break;
             case "#offers":
                 pathn = "offers.jsp";
                 i = 3;
                 break;
             default:
                 pathn = "administration.jsp";
                 i = 0;
                 break;
         }
         $("#contenet").load(pathn); //加载相对应的内容
     }
     var sId = window.location.hash;
     loadInner(sId);

});
</script>

</html>