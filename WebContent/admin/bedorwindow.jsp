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
<div class="row">
   	<!--窗类型操作 -->
     <div class="col-xs-5 col-md-5 border">
       	<div>
			<button type="button" class="btn btn-primary" id="addWind">添加</button>
       	</div>
		<!--窗类型-->
       	<table class="table table-bordered">
			<tr>
				<td>窗序号</td>
				<td>窗类型</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${windows}" var="win">
			<tr class="mywindow">
				<td>${win.id}</td>
				<td>${win.window}</td>
				<td><button type="button" class="btn btn-sm" value="${win.window}">更新</button></td>
			</tr>
			</c:forEach>
		</table>
     </div>
		
	
        <!-- 床类型操作 -->
      <div class="col-xs-6 col-md-6 border">
       	<div>
			<button type="button" class="btn btn-primary" id="addBed">添加</button>
       	</div>
		<table class="table table-bordered">
			<tr>
				<td>id</td>
				<td>床数量</td>
				<td>宽度</td>
				<td>床类型</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${beds}" var="bed">
			<tr class="mybed">
				<td>${bed.id}</td>
				<td>${bed.number}</td>
				<td>${bed.width}m</td>
				<td>${bed.bed}</td>
				<td><button type="button" class="btn btn-sm" class="upBed">更新</button>
				</td>
			</tr>
			</c:forEach>
		</table>
	</div>
</div>
</body>
<script src="../js/bedOrWindow.js" type="text/javascript"></script>
</html>