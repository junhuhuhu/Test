<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>게시판 연습</title>
  
 
  <!-- Custom fonts for this template -->
  <link href="${pageContext.request.contextPath}/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="${pageContext.request.contextPath}/resources/css/sb-admin-2.min.css" rel="stylesheet">

  <!-- Custom styles for this page -->
  <link href="${pageContext.request.contextPath}/resources/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/resources/css/reply.css" rel="stylesheet">


</head>
<body>
	<div id="wrapper">
	
    <!-- Sidebar -->
    <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

      <!-- Sidebar - Brand -->
      <a class="sidebar-brand d-flex align-items-center justify-content-center" href="${pageContext.request.contextPath}">
        <div class="sidebar-brand-icon rotate-n-15">
          <i class="fas fa-laugh-wink"></i>
        </div>
        <div class="sidebar-brand-text mx-3">MyWeb</div>
      </a>
	
	 
	
      <!-- Divider -->
      <hr class="sidebar-divider my-0">

      <!-- Nav Item - Dashboard -->
      <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}">
          <!--
          <i class="fas fa-fw fa-tachometer-alt"></i>
          <i class="fas fa-fw fa-cog"></i>
          <i class="fas fa-fw fa-wrench"></i>
		  -->
          <i class="fas fa-fw fa-chart-area"></i>
          <span>Main</span></a>
      </li>
      <!-- Nav Item - Pages Collapse Menu -->
      <li class="nav-item">
        <a class="nav-link collapsed" href="############################" data-toggle="collapse" data-target="#collapsePages" aria-expanded="true" aria-controls="collapsePages">
          <i class="fas fa-fw fa-folder"></i>
          <span>내 정보</span>
        </a>
        <div id="collapsePages" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <h6 class="collapse-header">Login</h6>
            <c:choose>
            	<c:when test="${sessionScope.user_id==null}">
		            <a class="collapse-item" href="${pageContext.request.contextPath}/member/join">회원가입</a>
		            <a class="collapse-item" href="${pageContext.request.contextPath}/member/login">로그인</a>
	            </c:when>
	            <c:otherwise>
	            	<a class="collapse-item" href="${pageContext.request.contextPath}/member/mypage">마이페이지</a>
	            <a class="collapse-item" href="${pageContext.request.contextPath}/member/logout">로그아웃</a>
	            </c:otherwise>
            </c:choose>
          </div>
        </div>
      </li>

      <!-- Nav Item - Tables -->
      <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/board/list">
          <i class="fas fa-fw fa-table"></i>
          <span>공지사항 게시판</span></a>
      </li>

      <!-- Nav Item - Tables -->
      <li class="nav-item active">
        <a class="nav-link" href="${pageContext.request.contextPath}/board/register">
          <i class="fas fa-fw fa-table"></i>
          <span>공지사항 등록</span></a>
      </li>

      <!-- Divider -->
      <hr class="sidebar-divider d-none d-md-block">

      <!-- Sidebar Toggler (Sidebar) -->
      <div class="text-center d-none d-md-inline">
        <button class="rounded-circle border-0" id="sidebarToggle"></button>
      </div>

    </ul>
    <!-- End of Sidebar -->

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

      <!-- Main Content -->
      <div id="content">

        <!-- Topbar -->
        <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

          <!-- Sidebar Toggle (Topbar) -->
          <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
            <i class="fa fa-bars"></i>
          </button>

          <!-- Topbar Search############################ -->
          <form class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
            <div class="input-group">
              <input type="text" class="form-control bg-light border-0 small" placeholder="Search" aria-label="Search" aria-describedby="basic-addon2">
              <div class="input-group-append">
                <button class="btn btn-primary" type="button">
                  <i class="fas fa-search fa-sm"></i>
                </button>
              </div>
            </div>
          </form>

          <!-- Topbar Navbar -->
          <ul class="navbar-nav ml-auto">

            

            <!-- Nav Item - User Information -->
            <li class="nav-item dropdown no-arrow">
              <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown">
                <span class="mr-2 d-none d-lg-inline text-gray-600 small">${sessionScope.user_id }</span>
                <img class="img-profile rounded-circle" src="/MyWeb/resources/img/user.png">
              </a>
              <!-- Dropdown - User Information -->
              <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="userDropdown">                
                  <c:choose>   
					<c:when test="${sessionScope.user_id==null}">   
						<a class="dropdown-item" href="${pageContext.request.contextPath}/member/login">
	                    <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
	                  	로그인
	                  	</a>
                  	</c:when>
                  	<c:otherwise>
	                  	<a class="dropdown-item" href="${pageContext.request.contextPath}/member/mypage">
	                    <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>                    
	                  	마이페이지
	                  	</a>
                  	</c:otherwise>
                </c:choose>               
                <c:choose>   
					<c:when test="${sessionScope.user_id==null}">   
					<a class="dropdown-item" href="${pageContext.request.contextPath}/member/join"> <!--data-toggle="modal" data-target="#logoutModal">-->
                  <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                  회원가입
                  </a>
                  </c:when>
                  <c:otherwise>
                  	<a class="dropdown-item" href="${pageContext.request.contextPath}/member/logout"> 
                  	<i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                  	로그아웃
                  	 </a>
                  </c:otherwise>
               </c:choose>
              </div>
            </li>

          </ul>

        </nav>
        <!-- End of Topbar -->
		
		<div class="container-fluid">
		<!-- 헤더 끝 -->
</body>
</html>