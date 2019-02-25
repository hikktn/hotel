<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<link rel="stylesheet" href="../css/backstage.css">
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap-fileinput/4.4.2/css/fileinput.min.css">
<script src="https://cdn.bootcss.com/bootstrap-fileinput/4.4.2/js/fileinput.min.js "></script>
<script src="https://cdn.bootcss.com/bootstrap-fileinput/4.4.2/js/locales/zh.js " charset="UTF-8"></script>
<script type="text/javascript" src="../js/backstage2.js"></script>
<body>
	<div class="biank">
		<ul class="list-group">
			<a class="list-group-item active"> 增加房间 </a>
		</ul>
		<form method="post" action="" onsubmit="return false"
			enctype="multipart/form-data" id="oForm" name="oForm">
			<table>
				<tr>
					<td class="col-lg-2 col-md-2 col-sm-2 col-xs-2">房间号：</td>
					<td class="col-lg-10 col-md-10 col-sm-10 col-xs-10"><input
						type="text" name="room" class="room"></td>
				</tr>
				<tr>
					<td class="col-lg-2 col-md-2 col-sm-2 col-xs-2">标题：</td>
					<td class="col-lg-10 col-md-10 col-sm-10 col-xs-10"><select
						id="select1" name="level">
							<c:forEach items="${ roomlevels}" var="levels">
								<option value="${levels.id }">${levels.level }</option>
							</c:forEach>
					</select> <select id="select2" name="local">
							<c:forEach items="${ locals}" var="locals">
								<option value="${locals.localid }">${locals.localcontent }</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td class="col-lg-2 col-md-2 col-sm-2 col-xs-2">级别：</td>
					<td class="col-lg-10 col-md-10 col-sm-10 col-xs-10"><select
						id="select3" name="level">
							<c:forEach items="${ roomlevels}" var="levels">
								<option value="${levels.id }">${levels.level }</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td class="col-lg-2 col-md-2 col-sm-2 col-xs-2">窗类型：</td>
					<td class="col-lg-10 col-md-10 col-sm-10 col-xs-10"><select
						id="select4" name="window">
							<c:forEach items="${windows }" var="windows">
								<option value="${windows.id }">${windows.window }</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td class="col-lg-2 col-md-2 col-sm-2 col-xs-2">床类型：</td>
					<td class="col-lg-10 col-md-10 col-sm-10 col-xs-10"><select
						id="select5" name="bed">
							<c:forEach items="${beds }" var="beds">
								<option value="${beds.id }">${beds.number }张${beds.width }m${beds.bed }</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td class="col-lg-2 col-md-2 col-sm-2 col-xs-2">面积：</td>
					<td class="col-lg-10 col-md-10 col-sm-10 col-xs-10"><input
						type="text" name="area" class="area" min="10" max="160"><span>㎡</span>
					</td>
				</tr>
				<tr>
					<td class="col-lg-2 col-md-2 col-sm-2 col-xs-2">房间设施：</td>
					<td class="col-lg-10 col-md-10 col-sm-10 col-xs-10">便利设施： <c:forEach
							items="${easy }" var="easy">
							<input type="checkbox" id="check1" name="easy"
								value="${easy.id }">${easy.facilities }
                                                   					</c:forEach>
						<hr> 媒体科技： <c:forEach items="${medias }" var="media">
							<input type="checkbox" id="check2" name="medias"
								value="${media.id }">${media.facilities }
                                                    				</c:forEach>
					</td>
				</tr>
				<tr>
					<td class="col-lg-2 col-md-2 col-sm-2 col-xs-2">房间标签：</td>
					<td class="col-lg-10 col-md-10 col-sm-10 col-xs-10"><c:forEach
							items="${hotelLocal }" var="hotelLocal">
							<input type="checkbox" id="check3" name="hotellocal"
								value="${hotelLocal.id }">${hotelLocal.local }
                                                    				</c:forEach></td>
				</tr>
				<tr>
					<td class="col-lg-2 col-md-2 col-sm-2 col-xs-2">价格：</td>
					<td class="col-lg-10 col-md-10 col-sm-10 col-xs-10"><input
						type="text" name="price" class="price" min="0" max="998"><span>¥</span></td>
				</tr>
				<tr>
					<td class="col-lg-2 col-md-2 col-sm-2 col-xs-2">上传封面：</td>
					<td class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
						<div class="form-group" id="upload">
							<input id="myFile" name="myFile" type="file" multiple
								data-show-caption="true" data-show-upload="false">
						</div>
					</td>
				</tr>
				<tr>
					<td><input type="submit" value="提交" id="button"
						class="btn btn-primary"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>