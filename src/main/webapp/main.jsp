<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://cdn.bootcss.com/jquery/2.2.2/jquery.min.js"></script>
 <spring:url value="https://cdn.jsdelivr.net/sockjs/1/sockjs.min.js" var="sockJs"/>  
    <script src="${sockJs}"></script>  
 <spring:url value="https://cdn.bootcss.com/stomp.js/2.2.0/stomp.min.js" var="stompjs"/>  
    <script src="${stompjs}"></script>  
    
    
    <style type="text/css">
    body{
    	margin: 0;
    	padding: 0
    }
    .main{
    	
    }
    
    </style>
</head>
 <script type="text/javascript">
 	var username="";
 	var userId="";
 	var url='http://'+window.location.host+'/threeTalk/marcopilo';
 	var stomp =null;
	$(function(){
		queryUserInfo();
		
		$("#send").click(function(){
			var msg=$(".textarea").val();
			var receiverId=$("#otherUser").val();
			if(receiverId==username){
				alert("不要给自己发消息");
				return ;
			}
			var message={
		 			senderId 	:	username,

		 		   	receiverId 	: 	receiverId,

		 		    content 	: 	msg,

		 		    type 		: 	'1'	
		 	}
			sendMessage(message);
		});
		$("#reset").click(function(){
			$(".textarea").val("");
		});
		
	});	
 	
	function queryUserInfo(){
		$.ajax({
			url:"/threeTalk/user/get_userinfo",
			type:"GET",
			data:{},
			success:function(data){
				var status=data.status;
				if(status==10){
					toLogin();
				}else{
					var user=data.data;
					username=user.username;
					userId=user.id;
					$("#user").text("自己："+username);
					stompConnect();
				}
			}
		});
	}
	
	function stompConnect(){
		var sock=new SockJS(url);
		stomp =Stomp.over(sock);
		stomp.connect({},function(frame){
			subscribeMsg();
	 	});
	}
	
	function sendMessage(msg){
		msg=JSON.stringify(msg);
		stomp.send('/app/simple_send',{},msg);
		msg=eval("("+msg+")");
		$("#otherContent").append(username+":"+msg.content+"<br/>");
	}
	
	function subscribeMsg(){
		stomp.subscribe('/user/' + username + '/simple_send', function(message){  
			var body=message.body;
			body=eval("("+body+")")
			if(body!=2){
				$("#otherUser").val(body.senderId);
				$("#otherContent").append(body.senderId+":"+body.content+"<br/>");
			}
 	    });  
	}
	
	
	
 
 	function toLogin(){
 		window.loaction.href="./login.jsp";
 	}
 </script>
<body>
<div class="top"></div>
<div class="main">
	<input type="hidden" class="name" >
	<div class="left">
	
	</div>
	<div class="right">
		<div class="right_top">
			<div class="other" >
				发送给：<input type="text" id="otherUser" />
				
				<p id="otherContent">内容：<br/></p>
			</div>
			<div class="owner">
			<p id="user" ><p/></div>
		</div>
		<div class="right_down">
			<textarea class="textarea"></textarea>
			<input type="button" class="but" id="reset" value="清空"/>
			<input type="button" class="but" id="send" value="发送"/>
		</div>
		
		
	</div>
</div>

<div class="down"></div>

</body>
</html>