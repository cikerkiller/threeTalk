<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="https://cdn.bootcss.com/jquery/2.2.2/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#submit").click(function(){
			var username=$("#username").val();
			if(username==null||username==""){
				$("#nameErr").text("用户名不能为空");
			}
			var password=$("#password").val();
			if(password==null||password==""){
				$("#passErr").text("密码不能为空");
			}
			
			$.ajax({
				url:"/threeTalk/user/login.do",
				type:"POST",
				data:{"username":username,"password":password},
				success:function(msg){
					var status=msg.status;
					if(status==0){
						window.location.href="./main.jsp";
					}else{
						var msg=msg.msg;
						$("#resErr").text(msg);
					}
				},
				error:function(err){
					alert("err:"+err);
				}
			});
			
		});
		
	});

</script>
<body>
	<div>
		<p id="resErr" class="p"><p>
		<div class="sub">
			<input id="username" type="text"/><p id="nameErr" class="p"><p>
		</div>
		<div class="sub">
			<input id="password" type="password"/><p id="passErr"  class="p"><p>
		</div>
		<div class="sub">
			<input id="submit" type="submit" />
		</div>
	</div>
</body>
</html>