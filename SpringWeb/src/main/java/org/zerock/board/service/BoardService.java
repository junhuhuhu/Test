package org.zerock.board.service;

import java.util.ArrayList;

import org.zerock.board.command.BoardVO;
import org.zerock.board.command.Criteria;

public interface BoardService {
	
//	public ArrayList<BoardVO> getList(); 	// 게시판 리스트 가져오기
	public ArrayList<BoardVO> getList(Criteria cri); // 페이징 처리 리스트 가져오기
	
	public void register(BoardVO vo); 	// 게시판 등록 메서드
	
	public BoardVO getContent(int num); 	// 게시물 상세보기 메서드(반환유형 고려해야 함)
	
	public void update(BoardVO vo);		// 게시물 수정 완료 메서드
	
	public void delete(int num); 	// 게시물 삭제

	public int getTotal();			// 게시물 전체 갯수
}
