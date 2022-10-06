<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="../include/header.jsp" %>

<div class="row">
  <div class="col-lg-12">
    <h1 class="page-header">Board Modify Page</h1>
  </div>
  <!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
  <div class="col-lg-12">
    <div class="card">
      <div class="card-header bg-primary text-white">수정 페이지</div>
      <div class="card-body">



        <form role="form" action="update?pageNum=${cri.pageNum}&count=${cri.count }" method="post" id="regForm">
          
          <div class="form-group">
            <label>번호</label>
            <input class="form-control" name='bno' readonly="readonly" value="${board.bno }">
          </div>
          
          <div class="form-group">
            <label>제목</label>
            <input class="form-control" name='title' value="${board.title }" id="title">
          </div>

          <div class="form-group">
            <label>내용</label>
            <textarea class="form-control" rows="5" name='content' id="content">${board.content }</textarea>
          </div>

          <div class="form-group">
            <label>작성자</label>
            <input class="form-control" name='writer' value="${board.writer }" id="writer">
          </div>
          
          
          <!-- 12. 목록으로 이동시 pageNum과 count 값을 전달 -->
         <!--  <button type="submit" class="btn btn-primary">변경</button>
          <button type="button" class="btn btn-secondary" onclick="location.href='delete?num=${board.bno }'">삭제</button>
          <button type="button" class="btn btn-dark" onclick="location.href='list?pageNum=${cri.pageNum}&count=${cri.count }'">목록</button> -->
          
          <!-- 자바스크립트 페이징 처리 -->
        <button type="button" class="btn btn-primary" onclick="buttonCheck('modify')">변경</button>
          <button type="button" class="btn btn-secondary" onclick="buttonCheck('delete')">삭제</button>
          <button type="button" class="btn btn-dark" onclick="buttonCheck('list')">목록</button>
          
          <input type="hidden" name="pageNum" value="${cri.pageNum }">
          <input type="hidden" name="count" value="${cri.count }">
          
        </form>        
        

      </div>
      <!--  end card-body -->
    </div>
    <!--  end card-body -->
  </div>
  <!-- end card -->
</div>
<!-- /.row -->

<script type="text/javascript">
	function buttonCheck(e) {		
		if(e == 'delete') {
			if(confirm("삭제하겠습니까?")) {
				// $("#아이디") or $(아이디)는 HTML 아이디 속성에 바로접근
				// attr(속성, 변경할 값) 함수와 태그의 내부 속성을 변경하는 함수
				$("#regForm").attr("action", "delete");
				$("#regForm").submit();
				return;
			} else {
				return;	
			}
		} else if(e == 'modify') {
			if($("#title").val() == "") {
				// alert("제목과 내용은 입력하세요.");
				$("#myModal").modal("show");
				return;
			} else if($("#writer").val() == "") {
				// alert("작성자를 입력하세요.");
				$("#myModal").modal("show");
				return;
			} else if(confirm("수정하겠습니까?")) {
				$("#regForm").submit();
				return;
			}
		} else {
			$("#regForm").attr("action", "list");
			$("#regForm").submit();
		}		
	}
</script>

<div class="modal fade" id="myModal">
 	<div class="modal-dialog">
 		<div class="modal-content">
 			<!-- Modal Header -->
 			<div class="modal-header">
 				<h4 class="modal-title">Modal Heading</h4>
 				<button type="button" class="close" data-dismiss="modal">&times;</button>
 			</div>
 			<!-- Modal Body -->
 			<div class="modal-body">
 				제목, 작성자는 필수 사항입니다.
 			</div>
 			<!-- Modal Footer -->
 			<div class="modal-footer">
 				<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
 			</div>
 		</div>
 	</div>
 </div>
<%@ include file="../include/footer.jsp" %>
