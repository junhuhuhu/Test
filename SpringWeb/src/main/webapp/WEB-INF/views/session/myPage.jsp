<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>myPage</title>
	</head>
	<body>
		<h2>마이페이지 입니다.</h2>
		<h3>${sessionScope.user_id }님 로그인을 환영합니다.</h3>
		<a href="updatePage">회원정보 변경</a>
		<a href="logout">로그아웃</a>
	</body>
</html>