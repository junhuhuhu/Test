<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ include file="../include/header.jsp" %>

<div class="row">
  <div class="col-lg-12">
    <h1 class="page-header">Board Register</h1>
  </div>
  <!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
  <div class="col-lg-12">
    <div class="card">
      <div class="card-header bg-primary text-white">게시글 등록</div>
      <div class="card-body">



        <form role="form" action="register" method="post" id="regForm">
          <div class="form-group">
            <label>제목</label>
            <input class="form-control" name='title' id='title'>
          </div>

          <div class="form-group">
            <label>내용</label>
            <textarea class="form-control" rows="5" name='content' id='content'></textarea>
          </div>

          <div class="form-group">
            <label>작성자</label>
            <input class="form-control" name='writer' id='writer'>
          </div>
          <button type="button" class="btn btn-primary" onclick="register()">등록</button>
          <button type="button" class="btn btn-primary" onclick="location.href='list?pageNum=${cri.pageNum}&count=${cri.count }'">취소</button>
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
	function register() {
		// $("#아이디") or $(아이디)는 HTML의 아이디 속성에 한번에 접근
		// val() 함수는 해당 아이디에 값에 접근하여 반환
		if( $("#title").val() == "") {
			// alert("제목을 입력하세요")
			// 모달 보기
			$("#myModal").modal("show");
		} else if ( $("#writer").val() == "") {
			// alert("작성자를 입력하세요")
			// 모달 보기
			$("#myModal").modal("show");
		} else {
			$("#regForm").submit();
		}
	}
</script>
<!-- 
	모달창!!
	1. 모달창이란? 팝업 창하고 비슷하지만, 팝업창은 새로운 브라우저를 열어서 보여주는 방식
	하지만, 모달은 새로운 브라우저를 열지 않고, 기존창에 새로운 레이어를 보여주는 것을 말함
	모달창은 제거하지 않고 페이지 이동하면 자연히 사라지고, 기본페이지와는 부모-자식 관계를 
	가지면서 브라우저의 새창 제어 옵션에 영향을 받지 않습니다.
	
	2. 왜? 사용할까? 모달창은 다음 진행으로 넘어가기 위한 필요에 의해서 사용됩니다.
	모달창을 브라우저의 강제적인 팝업 닫기와 다르게 영향을 받지 않고 표현이 되고,
	모달창을 닫기 전에는 부모 창에 직접 이벤트를 행할수 없다는 특징이 있다.
	
	모달은 여러 위젯을 사용해 꾸밀수 있지만 게시판, 캘린더, 지도, 게시판, 쇼핑과 같은 
	일부 DB 위젯은 사용할수 없습니다.
	
	3. 어떻게 사용하지? 
	사용방법은 화면에 미리 만들어 놓고, 호출하여 사용하는 방식으로 사용됩니다.
	id 지정 -> 자바스크립트를 통해서 modal("show")함수로 화면에 보여지게 됩니다.	
	
 -->
 
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

