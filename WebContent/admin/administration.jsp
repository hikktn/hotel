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
     <ul class="list-group">
         <a class="list-group-item active"> 房间管理 </a>
         <div class="list-group-item">
         <!-- 搜索框 -->
         <nav class="navbar navbar-default" role="navigation" id="query">
			   <div class="container-fluid"> 
				    <div class="navbar-header">
				        <a class="navbar-brand" href="#">蓝桥酒店</a>
				    </div>
				    <div class="search">
			        	<div class="input-group">   
				            <input id="search_kw" type="text" name="myname" class="form-control ui-com"  placeholder="请输入房间名">
				            <span class="input-group-addon" id="mark"><i class="glyphicon glyphicon-search"></i></span>
			            </div>
				    </div>
			    </div>
			</nav>
		<!-- 查询房间详细信息 -->
        <div class="panel-body">
				<table class="table table-bordered table-hover" onclick="selectRow(this)">
					<thread>
						<tr>
							<th>房间号</th>
							<th>级别</th>
							<th>窗类型</th>
							<th>床类型</th>
							<th>面积</th>
							<th>描述</th>
							<th>房间设施</th>
							<th>标签</th>
							<th>价格</th>
							<th>封面</th>
							<th>操作</th>
						</tr>
					</thread>
					<tbody>
					<c:forEach items="${rooms }" var="room">
					<tr class="mytable">
						<td>${room.id }</td>
						<td>${room.level.level }</td>
						<td>${room.window.window }</td>
						<td>${room.bed.number }张${room.bed.width }m${room.bed.bed }</td>
						<td>${room.area.area }</td>
						<td>
							<c:forEach items="${room.describe}" var="desc">
								<span>${desc.level.level }${desc.local.localcontent }&nbsp;</span>
							</c:forEach>
						</td>
						<td>
							便利设施：<c:forEach items="${room.facilities.roomEasy.easy }" var="easy">
										<span>${easy.facilities }</span>
									  </c:forEach>
						<hr>
							媒体科技：<c:forEach items="${room.facilities.roomMedia.media }" var="media">
										<span>${media.facilities }</span>
								  	 </c:forEach>
						</td>
						<td>
							<c:forEach items="${room.roomHotelLocals.hotelLocal }" var="hotellocal">
								<span>${hotellocal.local }</span>
							</c:forEach>
						</td>
						<td>￥${room.price }</td>
						<td>
							<c:forEach items="${room.images }" var="image">
								<a href="/hotelSystem/room/getIamges?oldimg=${image.id }">${image.oldimg }</a>
							</c:forEach>
						</td>
						<td>
							<input type="button" value="修改" class="btn btn-primary" >
							<input type="button" value="删除" class="btn btn-warning">
						</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
      </div>
     </ul>
</body>
<script type="text/javascript" src="../js/backstage2.js"></script>
<script type="text/javascript" src="../js/updateroom.js"></script>
</html>