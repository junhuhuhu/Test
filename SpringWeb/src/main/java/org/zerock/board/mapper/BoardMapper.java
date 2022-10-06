package org.zerock.board.mapper;

import java.util.ArrayList;

import org.zerock.board.command.BoardVO;
import org.zerock.board.command.Criteria;

public interface BoardMapper {
	
	// 모든 게시물 가져오기
	public ArrayList<BoardVO> getList();
	
	// 게시물 등록
	public void insertBoard(BoardVO vo);
		
	// 게시물 상세보기 가져오기
	public BoardVO getContent(int num);
	
	// 게시물 수정완료 처리하기
	public boolean updateBoard(BoardVO vo);
	
	// 게시물 삭제하기
	public void deleteBoard(int num);
	
	// 페이징 쿼리문 : 매개변수로 Criteria클래스를 받음.
	public ArrayList<BoardVO> pagingList(Criteria cri);
	
	// 
	public int getTotal();		

}
