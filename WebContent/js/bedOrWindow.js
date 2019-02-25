/**
 * 弹出增加或修改框
 */
$(function () {
	//增加窗户类型
	$("#addWind").on('click',function() {
		var title="增加窗户类型";
		var submitstr="增加";
		var id="";
		var temp="";
		var width="300px";
		var height="170px";
		var content='<div>'+
		'<label">窗户类型：</label>'+
		'<input class="form-control" name="windName" id="windtypeInput" type="text" value="'+temp+'" placeholder="请输入窗类型">'+
		'</div>';
		click(title,submitstr,id,width,height,content);
	});
	//增加床类型
	$("#addBed").on('click',function(){
		var title="增加床类型";
		var submitstr="增加";
		var id="";
		var width="300px";
		var height="300px";
		var content='<div>'+
	          '<div>'+
			    '<label class="control-label">床数量:</label>'+
			    '<input class="form-control" name="run" id="bedRunInput" type="text" value="" placeholder="请输入床数量">'+
			  '</div>'+
			  '<div>'+
			   ' <label class="control-label">床宽度:</label>'+
			   ' <input class="form-control" name="windth" id="bedWidthInput" type="text" value="" placeholder="请输入床宽度">'+
			 ' </div>'+
			  '<div>'+
			   ' <label class="control-label">床类型:</label>'+
			   ' <input class="form-control" name="bedname" id="bedNameInput" type="text" value="" placeholder="请输入床类型">'+
			    '  </div>'+
			 ' </div>';
		click(title,submitstr,id,width,height,content);
	});
});
//修改窗户类型
$(".mywindow").each(function() {
	//从0开始索引
	var temp=$(this).children().eq(2);
	var btn=temp.children();
	btn.bind("click",function(){
		var id=btn.parent().parent().children("td").get(0).innerHTML;
		var window=btn.parent().parent().children("td").get(1).innerHTML;
		var index=btn.parent().parent().index();
//		console.log(id+","+window);
		var title="修改窗户类型";
		var submitstr="修改";
		var width="300px";
		var height="170px";
		var content='<div>'+
		'<label">窗户类型：</label>'+
		'<input class="form-control" name="windName" id="windtypeInput" type="text" value="'+window+'" placeholder="请输入窗类型">'+
		'</div>';
		click(title,submitstr,id,width,height,content);
	});
});
//修改床类型
$(".mybed").each(function() {
	var temp=$(this).children().eq(4);
	var btn=temp.children();
	btn.bind("click",function(){
		var id=btn.parent().parent().children("td").get(0).innerHTML;
		var bedNum=btn.parent().parent().children("td").get(1).innerHTML;
		var bedWidth=btn.parent().parent().children("td").get(2).innerHTML;
		var bedName=btn.parent().parent().children("td").get(3).innerHTML;
		var title="修改窗户类型";
		var submitstr="修改";
		var width="300px";
		var height="300px";
		var content='<div>'+
		        '<div>'+
			    '<label class="control-label">床数量:</label>'+
			    '<input class="form-control" name="run" id="bedRunInput" type="text" value="'+bedNum+'" placeholder="请输入床数量">'+
			  '</div>'+
			  '<div>'+
			   ' <label class="control-label">床宽度:</label>'+
			   ' <input class="form-control" name="windth" id="bedWidthInput" type="text" value="'+bedWidth+'" placeholder="请输入床宽度">'+
			 ' </div>'+
			  '<div>'+
			   ' <label class="control-label">床类型:</label>'+
			   ' <input class="form-control" name="bedname" id="bedNameInput" type="text" value="'+bedName+'" placeholder="请输入床类型">'+
			    '  </div>'+
			 ' </div>';
		click(title,submitstr,id,width,height,content);
	});
});
//title：标题，submitstr：按钮文本，id：序号，temp:文本框的内容，width：宽度，height：高度，content：html代码
function click(title,submitstr,id,width,height,content) {
	var index =layer.open({
		type:1,
		area:[width,height],
		maxmin: false, //开启最大化最小化按钮
		scrollbar: false, //屏蔽浏览器滚动条
		content:content,
		title:title,
		btn:[submitstr,'返回'],
		btnAlign: 'c',
		yes:function(index,layero){
			//根据标题判断什么类型
			if(title.lastIndexOf('窗户类型')>0){
				windows(id);
			}else if(title.lastIndexOf('床类型')>0){
				beds(id);
			}else if(title.lastIndexOf('房间标签')>0){
				hotellocals(id);
			}else if(title.lastIndexOf('便利设施标签')>0){
				easys(id);
			}else if(title.lastIndexOf('媒体科技标签')>0){
				medias(id);
			}
		},
		btn2:function(){}
	});
}
function windows(id){
	var window= $("#windtypeInput");
	var result=window.val();
	var text="窗户类型";
	var url='/hotelSystem/rooms/checkbedorwindow?result='+result;
	//验证窗户类型是否存在，验证输入是否正确,还有id如果有值，那么就是修改
	if(id==""){
		if(checkNULL(window,text)&&check(window,text,url,result)&&chcekNoNum(window)){
			//正确，添加进数据库中
			var url='/hotelSystem/rooms/addbedorwindow?result='+result;
			var msg='增加成功！';
			add(url,msg);
		} 
	}else{
		if(checkNULL(window,text)&&check(window,text,url,result)&&chcekNoNum(window)){
			var url='/hotelSystem/rooms/updatebedorwindow?id='+id+"&result="+result;
			var msg='修改成功！';
			add(url,msg);
		};
	}
}
function beds(id){
	var bedNum=$("#bedRunInput");
	var bedWidth=$("#bedWidthInput");
	var bedName=$("#bedNameInput");
	var text1="床类型";
	var bedNumStr=bedNum.val();
	var bedWidthStr=bedWidth.val();
	var bedNameStr=bedName.val();
	var result1=bedNumStr+","+bedWidthStr+","+bedNameStr;
	var url1='/hotelSystem/rooms/checkbedorwindow?result1='+result1;
	//验证床类型，0到10的数量，是否是数字
	if(id==""){
		if(checkNums(bedNum,text1,0,10)&&chcekNum(bedNum)&&checkNULL(bedNum,text1)
				&&checkNumSize(bedWidth)&&checkNums(bedWidth,text1,1,4)&&checkNULL(bedWidth,text1)
				&&chcekNoNum(bedName)&&checkNULL(bedName,text1)
				&&check(bedName,text1,url1,result1)){
			var url='/hotelSystem/rooms/addbedorwindow?bedNumStr='+bedNumStr+'&bedWidthStr='+bedWidthStr+'&bedNameStr='+bedNameStr;
			var msg='增加成功！';
			add(url,msg);
		}
	}else {
		if(checkNums(bedNum,text1,0,10)&&chcekNum(bedNum)&&checkNULL(bedNum,text1)
				&&checkNumSize(bedWidth)&&checkNums(bedWidth,text1,1,4)&&checkNULL(bedWidth,text1)
				&&chcekNoNum(bedName)&&checkNULL(bedName,text1)
				&&check(bedName,text1,url1,result1)){
			var url='/hotelSystem/rooms/updatebedorwindow?bedNumStr='+bedNumStr+'&bedWidthStr='+bedWidthStr+'&bedNameStr='+bedNameStr+'&bedid='+id;
			var msg='修改成功！';
			add(url,msg);
		}
	}
}
function hotellocals(id) {
	var hotellocal= $("#hotellocaldtypeInput");
	var result=hotellocal.val();
	var text="窗户类型";
	var url='/hotelSystem/rooms/checkfacilitiesorlocal?hotellocal='+result;
	//验证窗户类型是否存在，验证输入是否正确,还有id如果有值，那么就是修改
	if(id==""){
		if(checkNULL(hotellocal,text)&&check(hotellocal,text,url,result)&&chcekNoNum(hotellocal)){
			//正确，添加进数据库中
			var url='/hotelSystem/rooms/addfacilitiesorlocal?hotellocal='+result;
			var msg='增加成功！';
			add(url,msg);
		} 
	}else{
		if(checkNULL(hotellocal,text)&&check(hotellocal,text,url,result)&&chcekNoNum(hotellocal)){
			var url='/hotelSystem/rooms/updatefacilitiesorlocal?hotellocalid='+id+"&hotellocal="+result;
			var msg='修改成功！';
			add(url,msg);
		};
	}
}
function easys(id){
	var easy= $("#easytypeInput");
	var result=easy.val();
	var text="窗户类型";
	var url='/hotelSystem/rooms/checkfacilitiesorlocal?easy='+result;
	//验证窗户类型是否存在，验证输入是否正确,还有id如果有值，那么就是修改
	if(id==""){
		if(checkNULL(easy,text)&&check(easy,text,url,result)&&chcekNoNum(easy)){
			//正确，添加进数据库中
			var url='/hotelSystem/rooms/addfacilitiesorlocal?easy='+result;
			var msg='增加成功！';
			add(url,msg);
		} 
	}else{
		if(checkNULL(easy,text)&&check(easy,text,url,result)&&chcekNoNum(easy)){
			var url='/hotelSystem/rooms/updatefacilitiesorlocal?easyid='+id+"&easy="+result;
			var msg='修改成功！';
			add(url,msg);
		};
	}
}
function medias(id){
	var media= $("#mediadtypeInput");
	var result=media.val();
	var text="窗户类型";
	var url='/hotelSystem/rooms/checkfacilitiesorlocal?media='+result;
	//验证窗户类型是否存在，验证输入是否正确,还有id如果有值，那么就是修改
	if(id==""){
		if(checkNULL(media,text)&&check(media,text,url,result)&&chcekNoNum(media)){
			//正确，添加进数据库中
			var url='/hotelSystem/rooms/addfacilitiesorlocal?media='+result;
			var msg='增加成功！';
			add(url,msg);
		} 
	}else{
		if(checkNULL(media,text)&&check(media,text,url,result)&&chcekNoNum(media)){
			var url='/hotelSystem/rooms/updatefacilitiesorlocal?mediaid='+id+"&media="+result;
			var msg='修改成功！';
			add(url,msg);
		};
	}
}

//验证不是特殊字符和数字
function chcekNoNum(datas){
	var result=datas.val();
	if(!/^[\u4e00-\u9fa5]/.test(result)||!/^[a-zA-Z]/.test(result)){
		datas.parent().parent().siblings("span").remove();
		datas.parent().parent().after('<span class="font">*请输入文字</span>');
		return false;
	}else{
		datas.parent().parent().siblings("span").remove();
		return true;
	}
}
//验证必须是数字和正整数
function chcekNum(datas) {
	var result=datas.val();
	var re = new RegExp(/^[0-9]*[1-9][0-9]*$/);
	if(isNaN(result)&&!re.test(result)){
		datas.siblings("span").remove();
		datas.after('<span class="font">*请输入数字</span>');
		return false;
	}else{
		datas.siblings("span").remove();
		return true;
	}
}
//验证只能输入数字且小数点
function checkNumSize(e) { 
    var re = /^\d+(?=\.{0,1}\d+$|$)/ 
    if (e.value != "") { 
        if (re.test(e.value)) { 
        	e.siblings("span").remove();
    		e.after('<span class="font">*请输入数字</span>');
            e.value = ""; 
            e.focus(); 
            return false;
        } else{
        	e.siblings("span").remove();
        	return true;
        }
    } 
} 
//验证数字大小
function checkNums(datas,text,min,max){
	var result=datas.val();
	if(Number(result)<min||Number(result)>max){
		datas.siblings("span").remove();
		datas.after('<span class="font">'+text+'</span>');
		return false;
	}else{
		datas.siblings("span").remove();
		return true;
	}
}
//验证是否为空
function checkNULL(datas,text) {
	var result=datas.val();
	console.log(result);
	if(result.length<=0){
		datas.siblings("span").remove();
		datas.after('<span class="font">*请输入'+text+'</span>');
		return false;
	}else{
		datas.siblings("span").remove();
		return true;
	}
}
//datas：追加提示文本框的jquery对象,text:提示文本，url：后台验证的地址，e：文本框输入的值
function check(datas,text,url,e) {
	stripscript(e);
	//验证数据库是否有房间号
	$.ajax({ 
		url: url, 
		type: 'POST', 
		async: true, //异步
		data:"",
		cache: false, //禁止缓存
		contentType: false, 
		processData: false, 
		success: function (data) { 
			//上传成功后，执行验证
			if(data=="success"){
				datas.siblings("span").remove();
				return true;
			}else if(data=="error"){
				datas.siblings("span").remove();
				datas.after('<span class="font">*'+text+'已有，请重新输入！</span>');
				return false; 
			}
		}, 
		error: function (data) { 
			layer.msg('未知错误');
		} 
	}); 
}
//url:访问连接，msg：提示内容
function add(url,msg){
	$.ajax({ 
		url: url, 
		type: 'POST', 
		async: true, //异步
		data:"",
		cache: false, //禁止缓存
		contentType: false, 
		processData: false, 
		success: function (data) { 
			//上传成功后，执行验证
			if(data=="success"){
				layer.close(index);
				layer.msg(msg);
				setTimeout(function () { 
					window.location.href="http://localhost:8080/hotelSystem/admin/backstage3.jsp";
				}, 1000);
			}else if(data=="error"){
				var index = layer.open();
				layer.close(index);
				layer.msg('玩命卖萌中', function(){
					//关闭后的操作
				});
				return false; 
			}
		}, 
		error: function (data) { 
			layer.msg('添加失败', function(){
				//关闭后的操作
			});
		} 
	}); 
}
//替换特殊字符
function stripscript(s) 
{ 
    var pattern = new RegExp("[`~!@#$^&*()=|{}':;',\\[\\][-].<>/?~！@#￥……&*（）——|{}【】‘；：”“'。，、？]");
    var rs = ""; 
    for (var i = 0; i < s.length; i++) { 
        rs = rs+s.substr(i, 1).replace(pattern, ''); 
    } 
    return rs; 
}