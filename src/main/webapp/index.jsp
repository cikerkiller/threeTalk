<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <spring:url value="http://cdn.sockjs.org/sockjs-0.3.min.js" var="sockJs"/>  
    <script src="${sockJs}"></script>  
 <spring:url value="https://cdn.bootcss.com/stomp.js/2.2.0/stomp.min.js" var="stompjs"/>  
    <script src="${stompjs}"></script>  
</head>
<body>
 <script type="text/javascript">
 	var url='http://'+window.location.host+'/threeTalk/marcopilo';
 	var sock=new SockJS(url);
 	var stomp =Stomp.over(sock);
 	var payload=JSON.stringify({
 		'message':'Marco!'
 	});
 	stomp.connect('hf','123',function(e){
 		stomp.send('/app/marco',{},payload);
 	});
 </script>
</body>
</html>