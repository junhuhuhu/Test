package org.zerock.board.command;

public class PageVO {
	
	// 1. total : 게시판 글 전체 개수
	// 2. realend : 게시판의 실제 마지막 페이지 번호
	// 3. endPage : 게시판 화면에 보여질 마지막 페이지 번호
	// 4. startPage : 게시판 화면에 보여질 첫번째 페이지 번호
	// 5. prev : 이전 페이지 버튼 활성화 여부
	// 6. next : 이후 페이지 버튼 활성화 여부
	
	private int startPage;	// 화면에 보여질 시작 페이지 번호
	private int endPage;	// 화면에 보여질 마지막 페이지 번호
	
	private boolean prev, next;	// 이전, 다음 버튼 활성화
	
	private int total;	// 전체 게시물수 
	private Criteria cri; // 기준
	public int getStartPage() {
		return startPage;
	}
	
	public PageVO(Criteria cri, int total) {
		this.cri = cri;	// 기준
		this.total = total;	// 총 게시물 수
		
		// endPage
		// 공식 : (int)Math.ceil(페이지번호 / 10.0) * 10;
		// 공식 : (int)Math.ceil(페이지번호 / (double)(한번에 보여질 페이지 수)) * 한번에 보여질 페이지 수;
		this.endPage = (int)Math.ceil(cri.getPageNum() / (double)10) * 10;	
		
		// startPage
		// 공식 : endPage - 한번에 보여질 페이지 개수 +1
		this.startPage = endPage - 10 + 1;
		
		// 만약 총 게시물이 52개 밖에 없다면? -> 페이지 번호는 6까지 표시되어야 한다
		// 만약 총 게시물이 81개 밖에 없다면? -> 페이지 번호는 9까지 표시
		// 만약 총 게시물이 101개 밖에 없다면? -> 페이지 번호는 11까지 표시
		// 결론 : endPage > 실제 페이지 끝번호 
		// 결론 : endPage > Math.ceil(total / (double)cri.getCount())
		int realEnd =  (int)Math.ceil(total / (double)cri.getCount());
		
		// 게시글이 100개 미만인 경우
		if(this.endPage > realEnd) {
			this.endPage = realEnd;
			
		}
		
		// 이전 버튼(startPage가 1보다 큰 경우 true) - 버튼 황성화
		this.prev = this.startPage > 1;
		
		// 다음 버튼 진짜 끝번호가 endPage 보다 큰 경우만 활성화
		// ex) 페이지 번호가 6인데 활성화 되면 안됨.
		// total 보여질 페이지수 > (int)Math.ceil(cri.getPageNum() / (double)10)*10;
		this.next = realEnd > this.endPage; // 활성화
		
		System.out.println("[endPage] : " + endPage);
		System.out.println("[startPage] : " + startPage);
	}
				
	
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public Criteria getCri() {
		return cri;
	}
	public void setCri(Criteria cri) {
		this.cri = cri;
	}
	
	
	

}
