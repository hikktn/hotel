/**
 * 设施和标签管理
 */
$(function () {
	//引入封装js库
	new_element=document.createElement("script");
	new_element.setAttribute("type","text/javascript");
	new_element.setAttribute("src","../js/bedOrWindow.js");// 在这里引入了a.js
	document.body.appendChild(new_element);
	
	//增加房间标签
	$("#addHotelLocal").on('click',function(){
		var title="增加房间标签";
		var submitstr="增加";
		var id="";
		var width="300px";
		var height="170px";
		var content='<div>'+
		'<label">房间标签：</label>'+
		'<input class="form-control" id="hotellocaldtypeInput" type="text" value="" placeholder="请输入房间标签">'+
		'</div>';
		click(title,submitstr,id,width,height,content);
	});
	
	//增加便利设施标签
	$("#addEasy").on('click',function(){
		var title="增加便利设施标签";
		var submitstr="增加";
		var id="";
		var width="300px";
		var height="170px";
		var content='<div>'+
		'<label">便利设施标签：</label>'+
		'<input class="form-control" id="easytypeInput" type="text" value="" placeholder="请输入便利设施标签">'+
		'</div>';
		click(title,submitstr,id,width,height,content);
	});
	
	//增加媒体科技标签
	$("#addMedia").on('click',function(){
		var title="增加媒体科技标签";
		var submitstr="增加";
		var id="";
		var width="300px";
		var height="170px";
		var content='<div>'+
		'<label">媒体科技标签：</label>'+
		'<input class="form-control" id="mediadtypeInput" type="text" value="" placeholder="请输入媒体科技标签">'+
		'</div>';
		click(title,submitstr,id,width,height,content);
	});
	
	//修改房间标签
	$(".myhotellocal").each(function() {
		//从0开始索引
		var temp=$(this).children().eq(2);
		var btn=temp.children();
		btn.bind("click",function(){
			var id=btn.parent().parent().children("td").get(0).innerHTML;
			var hotellocal=btn.parent().parent().children("td").get(1).innerHTML;
//			console.log(id+","+window);
			var title="修改房间标签";
			var submitstr="修改";
			var width="300px";
			var height="170px";
			var content='<div>'+
			'<label">房间标签：</label>'+
			'<input class="form-control" id="hotellocaldtypeInput" type="text" value="'+hotellocal+'" placeholder="请输入窗类型">'+
			'</div>';
			click(title,submitstr,id,width,height,content);
		});
	});
	
	//修改便利设施标签
	$(".myeasy").each(function() {
		//从0开始索引
		var temp=$(this).children().eq(2);
		var btn=temp.children();
		btn.bind("click",function(){
			var id=btn.parent().parent().children("td").get(0).innerHTML;
			var easy=btn.parent().parent().children("td").get(1).innerHTML;
//			console.log(id+","+window);
			var title="修改便利设施标签";
			var submitstr="修改";
			var width="300px";
			var height="170px";
			var content='<div>'+
			'<label">便利设施标签：</label>'+
			'<input class="form-control" id="easytypeInput" type="text" value="'+easy+'" placeholder="请输入窗类型">'+
			'</div>';
			click(title,submitstr,id,width,height,content);
		});
	});
	
	//修改媒体科技标签
	$(".mymedia").each(function() {
		//从0开始索引
		var temp=$(this).children().eq(2);
		var btn=temp.children();
		btn.bind("click",function(){
			var id=btn.parent().parent().children("td").get(0).innerHTML;
			var media=btn.parent().parent().children("td").get(1).innerHTML;
//			console.log(id+","+window);
			var title="修改媒体科技标签";
			var submitstr="修改";
			var width="300px";
			var height="170px";
			var content='<div>'+
			'<label">媒体科技标签：</label>'+
			'<input class="form-control" id="mediadtypeInput" type="text" value="'+media+'" placeholder="请输入窗类型">'+
			'</div>';
			click(title,submitstr,id,width,height,content);
		});
	});
	
});
