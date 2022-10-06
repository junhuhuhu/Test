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

  <title>회원 가입</title>
  
 
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
							<div class="text-center">
								<h1 class="h4 text-gray-900 mb-4">회원가입</h1>
							</div>
							
							<!-- 자바스크립트(제이쿼리)를 사용하기 전에 input 태그의 id속성을 확인 -->
							<form class="user" action="joinForm" method="post" id="regForm">
								<!-- 아이디 -->
								<div class="form-group row">
									<div class="col-sm-8 mb-3 mb-sm-0">
										<input type="text" class="form-control form-control-user" placeholder="아이디" name="id" id="id">
									</div>
									<div class="col-sm-4">
										<input type="button" class="btn btn-primary btn-user btn-block" value="중복체크" onclick="IdCheck()">										
									</div>									
								</div>
								<!-- name -->
								<div class="form-group">
									<input type="text" class="form-control form-control-user" placeholder="이름" name="name" id="name">									
								</div>
								<!-- 비밀번호 -->
								<div class="form-group">
									<div class="col-sm-13 mb-3 mb-sm-0">
										<input type="password" class="form-control form-control-user" placeholder="비밀번호" name="pw" id="pw">									
									</div>
								</div>
								<!-- 비밀번호 확인 -->
								<div class="form-group">
									<div class="col-sm-13 mb-3 mb-sm-0">
										<input type="password" class="form-control form-control-user" placeholder="비밀번호 확인" id="pwCheck">									
									</div>
								</div>
								<input type="button" class="btn btn-primary btn-user btn-block" value="회원가입" onclick="joinCheck()">
							</form>
							
							<hr>
							<div class="text-center">
								<a class="small" href="/MyWeb">메인으로</a>
							</div>
							<div class="text-center">
								<a class="small" href="login">로그인</a>
							</div>
							<div class="col-lg-3"></div>
						</div>
					</div>
				</div>
			</div>
		</div>		
		
  <script type="text/javascript">
  	function IdCheck() {
  		
  		var id = $("#id").val(); //id태그 값에 접근
  		var userId = {"id":id};	// 전송할 데이터의 key : value 값설정
  		
  		if(id.length < 4) {
  			alert("아이디는 4글자 이상 입력하세요");
  		} else { // 아이디 중복 체크  			
  			// 먼저 ajax가 지원하는 JSON (데이터포멧)을 사용하기 위해서 라이브러리가 필요함
  			// JSON 은 {키:갑}을 구조로 사용하는 데이터 묶음입니다.
  			
  			// ajax문법
  			$.ajax({
  				type : "post", 		// 요청형식
  				url : "checkId",	// 요청할 주소
  				data : userId,		// 서버에 전송할 테이터 json형식 {key:value}
  				// datatype : "json", // 서버에서 요청후 리턴해 주는 타입
  				error : function(request, error) {
  					alert(error + "\n" + request.status)
  				},
  				success : function(result){
  					// ajax통신에 성공했을 때, 호출될 자바스크립트 함수, 결과 여부가
  					// result 매개변수로 전달됨.
  					console.log("성공(1) 실패(0) 여부 : " + result);
  					
  					if(result == 1) {	// 중복된 아이디가 존재함
  						alert("이미 존재하는 아이디가 있습니다.");  						
  					} else {
  						alert("사용가능한 아이디 입니다.");
  						$("#id").attr("readonly", true);
  						// attr(속성, 변경할 값)함수는 태그의 내부속성을 변경
  					}
  				}
  			});
  		}	// else가 끝나는 부분
  			console.log(userId);
  	}
  	  	
  	function joinCheck() {
  		
  		if (!$("#id").attr("readonly")) {
  			alert("아이디 중복체크를 하세요.");
  		} else if ($("#name").val().length < 1) {
  			alert("이름을 입력하세요");
  		} else if ($("#pw").val().length < 1) {
  			alert("비밀번호를 입력하세요");
  		} else if ($("#pw").val() != $("#pwCheck").val()) {
  			alert("비밀번호가 일치하지 않습니다.");
  			$("#pwCheck").focus();	// 해당 id태그로 마우스 커서를 위치함.
  		} else if (confirm("회원 가입 하시겠습니까?")) {
  			$("#regForm").submit();
  		}
  		
  	} 
  </script>	
		
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
	</body>
</html>