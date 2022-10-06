<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>로그인</title>
  
 
  <!-- Custom fonts for this template -->
  <link href="${pageContext.request.contextPath}/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="${pageContext.request.contextPath}/resources/css/sb-admin-2.min.css" rel="stylesheet">

  <!-- Custom styles for this page -->
  <link href="${pageContext.request.contextPath}/resources/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
  


</head>
	<body class="bg-gradient-primary">
		<div class="container">
			<div class="card o-hidden board-0 shadow-lg my-5">
				<!-- nested Row within Card Body -->
				<div class="row">
					<div class="col-lg-3"></div>
					
					<div class="col-lg-6">
						<div class="p-5">
							<div class="text-content">
								<h1 class="h4 text-gray-900 mb-4">로그인</h1>
							</div>
							
							<!-- 자바스크립트(제이쿼리)를 사용하기 전에 input 태그의 id속성을 확인 -->
							<form class="user" action="loginForm" method="post">
								<!-- 아이디 -->
								<div class="form-group">									
										<input type="text" class="form-control form-control-user" placeholder="아이디" name="id">																
								</div>								
								<!-- 비밀번호 -->
								<div class="form-group">									
										<input type="password" class="form-control form-control-user" placeholder="비밀번호" name="pw">						
								</div>
								<input type="submit" class="btn btn-primary btn-user btn-block" value="로그인">
								<input type="button" class="btn btn-primary btn-user btn-block" value="회원가입" onclick="location.href='join'">
							</form>							
							<hr>
							<div class="text-center">
								<a class="small" href="/MyWeb">메인으로</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>		
		
  <!-- Bootstrap core JavaScript-->
  <script src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="${pageContext.request.contextPath}/resources/vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="${pageContext.request.contextPath}/resources/js/sb-admin-2.min.js"></script>

  <!-- Page level plugins -->
  <script src="${pageContext.request.contextPath}/resources/vendor/datatables/jquery.dataTables.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/vendor/datatables/dataTables.bootstrap4.min.js"></script>

  <!-- Page level custom scripts -->
  <script src="${pageContext.request.contextPath}/resources/js/demo/datatables-demo.js"></script>
  
  <!-- jquery 임포트 코드가 로딩된 후에 실행되도록 페이지 마지막에 작성 -->
  <script type="text/javascript">
  	$(document).ready(function() {
  		var msg = '${msg }';
  		if(msg 1='') {
  		alert(msg);
  		}
  	});  	
  </script>
	</body>
</html>