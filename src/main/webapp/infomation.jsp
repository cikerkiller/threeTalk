<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript"
	src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
<!-- <script type="text/javascript" src="http://localhost:8080/threeTalk/js/sockjs.js"></script> -->
<script type="text/javascript">

var wsServer = null;
var ws = null;
wsServer = "ws://" + location.host+"${pageContext.request.contextPath}"+ "/talkServer";
/* wsServer = "ws://" + location.host+"${pageContext.request.contextPath}" + "/talkServer"; */
ws = new WebSocket(wsServer); //创建WebSocket对象
ws.onopen = function (evt) {
	alert("已经建立连接");
};
ws.onmessage = function (evt) {
    analysisMessage(evt.data);  //解析后台传回的消息,并予以展示
};
ws.onerror = function (evt) {
	alert("产生异常");
};
ws.onclose = function (evt) {
	alert("已经关闭连接");
};

/**
 * 连接
 */
function getConnection(){
    if(ws == null){
        ws = new WebSocket(wsServer); //创建WebSocket对象
        ws.onopen = function (evt) {
        	alert("成功建立连接!");
        };
        ws.onmessage = function (evt) {
            analysisMessage(evt.data);  //解析后台传回的消息,并予以展示
        };
        ws.onerror = function (evt) {
        	alert("产生异常");
        };
        ws.onclose = function (evt) {
        	alert("已经关闭连接");
        };
    }else{
    	alert("连接已存在!");
    }
}

/**
 * 发送信息给后台
 */
function sendMessage(){
    if(ws == null){
    	alert("连接未开启!");
        return;
    }
    var message = $("#message").val();
    var to = $("#sendto").text() == "全体成员"? "": $("#sendto").text();
    if(message == null || message == ""){
    	alert("请不要惜字如金!");
        return;
    }
    ws.send(JSON.stringify({
        message : {
            content : message,
            from : '${currentUser.username}',
            to : to,      //接收人,如果没有则置空,如果有多个接收人则用,分隔
            time : new Date()
        },
        type : "message"
    }));
}
/**
 * 添加接收人
 */
function addChat(user){
    var sendto = $("#sendto");
    var receive = sendto.text() == "全体成员" ? "" : sendto.text() + ",";
    if(receive.indexOf(user) == -1){    //排除重复
        sendto.text(receive + user);
    }
}

/**
 * 解析后台消息
 */
function analysisMessage(message){
    message = JSON.parse(message);
    if(message.type == "message"){      //会话消息
        //showChat(message.message);
    	alert(message.message.content);
    }
    if(message.type == "notice"){       //提示消息
    	alert(message.message);
        //showNotice(message.message);
    }
    if(message.list != null && message.list != undefined){      //在线列表
        showOnline(message.list);
    }
}

/**
 * 展示在线列表
 */
function showOnline(list){
    $("#list").html("");    //清空在线列表
    $.each(list, function(index, item){     //添加私聊按钮
        var li = "<tr><td>"+item+"</td></tr>";
        if('${currentUser.username}' != item){    //排除自己
            li = "<tr><td>"+item+" <button type=\"button\" class=\"am-btn am-btn-xs am-btn-primary am-round\" onclick=\"addChat('"+item+"');\"><span class=\"am-icon-phone\"><span> 私聊</button></td></tr>";
        }
        $("#list").append(li);
    });
    $("#onlinenum").text($("#list tr").length);     //获取在线人数
}

function logout(){
	$.ajax({
		url : "/threeTalk/user/logout.do",
		type : "GET",
		success : function(e) {
			alert("message: " + e.status);
			if(e.status==0){
				window.location.href="./index.jsp";
			}
		}
	});
}
</script>
<body>
		<textarea rows="4" cols="6" id="message"></textarea>
		<button onclick="getConnection()" name="connection" value="连接">连接</button>

		
		<button onclick="sendMessage()" name="send" value="发送">发送</button>
		<table id="list">
			
		</table>
		<p id="onlinenum"></p>
		<p class="am-kai">发送给 : <span id="sendto">全体成员</span>
				<button onclick="logout()" name="logout" value="退出">退出</button>
</body>
</html>