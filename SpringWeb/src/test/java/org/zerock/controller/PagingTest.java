package org.zerock.controller;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.board.command.BoardVO;
import org.zerock.board.command.Criteria;
import org.zerock.board.command.PageVO;
import org.zerock.board.mapper.BoardMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class PagingTest {

	@Autowired
	BoardMapper mapper;
	
	@Test
	public void pagingTest() {
		
		Criteria cri = new Criteria();
		
		cri.setPageNum(2);  // 2번페이지 클릭
		cri.setCount(10);	// 10개씩 보기
		
		ArrayList<BoardVO> list = mapper.pagingList(cri);
		
		for(BoardVO vo : list) {
			System.out.println("게시물 번호 : " + vo.getBno());
		}
		
	}
	
	@Test
	public void ceilTest() {
		
		// 올림 함수 Math.ceil(실수)
		System.out.println("ceil확인 : " + Math.ceil(2.1));
		
		// 5페이지를 보고 있다면 보여질  화면의 페이지는 1 ~ 10
		// 11페이지를 보고 있다면 보여질  화면의 페이지는 11 ~ 20
		
		// 끝 페이지 번호
		// 공식 : (int)Math.ceil(페이지번호 / 10.0) * 10;
		int end = (int)Math.ceil(5 / 10.0) * 10;
		System.out.println("페이지가 5 일때 보여지는 끝번호  : " + end);
		
		// 시작페이지 번호
		// 공식 : (끝 페이지 - 9)
		int start = end - 9;
		System.out.println("페이지가 5 일때 보여지는 시작번호 : " + start);
		
		// 끝 페이지 번호
		// 공식 : (int)Math.ceil(페이지번호 / 10.0) * 10;
		int end1 = (int)Math.ceil(11 / 10.0) * 10;
		System.out.println("페이지가 11 일때 보여지는 끝번호  : " + end1);
				
		// 시작페이지 번호
		// 공식 : (끝 페이지 - 9)
		int start1 = end1 - 9;
		System.out.println("페이지가 11 일때 보여지는 시작번호 : " + start1);
		
		// 만약에 데이터의 통 게시글의 수가 100개 이하라면?
		
		// 보여져야 할 페이지 수 = 9개
		int realEnd = (int)Math.ceil(81*1.0 / 10);
		System.out.println("전체 데이터가 100 이하일떄 : " + realEnd);
		
		// 총 게시글 수 :
		int total = 210;
		Criteria cri = new Criteria();
		cri.setPageNum(11);
		PageVO pvo = new PageVO(cri, total);
		System.out.println(pvo.getEndPage());
		System.out.println(pvo.getStartPage());
		
	}
	
	
}
