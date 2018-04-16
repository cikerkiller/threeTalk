<!DOCTYPE html>  
<html>  
<head>  
  
</head>  
<script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
<body>  
<script type="text/javascript">
  $(function() {
    console.log("abc");
    $.ajax({url:"http://localhost:8000/threeTalk/socket/login/1",success:function(result){
      console.log(result);
      var ws = new WebSocket("ws://localhost:8000/threeTalk/myHandler")
       ws.onopen = function () {
        console.log("onpen");
       ws.send("{}");
       }
       ws.onclose = function () {
        console.log("onclose");
       }

      ws.onmessage = function (msg) {
        console.log(msg.data);
       }
    }});
  })
</script>
</body>  
</html>  