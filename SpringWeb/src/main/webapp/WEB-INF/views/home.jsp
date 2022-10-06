<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>

	<style>
	  .carousel-inner img {
	      width: 100%;
	      height: 100%;
	  }
	</style>	

</head>
<body>
<%@include file="include/header.jsp"%>

<div class="container" style="margin-top:30px">
  <div class="row">
    <div class="col-sm-5">
      <h2>자신을 소개하세요</h2>
      <h5>당신의 사진을 넣어보세요111</h5>
      <div>
      	<!-- 사진을 넣어보실래요????????경로는 절대경로! -->
      	<img class="img-fluid" src="/MyWeb/resources/img/test.svg" height="300px" width="500px">
      </div>
      <p>한지민</p>
      <h3>소셜 링크</h3>
      <ul class="nav nav-pills flex-column">
        <li class="nav-item">
          <a class="nav-link active" href="https://www.facebook.com/">페이스북</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="https://www.instagram.com/?hl=ko">인스타</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="https://google.com">구글</a>
        </li>
      </ul>
      <hr class="d-sm-none">
    </div>
    <div class="col-sm-1">
    </div>
    <div class="col-sm-6">
      <h2>제 사진은요</h2>
      <h5>화보, ${serverTime }</h5>
     <div style="height: 400px;">
		<div id="demo" class="carousel slide" data-ride="carousel">
	  
		  <!-- 슬라이드 -->
		  <div class="carousel-inner">
		    <div class="carousel-item active">
		      <img src="/MyWeb/resources/img/1.jpg">
		    </div>
		    <div class="carousel-item">
		      <img src="/MyWeb/resources/img/2.jpg">
		    </div>
		    <div class="carousel-item">
		      <img src="/MyWeb/resources/img/3.jpg">
		    </div>
		  </div>
		  
		  <!-- 슬라이드 좌 우 버튼 -->
		  <a class="carousel-control-prev" href="#demo" data-slide="prev">
		    <span class="carousel-control-prev-icon"></span>
		  </a>
		  <a class="carousel-control-next" href="#demo" data-slide="next">
		    <span class="carousel-control-next-icon"></span>
		  </a>
		</div>
      </div>
      <p>한지민</p>
      <p>내용을 작성하세요</p>
      
      
      <br>
      <h2>나의 일상</h2>
      <h5>여행, Sep 2, 2017</h5>
      <div><img class="img-fluid" src="/MyWeb/resources/img/member2.jpg" height="600" width="600"></div>
      <p>한지민</p>
      <p>내용을 작성하세요</p>
    </div>
  </div>
</div>


<%@ include file="include/footer.jsp"%>
</body>
</html>
