package org.zerock.board.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.board.command.BoardVO;
import org.zerock.board.command.Criteria;
import org.zerock.board.mapper.BoardMapper;


// Service
// 스프링에서 DispatcherServlet이 동작하고, 핸드러어댑터가 가동되면,
// 해당 어노테이션을 확인 빈으로 등록 생성
// 수동으로 bean등록을 하지 않았고, 어노테이션을 사용했다면,
// servlet-context에서 컴포넌트 스캔을 사용해야 합니다.
@Service
public class BoardServiceImpl implements BoardService {
	
	// DAO영역은 MyBatis를 사용하여 구현...
	@Autowired
	private BoardMapper mapper;

//	@Override
//	public ArrayList<BoardVO> getList() {
//		ArrayList<BoardVO> list = mapper.getList();
//		return list;
//	}	
	
	@Override
	public ArrayList<BoardVO> getList(Criteria cri) {
		ArrayList<BoardVO> list = mapper.pagingList(cri);
		return list;
	}

	@Override
	public void register(BoardVO vo) {
		System.out.println(vo.getTitle());
		System.out.println(vo.getContent());
		System.out.println(vo.getWriter());
		mapper.insertBoard(vo);

	}
	
	@Override
	public BoardVO getContent(int num) {
		// 마이바티스의 맵퍼 확인
		BoardVO vo = mapper.getContent(num);
		
		
		return vo;
	}
	
	@Override
	public void update(BoardVO vo) {
		
		boolean bool = mapper.updateBoard(vo);
		System.out.println("성공(true), 실패(false) ? : " + bool);
		
	}
	
	@Override
	public void delete(int num) {
		
		mapper.deleteBoard(num);
		
	}
	
	@Override
	public int getTotal() {
		int total = mapper.getTotal();
		return total;
	}

}
