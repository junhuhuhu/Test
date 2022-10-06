<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">

<head>

</head>

<body id="page-top">
	<!-- Page Wrapper -->

	<%@include file="../include/header.jsp"%>

	<!-- Begin Page Content -->
	

		<!-- Page Heading -->
		<h1 class="h3 mb-2 text-gray-800">게시판</h1>


		<!-- DataTales Example -->
		<div class="card shadow mb-4">
			<div class="card-header py-3">
				<h6 class="m-0 font-weight-bold text-primary">공지사항 샘플 게시판
				<!-- 페이징 : register.jsp의 취소 버튼을 사용시 동작하게 설정 -->
                    <button type="button" class="btn btn-primary btn-sm float-right" onclick="location.href='register?pageNum=${pageMaker.cri.pageNum }&count=${pageMaker.cri.count }'">글쓰기</button>
                </h6>
			</div>
			<div class="card-body">
				<div class="table-responsive">
					<table class="table table-bordered" width="100%" cellspacing="0">
						<thead>
							<tr>
								<th>번호</th>
								<th>제목</th>
								<th>작성자</th>
								<th>작성일</th>
								<th>수정일</th>
								
							</tr>
						</thead>
						<c:forEach var="board" items="${board_list }">
						<tbody>							
								<tr>
									<td>${board.bno }</td>
									<!--  7. 조회페이지 이동 -->
									<!--  상세 페이지로 이동 후 목록 화면으로 이동할때, 기존 페이지를 유지하지 못하는 문제
										  상세, 수정화면 으로 이동할 때, pageNum과 count를 가지고 다녀야 한다
										  변경했다면, content요청에서 변경합니다.
									 -->
									<td>
									<a href="content?num=${board.bno }&pageNum=${pageMaker.cri.pageNum }&count=${pageMaker.cri.count }">${board.title }</a>
									</td>	
									<!-- <td><a href="content?num=${board.bno }">${board.title }</a></td> -->
									<td>${board.writer }</td>
									<td>
										<fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss" value="${board.regdate }" />
									</td>
									<td>
										<fmt:formatDate pattern="yyyy-MM-dd" value="${board.updatedate }" />
									</td>									
								</tr>															
						</tbody>		
						</c:forEach>				
					</table>
					<!-- 페이징 처리 부분 부트스트랩 참고 -->
					<ul class="pagination justify-content-center">
					
						<!-- 1. 이전 페이지 활성화 여부 -->
						<c:if test="${pageMaker.prev }">	
	                       	 <li class="page-item">
	                       	 <!-- 6. 이전 페이지 활성화 -->
	                       	 <!-- 
	                       	 	시작페이지는 startPage가 11일때 활성화 됩니다.
	                       	 	이전페이지 클릭했을때, startPage -1 = 10을 pageNum으로 전달 처리,
	                       	 	getPageStart()를 통해서 마이바티스로 전달
	                       	  -->
								<a class="page-link" href="list?pageNum=${pageMaker.startPage - 1 }">Previous</a>
							</li>
						</c:if>
						
					   <!-- 2. 페이지번호 활성화 여부 -->
					   <c:forEach var="num" begin="${pageMaker.startPage }" end="${pageMaker.endPage }">
						   <!-- 4. /board/list에 요청으로 페이지 번호 전달, 자동으로 count=10 정해져 있음 -->
						   <!-- ###active 속성을 사용하여 현재 페이지를 표시 -->
						   <!-- 페이지 번호 클릭시, 해당 버튼에 페이지번호가 Criteria에 맵핑되게함 -->
						    <li class="page-item ${pageMaker.cri.pageNum == num ? 'active' : '' }">
						    	<a class="page-link" href="list?pageNum=${num }">${num }</a>
						    </li>
					    </c:forEach>
					    
					   <!-- 3. 다음 버튼 활성화 여부 -->
					   <c:if test="${pageMaker.next }">
						    <li class="page-item">
						    <!-- 5. Next 버튼 활성화 링크 -->
						    <!-- 
						    	pageMaker의 endPage는 화면에 보여지는 끝번호 10이 들어 있음.
						    	1 증가 값인 11을 pageNum(페이지번호)에 전달하면,
						    	11이 Criteria 클래스의 pageNum(setter)에 전달되고, getPageStar()를 통해
						    	마이바티스 쿼리에 정보를 전달하여 처리 합니다.
						     -->
						      <a class="page-link" href="list?pageNum=${pageMaker.endPage + 1 }">Next</a>
						    </li>
					    </c:if>
				    </ul>
					<!-- 페이징 처리 끝 -->
				</div>
			</div>
		</div>
	<!-- End of Main -->

	<%@ include file="../include/footer.jsp"%>

