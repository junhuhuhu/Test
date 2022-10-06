package org.zerock.board.command;

public class Criteria {
	
	// mysql, mariadb : select * from tbl_board by num desc limit ?, ?;
	// oracle : select * from (select rownum as rnum, bno, writer from tbl_board where ? >= rownum order by bno desc) where rnum >= ?;
	
	private int pageNum; 	// 페이지 번호
	private int count;		// 몇개의 데이터를 게시판에 출력 할지 결정
	
	public Criteria() {
		// 최초 게시판에 진입할 떄 기본값 설정, 1번 페이지, 10개의 게시물 설정
		this.pageNum = 1;
		this.count = 10;
	}

	public Criteria(int pageNum, int count) {
		// 전달받은 배개변수를 이용한 페이지 값 출력
		super();
		this.pageNum = pageNum;
		this.count = count;
	}
	
	public int getPageStart() {
		 
		
//		return ((pageNum - 1) * count); 	// mysql, mariadb인경우
		return ((pageNum - 1) * count) + 1;		// 오라클
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getCount() {
		return count;
	}
	
	public int getCount_oracle() {
		return (pageNum * count);
		
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	

}
