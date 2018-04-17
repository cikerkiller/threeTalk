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

<script type="text/javascript">
	$(function() {
		$(".submit").click(function() {
			var username = $(".username").val();
			var password = $(".password").val();
			/* var valicode=$(".valicode").val(); */
			if (username == "") {
				alert("用户名不为空");
				return;
			}
			if (password == "") {
				alert("密码不为空");
				return;
			}
			/* if(valicode==""){
				alert("验证码不为空");
			} */
			$.ajax({
				url : "/threeTalk/user/login.do",
				type : "POST",
				dataType:"json",
				data : {
					"username" : username,
					"password" : password
				},
				success : function(e) {
					alert("message: " + e.status);
					if(e.status==0){
						window.location.href="./infomation.jsp";
					}
				}
			});
		});
	});
</script>


<body>
	<div class="loginbutton">
		<form id="form">
			<div>
				用户名：<input type="text" name="username" class="username" />
			</div>
			<div>
				密 码：<input type="password" name="password" class="password" />
			</div>
			<!-- <div>验证码：<input type="text" name="valicode" class="valicode" /><img alt="" src="data:image/gif;base64,"></div> -->
			<div>
				<input type="button" name="submit" class="submit" value="登录" />
			</div>
		</form>

	</div>


</body>
</html>
