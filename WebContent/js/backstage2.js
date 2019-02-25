/**
 * 后台管理
 */
var picture_size;
var filedname;
var fileCount;
var i=0;
var file=new Array();
var FileInput = function () {
	var oFile = new Object();
	
	//初始化fileinput控件（第一次初始化）
	oFile.Init = function (ctrlName, uploadUrl) {
		var control = $('#' + ctrlName);
		//初始化上传控件的样式
		control.fileinput({
			language: 'zh', //设置语言
			uploadUrl: uploadUrl, //上传的地址
			allowedFileExtensions: ['jpg', 'gif', 'png','jpeg','bmp'],//接收的文件后缀
			//showUploadedThumbs:false,
			// uploadClass: 'hidden',
			uploadLabel: "上传",//设置上传按钮的汉字
			initialCaption: "请上传商家logo",//文本框初始话value
//			initialPreview:[ '<img src='/hotelSystem\files/' class='file-preview-image' alt='Desert' title='Desert'>',],预览图片
			showUpload: false, //是否显示上传按钮
			showCaption: true,//是否显示标题
			browseClass: "btn btn-info", //按钮样式
			dropZoneEnabled: false,//是否显示拖拽区域
			showRemove: false,//是否显示移除
			//minImageWidth: 150, //图片的最小宽度
			//minImageHeight: 150,//图片的最小高度
			//maxImageWidth: 150,//图片的最大宽度
			//maxImageHeight: 150,//图片的最大高度
			maxFileSize: 2048*4,//单位为kb，如果为0表示不限制文件大小
			maxFileCount: 5, //表示允许同时上传的最大文件个数
			minFileCount: 0,
			enctype: 'multipart/form-data',
			validateInitialCount: true,//有效初始化计数
			previewFileIcon: "<i class='glyphicon glyphicon-king'></i>",
			msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}！",
			fileActionSettings : {
                showUpload: false,
               //owRemove: false
            },
			//将文件名中间的-替换成_  回调函数
			slugCallback : function(filename) {
				return filename.replace('(', '_').replace(']', '_');
			}
            //File对象--files
		}).on("filebatchselected", function(event, files) {
			//将选中的文件加入
			//console.log("files:"+typeof(files[0]));
			picture_size = files.length;
			fileCount = $('#myFile').fileinput('getFilesCount');
			//对每个新的对象重新创建一个对象存放
			if(fileCount>0){
				file[parseInt(fileCount-1)]=$("#myFile")[0].files[0];
			}
		    //将多个file放入list
			//console.log("file:"+file.length);
			//name ---value
			//console.log($('#myFile')[0].files[0]);
			//console.log($('#myFile')[0].files);
		  //  console.log("picture_size:"+picture_size);
		    //将上传的文件对象传给全局变量，用以处理为字符串
		    filedname=files;
		    $(".kv-file-content").mouseenter(function() {
		    	$(this).find("img").css('opacity','0.5').show();
		    	$(this).append('<span id="parallelogram">设为封面</span>');
			});
		    $(".kv-file-content").mouseleave(function() {
				$(this).find("img").css('opacity','1');
				$("#parallelogram").remove();
			});
		    $(".kv-file-content").click(function() {
		    	if(!$(".file-preview-thumbnails").hasClass(".heart")){
		    		//删除其他的兄弟样式
		    		$(".file-preview-thumbnails").find(".heart").remove();
		    		$(this).append('<span class="heart"></span>');
		    	}
		    	return;
			});
		}).on("fileuploaded", function (event, data, previewId, index) {
			//导入文件上传完成之后的事件
			//对文件的删除事件
		    var datas = data.response;
		}).fileinput("enable");//enable作用：destroy并重新初始化fileinput插件后，插件会处于disable状态
	}
	return oFile;
};


$(function () {
    //0.初始化fileinput
    var oFileInput = new FileInput();
    //这里的后台连接被拦截，只用通过点击事件，才能跳转
    oFileInput.Init("myFile", "/hotelSystem/rooms/addRoom");
    checkid();
    $("#button").click(function(){
    	doUpload();
    });
});
function doUpload() { 
	//验证房间号是否相同或增加信息是否为空
	if(checkRoom($(".room"))&&checkPrice($(".price"))&&checkArea($(".area"))&&checkImage($(".file-preview-thumbnails"))){
		 //图片验证
		var formData = new FormData(); 
		//判断有几个文件
		var filename="";
		//拼接字符串
		for(i=parseInt(fileCount)-1;i>-1;i--){
			filename+=filedname[i].name+",";
		}
//		console.log(picture_size-1);
		//将最后的拼接符去掉
		filename=filename.substring(0,filename.lastIndexOf(","));
		//查找封面标记，如果没有，默认第一张
		if($(".heart").length>0){
			//将封面传给后台
			var arr=filename.split(",");
			//多次增加图片，是先进先出，所以必须调换顺序
			arr.sort();
			//获取选中的图片属性title
//			console.log($(".heart").prev("img").attr("title"));
			var title=$(".heart").prev("img").attr("title");
			for(var i=0;i<arr.length;i++){
				if(arr[i]==title){
					formData.append('fileimage',arr[i]);
				}
			}
		}else{
			var arr=filename.split(",");
			arr.reverse();
			formData.append('fileimage',arr[0]);
		}
		//将前台取到的值全部发送给后台
		if(file.length>=2){
			for(var j=0;j<parseInt(picture_size);j++){
				formData.append('file',file[parseInt(j)]);
			}
		}else{
			for(var j=0;j<parseInt(picture_size);j++){
				formData.append('file', $("#myFile")[0].files[parseInt(j)]);  //添加图片信息的参数
			}
		}
		//formData.append('text1',$("input[name='text1'").val());//添加表单参数
		formData.append('filename',filename);
		//将表单的值序列化传给后台
		formData.append('oForm',$("#oForm").serialize());
		$.ajax({ 
			url: '/hotelSystem/rooms/addRoom', 
			type: 'POST', 
			data: formData, 
			async: true, 
			cache: false, //禁止缓存
			contentType: false, 
			processData: false, 
			success: function (XMLHttpRequest) { 
				//通过回调函数重定向
				if(XMLHttpRequest=="ok"){
					 window.location.href="http://localhost:8080/hotelSystem/admin/backstage3.jsp";
				}else if(XMLHttpRequest=="no"){
					$("#denglu").hide();
					$.MsgBox.Alert("消息", "添加失败！1秒跳转回主页！");
					 setTimeout(function () { 
					        window.location.href="http://localhost:8080/hotelSystem/admin/backstage3.jsp";
					 }, 1000);
				}
				console.log(XMLHttpRequest);
			}, 
			error: function (returndata) { 
				 $.MsgBox.Alert("消息", "添加失败！");
			} 
		}); 
	};
} 
function checkid(){
	  //房间号验证
    $(".room").blur(function(){
    	checkRoom($(this));
    });
    //面积验证
    $(".area").blur(function(){
    	checkArea($(this));
    });
    //价格验证
    $(".price").blur(function(){
    	checkPrice($(this));
    });
}
//验证表单提交
function checkRoom(room) {
	var roomId= room.val();
	var re = new RegExp(/^[0-9]*[1-9][0-9]*$/);
	if(roomId.length==0){
		room.siblings("span").remove();
		room.after('<span class="font">*请输入房间号</span>');
		$("#button").disabled=false;
		return false;
	}else if(isNaN(roomId)){
		room.siblings("span").remove();
		room.after('<span class="font">*请输入数字</span>');
		$("#button").disabled=false;
		return false;
	}else if(!re.test(roomId)){
		room.siblings("span").remove();
		room.after('<span class="font">*请输入整数</span>');
		$("#button").disabled=false;
		return false;
	}else{
		room.siblings("span").remove();
		//验证数据库是否有房间号
		$.ajax({ 
		     url: '/hotelSystem/rooms/checkRoomId?roomid='+roomId, 
		     type: 'POST', 
		     async: true, //异步
		     data:"",
		     cache: false, //禁止缓存
		     contentType: false, 
		     processData: false, 
		     success: function (data) { 
		    	//上传成功后，执行验证
		    	if(data=="success"){
		    		$(".room").siblings("span").remove();
		    		$("#button").disabled=true;
		    		return true;
		    	}else if(data=="error"){
		    		$(".room").siblings("span").remove();
		    		$(".room").after('<span class="font">*房间名已被注册</span>');
		    		$("#button").disabled=false;
		    		return false; 
		    	}
		     }, 
		     error: function (data) { 
		    	
		     } 
		}); 
		return true;
	}
}
function checkPrice(roomprice) {
	var price= roomprice.val();
	var re = new RegExp(/^[0-9]*[1-9][0-9]*$/);
	if(price.length==0){
		roomprice.next().siblings("span").remove();
		roomprice.next().after('<span class="font">*请输入价格</span>');
		$("#button").disabled=false;
		return false;
	}else if(isNaN(price)){
		roomprice.next().siblings("span").remove();
		roomprice.next().after('<span class="font">*请输入数字</span>');
		$("#button").disabled=false;
		return false;
	}else if(!re.test(price)){
		roomprice.next().siblings("span").remove();
		roomprice.next().after('<span class="font">*请输入整数</span>');
		$("#button").disabled=false;
		return false;
	}else if(Number(price)<0||Number(price)>30000){
		roomprice.next().siblings("span").remove();
		roomprice.next().after('<span class="font">*价格请在0~30000元间</span>');
		$("#button").disabled=false;
		return false;
	}else{
		roomprice.next().siblings("span").remove();
		$("#button").disabled=true;
		return true;
	}
}
function checkArea(roomarea) {
	var area=roomarea.val();
	var re = new RegExp(/^[0-9]*[1-9][0-9]*$/);
	if(area.length==0){
		roomarea.next().siblings("span").remove();
		roomarea.next().after('<span class="font">*请输入面积</span>');
		$("#button").disabled=false;
		return false;
	}else if(isNaN(area)){
		roomarea.next().siblings("span").remove();
		roomarea.next().after('<span class="font">*请输入数字</span>');
		$("#button").disabled=false;
		return false;
	}else if(!re.test(area)){
		roomarea.next().siblings("span").remove();
		roomarea.next().after('<span class="font">*请输入整数</span>');
		$("#button").disabled=false;
		return false;
	}else if(Number(area)<10||Number(area)>160){
		roomarea.next().siblings("span").remove();
		roomarea.next().after('<span class="font">*面积请在10~160区间</span>');
		$("#button").disabled=false;
		return false;
	}else{
		roomarea.next().siblings("span").remove();
		$("#button").disabled=true;
		return true;
	}
}
function checkImage(finds) {
	if(finds.find("img").length<1){
		console.log($("#upload"));
		$("#upload").next("span").remove();
		$("#upload").append('<span class="font">*图片至少一张</span>');
		return false;
	}else{
		$("#upload").next("span").remove();
		return true;
	}
}
//搜索框
//回车事件
$(".search").keypress(function (e) {
	 var keyCode = e.keyCode ? e.keyCode : e.which ? e.which : e.charCode;
	 if (keyCode == 13){
		 var result=$("#search_kw").val();
		 stripscript(result);
		 search(result);		
	 }
});
//点击查询按钮事件
$("#mark").click(function() {
	var result=$("#search_kw").val();
	stripscript(result);
	search(result);
});
//替换特殊字符
function stripscript(s) 
{ 
    var pattern = new RegExp("[`~!@#$^&*()=|{}':;',\\[\\].<>/?~！@#￥……&*（）——|{}【】‘；：”“'。，、？]") 
    var rs = ""; 
    for (var i = 0; i < s.length; i++) { 
        rs = rs+s.substr(i, 1).replace(pattern, ''); 
    } 
    return rs; 
}
function search(data){
	$.ajax({ 
	     url: '/hotelSystem/rooms/checkRoomData?data='+data+'&temp='+new Date(), 
	     type: 'POST', 
	     async: false, //同步
	     data:"text",
	     contentType: "application/x-www-form-urlencoded; charset=utf-8",
	     cache: false, //禁止缓存
	     contentType: false, 
	     processData: false, 
	     success: function (returndata) { 
	    	//上传成功后，执行验证
	    	 if(returndata=="null"){
	    		$(".panel-body").remove();
	    		$("#query").append('<span class="roomfont">房间好像走丢了！</span>');
	    	}else{
	    		$(".list-group").remove();
	    		$(".mainbox").append(returndata);
	    	}
	    	console.log(returndata);
	     }, 
	     error: function (data) { 
	    	
	     } 
	}); 
}
//删除选中行元素
$(".mytable").each(function() {
	var temp=$(this).children().eq(10);
	var btn=temp.children();
	btn.bind("click",function(){
		var roomid=btn.parent().parent().children("td").get(0).innerHTML;
		var index=btn.parent().parent().index();
		var msg = "您真的确定要删除吗？\n\n请确认！"; 
		if (confirm(msg)==true){ 
			 $.ajax({
				 type: "post",
				 url: "/hotelSystem/rooms/deleteRoom?id="+roomid,
				 data: "",
				 success: function (status) {
					 console.log(status);
					 if (status == "success") {
						 $(".table tr").eq(index+1).remove();
					 }
				 },
				 error: function () {
					 
				 },
				 complete: function () {
					 
				 }
			 });
		  return true; 
		 }else{ 
			 return false;
		 } 
	});
});
//点击表格变色
function selectRow(obj){
	var row;
	$(".table tr").css("background","#FFF");
	if(event.srcElement.tagName=="TD"){
		curRow=event.srcElement.parentElement;
		curRow.style.background="#F0F0F0";
		row=curRow.rowIndex+1;
	}
	
}
//增加窗

//增加床
//关闭弹出框，清空数据
$("").click(function() {
	$(".room").val("").focus();
	$("#select1").find("option").eq(0).prop("selected",true);
	$("#select2").find("option").eq(0).prop("selected",true);
	$("#select3").find("option").eq(0).prop("selected",true);
	$('input:radio:first').attr('checked', 'checked');
	$("#select4").find("option").eq(0).prop("selected",true);
	$(".area").val("").focus();
	$('#check1').attr('checked',false);
	$('#check2').attr('checked',false);
	$('#check3').attr('checked',false);
	$(".price").val("").focus();
	//移除图片元素
//	$(".file-preview-thumbnails")
});
//.close
(function() {
    $.MsgBox = {
        Alert: function(title, msg) {
            GenerateHtml("alert", title, msg);
            btnOk(); //alert只是弹出消息，因此没必要用到回调函数callback
            btnNo();
        },
        Confirm: function(title, msg, callback) {
            GenerateHtml("confirm", title, msg);
            btnOk(callback);
            btnNo();
        }
    }
    //生成Html
    var GenerateHtml = function(type, title, msg) {
        var _html = "";
        _html += '<div id="mb_box"></div><div id="mb_con"><span id="mb_tit">' + title + '</span>';
        _html += '<a id="mb_ico">x</a><div id="mb_msg">' + msg + '</div><div id="mb_btnbox">';
        if (type == "alert") {
            _html += '<input id="mb_btn_ok" type="button" value="确定" />';
        }
        if (type == "confirm") {
            _html += '<input id="mb_btn_ok" type="button" value="确定" />';
            _html += '<input id="mb_btn_no" type="button" value="取消" />';
        }
        _html += '</div></div>';
        //必须先将_html添加到body，再设置Css样式
        $("body").append(_html);
        //生成Css
        GenerateCss();
    }

    //生成Css
    var GenerateCss = function() {
        $("#mb_box").css({
            width: '100%',
            height: '100%',
            zIndex: '99999',
            position: 'fixed',
            filter: 'Alpha(opacity=60)',
            backgroundColor: 'black',
            top: '0',
            left: '0',
            opacity: '0.6'
        });
        $("#mb_con").css({
            zIndex: '999999',
            width: '400px',
            position: 'fixed',
            backgroundColor: 'White',
            borderRadius: '15px'
        });
        $("#mb_tit").css({
            display: 'block',
            fontSize: '14px',
            color: '#444',
            padding: '10px 15px',
            backgroundColor: '#DDD',
            borderRadius: '15px 15px 0 0',
            borderBottom: '3px solid #009BFE',
            fontWeight: 'bold'
        });
        $("#mb_msg").css({
            padding: '20px',
            lineHeight: '20px',
            borderBottom: '1px dashed #DDD',
            fontSize: '13px'
        });
        $("#mb_ico").css({
            display: 'block',
            position: 'absolute',
            right: '10px',
            top: '9px',
            border: '1px solid Gray',
            width: '18px',
            height: '18px',
            textAlign: 'center',
            lineHeight: '16px',
            cursor: 'pointer',
            borderRadius: '12px',
            fontFamily: '微软雅黑'
        });
        $("#mb_btnbox").css({
            margin: '15px 0 10px 0',
            textAlign: 'center'
        });
        $("#mb_btn_ok,#mb_btn_no").css({
            width: '85px',
            height: '30px',
            color: 'white',
            border: 'none'
        });
        $("#mb_btn_ok").css({
            backgroundColor: '#168bbb'
        });
        $("#mb_btn_no").css({
            backgroundColor: 'gray',
            marginLeft: '20px'
        });
        //右上角关闭按钮hover样式
        $("#mb_ico").hover(function() {
            $(this).css({
                backgroundColor: 'Red',
                color: 'White'
            });
        }, function() {
            $(this).css({
                backgroundColor: '#DDD',
                color: 'black'
            });
        });
        var _widht = document.documentElement.clientWidth; //屏幕宽
        var _height = document.documentElement.clientHeight; //屏幕高
        var boxWidth = $("#mb_con").width();
        var boxHeight = $("#mb_con").height();
        //让提示框居中
        $("#mb_con").css({
            top: (_height - boxHeight) / 2 + "px",
            left: (_widht - boxWidth) / 2 + "px"
        });
    }
    //确定按钮事件
    var btnOk = function(callback) {
        $("#mb_btn_ok").click(function() {
            $("#mb_box,#mb_con").remove();
            if (typeof(callback) == 'function') {
                callback();
            }
        });
    }
    //取消按钮事件
    var btnNo = function() {
        $("#mb_btn_no,#mb_ico").click(function() {
            $("#mb_box,#mb_con").remove();
        });
    }
})();