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
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap-fileinput/4.4.2/css/fileinput.min.css">
<link rel="stylesheet" href="../css/backstage.css">
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!-- 基于Bootstrap的多图片（文件也可以）上传、预览、删除、缩放、进度...显示 -->
<script src="https://cdn.bootcss.com/bootstrap-fileinput/4.4.2/js/fileinput.min.js "></script>
<script src="https://cdn.bootcss.com/bootstrap-fileinput/4.4.2/js/locales/zh.js " charset="UTF-8"></script>
<script type="text/javascript" src="../js/backstage2.js"></script>
<title>蓝桥酒店后台管理</title>
</head>
<body>
	<div class="">
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
				<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3 mouse">
					<ul class="nav nav-pills nav-stacked">
						<li role="presentation" class="active" data-id="administration"><a
							href="#">房间管理</a></li>
						<li role="presentation"><a href="#" data-id="add">添加房间</a></li>
						<li role="presentation"><a href="#" data-id="order">订单管理</a></li>
						<li role="presentation"><a href="#" data-id="bedorwindow">床/窗管理</a></li>
						<li role="presentation"><a href="#">房间标题管理</a></li>
						<li role="presentation"><a href="#" data-id="facilities">设施/标签管理</a></li>
						<li role="presentation"><a href="#" data-id="offers">今日特价房</a></li>
					</ul>
				</div>
				<div id="contenet"></div>
				<div class="col-lg-9 col-md-9 col-sm-9 col-xs-9">
					<ul class="list-group">
						<a class="list-group-item active"> 房间管理 </a>
						<div class="list-group-item">
							<!-- 搜索框 -->
							<nav class="navbar navbar-default" role="navigation">
								<div class="container-fluid">
									<div class="navbar-header">
										<a class="navbar-brand" href="#">蓝桥酒店</a>
									</div>
									<div class="navform">
										<form class="navbar-form navbar-left bs-example" role="search">
											<div class="input-group input-group-sm input-group-lg">
												<input id="search_kw" type="text" name="myname"
													class="form-control ui-com" placeholder="请输入房间名"> <span
													class="input-group-addon"><i
													class="glyphicon glyphicon-search"></i></span>
											</div>
										</form>
									</div>
									<div class="container-fluid navbar-btn ">
										<input type="submit" class="btn btn-primary" value="设为今日特价房">
									</div>
								</div>
							</nav>
							<!-- 查询房间详细信息 -->
							<div class="panel-body">
								<table class="table table-bordered table-hover">
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
											<tr>
												<td>${room.id }</td>
												<td>${room.level.level }</td>
												<td>${room.window }</td>
												<td>${room.bed.number }张${room.bed.width }m${room.bed.bed }</td>
												<td>${room.area.area }</td>
												<td><c:forEach items="${room.describe}" var="desc">
														<span>${desc.level.level }${desc.local.localcontent }&nbsp;</span>
													</c:forEach></td>
												<td>便利设施：<c:forEach
														items="${room.facilities.roomEasy.easy }" var="easy">
														<span>${easy.facilities }</span>
													</c:forEach>
													<hr> 媒体科技：<c:forEach
														items="${room.facilities.roomMedia.media }" var="media">
														<span>${media.facilities }</span>
													</c:forEach>
												</td>
												<td><c:forEach
														items="${room.roomHotelLocals.hotelLocal }"
														var="hotellocal">
														<span>${hotellocal.local }</span>
													</c:forEach></td>
												<td>￥${room.price }</td>
												<td><c:forEach items="${room.images }" var="image">
														<a href="/hotelSystem/room/getIamges?oldimg=${image.id }">${image.oldimg }</a>
													</c:forEach></td>
												<td><a href="" data-toggle="modal" data-target="#denglu" id="delu">增加</a>
													<div class="modal fade" id="denglu">
														<div class="modal-dialog">
															<div class="modal-content">
																<div class="modal-header">
																	<button type="button" class="close"
																		data-dismiss="modal">
																		<span aria-hidden="true">&times;</span> <span
																			class="sr-only">Close</span>
																	</button>
																	<h4 class="modal-title">增加房间</h4>
																</div>
																<div class="modal-body">
																	<div class="biank">
																		<form method="post" action="" onsubmit="return false"
																			enctype="multipart/form-data" id="oForm" name="oForm">
																			<table>
																				<tr>
																					<td class="col-lg-2 col-md-2 col-sm-2 col-xs-2">房间号：</td>
																					<td class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
																						<input type="text" name="room" class="room">
																					</td>
																				</tr>
																				<tr>
																					<td class="col-lg-2 col-md-2 col-sm-2 col-xs-2">标题：</td>
																					<td class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
																						<select id="select1" name="level">
																							<c:forEach items="${ roomlevels}" var="levels">
																								<option value="${levels.id }">${levels.level }</option>
																							</c:forEach>
																					</select> <select id="select2" name="local">
																							<c:forEach items="${ locals}" var="locals">
																								<option value="${locals.localid }">${locals.localcontent }</option>
																							</c:forEach>
																					</select>
																					</td>
																				</tr>
																				<tr>
																					<td class="col-lg-2 col-md-2 col-sm-2 col-xs-2">级别：</td>
																					<td class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
																						<select id="select3" name="level">
																							<c:forEach items="${ roomlevels}" var="levels">
																								<option value="${levels.id }">${levels.level }</option>
																							</c:forEach>
																					</select>
																					</td>
																				</tr>
																				<tr>
																					<td class="col-lg-2 col-md-2 col-sm-2 col-xs-2">窗类型：</td>
																					<td class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
																						<label for="r1"><input type="radio"
																							value="0" name="window" checked="checked">有窗</label>
																						<label for="r2"><input type="radio"
																							value="1" name="window">无窗</label>
																					</td>
																				</tr>
																				<tr>
																					<td class="col-lg-2 col-md-2 col-sm-2 col-xs-2">床类型：</td>
																					<td class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
																						<select id="select4" name="bed">
																							<c:forEach items="${beds }" var="beds">
																								<option value="${beds.id }">${beds.number }张${beds.width }m${beds.bed }</option>
																							</c:forEach>
																					</select>
																					</td>
																				</tr>
																				<tr>
																					<td class="col-lg-2 col-md-2 col-sm-2 col-xs-2">面积：</td>
																					<td class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
																						<input type="text" name="area" class="area"
																						min="10" max="160"><span>㎡</span>
																					</td>
																				</tr>
																				<tr>
																					<td class="col-lg-2 col-md-2 col-sm-2 col-xs-2">房间设施：</td>
																					<td class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
																						便利设施： <c:forEach items="${easy }" var="easy">
																							<input type="checkbox" id="check1" name="easy"
																								value="${easy.id }">${easy.facilities }
                                                   					</c:forEach>
																						<hr> 媒体科技： <c:forEach items="${medias }"
																							var="media">
																							<input type="checkbox" id="check2" name="medias"
																								value="${media.id }">${media.facilities }
                                                    				</c:forEach>
																					</td>
																				</tr>
																				<tr>
																					<td class="col-lg-2 col-md-2 col-sm-2 col-xs-2">房间标签：</td>
																					<td class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
																						<c:forEach items="${hotelLocal }" var="hotelLocal">
																							<input type="checkbox" id="check3"
																								name="hotellocal" value="${hotelLocal.id }">${hotelLocal.local }
                                                    				</c:forEach>
																					</td>
																				</tr>
																				<tr>
																					<td class="col-lg-2 col-md-2 col-sm-2 col-xs-2">价格：</td>
																					<td class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
																						<input type="text" name="price" class="price"
																						min="0" max="998"><span>¥</span>
																					</td>
																				</tr>
																				<tr>
																					<td class="col-lg-2 col-md-2 col-sm-2 col-xs-2">上传封面：</td>
																					<td class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
																						<div class="form-group" id="upload">
																							<input id="myFile" name="myFile" type="file"
																								multiple data-show-caption="true"
																								data-show-upload="false">
																						</div>
																					</td>
																				</tr>
																				<tr>
																					<td><input type="submit" value="提交"
																						id="button" class="btn btn-primary"></td>
																				</tr>
																			</table>
																		</form>
																	</div>
																</div>
															</div>
														</div>
													</div> <a href="">修改</a> <a href="">删除</a></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</ul>
				</div>

			</div>


		</div>
	</div>
</body>
</html>