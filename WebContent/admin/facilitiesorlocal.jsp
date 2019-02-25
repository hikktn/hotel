<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<link rel="stylesheet" href="../css/backstage.css">
<body>
<div>
	<div class="container-full">
    <div class="row">
    	<!--标签操作 -->
        <div class="col-xs-4 col-md-4">
        	<div>
				<button type="button" class="btn btn-primary" id="addHotelLocal">添加</button>
        	</div>
			<!--标签类型-->
        	<table class="table table-bordered">
				<tr>
					<td>id</td>
					<td>房间标签名</td>
					<td>操作</td>
				</tr>
				<c:forEach items="${hotelLocal}" var="hl">
				<tr class="myhotellocal">
					<td>${hl.id}</td>
					<td>${hl.local}</td>
					<td>
					<button type="button" class="btn btn-sm"  class="updateLabel" value="${hl.local}">更新</button>
					</td>
				</tr>
				</c:forEach>
			</table>
        </div>
		<!--设施操作 -->
        <div class="col-xs-4 col-md-4">
        	<div>
				<button type="button" class="btn btn-primary" id="addEasy">添加</button>
        	</div>
			<!--便利设施标签类型-->
        	<table class="table table-bordered">
				<tr>
					<td>id</td>
					<td>便利设施标签名</td>
					<td>操作</td>
				</tr>
				<c:forEach items="${easy}" var="easy">
				<tr class="myeasy">
					<td>${easy.id}</td>
					<td>${easy.facilities}</td>
					<td>
						<button type="button" class="btn btn-sm"  class="updatefacility" value="${easy.facilities}">更新</button>
					</td>
				</tr>
				</c:forEach>
			</table>
        </div>
        
        <!--媒体科技标签类型-->
        <div class="col-xs-4 col-md-4">
        	<div>
				<button type="button" class="btn btn-primary" id="addMedia">添加</button>
        	</div>
			<!--标签类型-->
        	<table class="table table-bordered">
				<tr>
					<td>id</td>
					<td>媒体科技标签名</td>
					<td>操作</td>
				</tr>
				<c:forEach items="${medias}" var="media">
				<tr class="mymedia">
					<td>${media.id}</td>
					<td>${media.facilities}</td>
					<td>
						<button type="button" class="btn btn-sm"  class="updatefacility" value="${media.facilities}">更新</button>
					</td>
				</tr>
				</c:forEach>
			</table>
        </div>
		
	</div>
	</div>
</div>
</body>
<script src="../js/facilitiesOrLocal.js" type="text/javascript"></script>
</html>