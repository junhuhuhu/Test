<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>ajax_test</title>
	</head>
	<body>
		<input type="text" id="apple" value="홍길자">
		<input type="text" id="melon" value="홍길숙">
		<input type="text" id="grape" value="홍길동">
		
		<button onclick="check()">확인</button>
		
		<script type="text/javascript" src="//code.jquery.com/jquery-3.4.0.min.js"></script>
		<script type="text/javascript">
		
			$(document).ready(function() {
				var msg = '${msg}';
				
				if(msg != '') {
					alert(msg);
				}
			});
		
			function check(){
				
				$.ajax({
					type : "post",
					url : "checkId",
					data : {"id" : $("#apple").val()},
					success : function(result) {
						alert(result + "비동기 성공!!")
					}
				})
			}			
		</script>
	</body>
</html>