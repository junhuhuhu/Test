package org.zerock.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.board.command.BoardVO;
import org.zerock.board.command.Criteria;
import org.zerock.board.command.PageVO;
import org.zerock.board.service.BoardService;

@Controller
@RequestMapping("/board/")
public class BoardController {
	
	/*
	 * board 관련 테이블 생성 : tbl_board [ 계정은 spring ]
	 * 
	 * - tbl_board
	 * create table tbl_board(
	 * bno number(10,0),
	 * title varchar2(200) not null,
	 * content varchar2(200) not null,
	 * writer varchar2(50) not null,
	 * regdate date default sysdate,
	 * updatedate date default sysdate
	 * );
	 * 
	 * - 시퀸스 생성
	 * create sequence seq_board;
	 * 
	 * - alter table tbl_board add constraint pk_board primary key (bno);
	 * 
	 */
	
	@Autowired
	private BoardService service;
	
	// 게시글 리스트
//	@RequestMapping("/list")
//	public String list(Model model) {
//		// list 요청이 들어오면, DB에서 게시판에 대한 모든 내용을 가지고, 화면으로 이동
//		ArrayList<BoardVO> list = service.getList();
//		// 컨트롤러 메서드의 리턴값을 추가 하고 싶다면 
//		// 1. Model 객체를 추가, 간편하게 전달할 수 있음
//		// 2. 리턴 유형을 ModelAndView 객체로 추가하여 작업
//		model.addAttribute("board_list", list);
//		
//		return "board/list";
//	}
	
	// 페이징 화면 처리
	@RequestMapping("/list")
	public String list(Model model, Criteria cri) {
		// 게시글 정보 가져오기... (Criteria을 기준으로 설정)
		ArrayList<BoardVO> list = service.getList(cri);
		
		model.addAttribute("board_list", list);
		
		// 게시글 전체 데이터 가져오기
		int total = service.getTotal(); // 게시글 전체 갯수 알아오기
		model.addAttribute("pageMaker", new PageVO(cri, total));
		
		
		return "board/list";
	}
	
	// GET 등록화면으로 이동
	// @RequestMapping(value = "/register",method=RequestMethod)
	@GetMapping("/register")	// get방식으로 처리되는 경우 접속
	public String register(@ModelAttribute("cri") Criteria cri) {
		System.out.println("화면처리");
		return "board/register";
	}
	
	@PostMapping("/register")
	public String register(BoardVO vo) {
		System.out.println("등록 처리");
		
		// 서비스 처리 ...
		service.register(vo);
		
		return "redirect:/board/list";
	}
	
//	@RequestMapping("/content")
//	public String content(@RequestParam("num") int num, Model model, @ModelAttribute("cri") Criteria cri) {
//		// 8. 페이징에서 추가할 내용이 존재함
//		
//		System.out.println("=====컨트롤러=====");
//		System.out.println(num);
//		
//		// num(bno)을 가지고 있는 데이터(row)를 불러오는 메서드
//		BoardVO vo = service.getContent(num);
//		model.addAttribute("board", vo);
//		
//		return "board/content";
//	}
//	
//	// 수정페이지 처리 (modify.jsp)
//	@RequestMapping("/modify")
//	public String modify(@RequestParam("num") int num, Model model, @ModelAttribute("cri") Criteria cri) {
//		
//		BoardVO vo = service.getContent(num);
//		model.addAttribute("board", vo);
//		
//		return "board/modify";
//	}
	
	// 상세보기와 수정을 한번에 처리
	@RequestMapping({"/modify","/content"})
	public void modify(@RequestParam("num") int num, Model model, @ModelAttribute("cri") Criteria cri) {
		
		BoardVO vo = service.getContent(num);
		model.addAttribute("board", vo);
		
		
	}
	
	// 게시판 수정 완료 버튼 처리
	@RequestMapping("/update")
	public String update(BoardVO vo, Criteria cri) {
		System.out.println("----컨트롤 계층-----");
		System.out.println(vo.getBno());
		System.out.println(vo.getTitle());
		System.out.println(vo.getContent());
		// 문제
		// 1. service 계층에 전달받을 폼값을 전달하는 update(vo)를 생성
		// 2. update()메서드 안에서 mybatis로 연결하는 updateBoard(vo) 메서드 생성
		// 	전체 동작을 통해서 업데이트를 진행
		service.update(vo);
		
		System.out.println(cri.getPageNum());
		
		return "redirect:/board/list";
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("bno") int num) {
		System.out.println("컨트롤러 계층");
		System.out.println(num);
		// delete 구현
		// 1. service계층에 num을 전달받아 처리하는 delete()를 생성
		// 2. mapper 인터페이스 void deleteBoard()를 선언
		// 3. Service안에서는 mapper의 deleteBoard()를 실행
		// 4. mapper.xml 에서는 <delete></delete>를 통해서 삭제 진행
		// 5. sql = delete from tbl_board where bno = #{num}
		
		service.delete(num);
		
		return "redirect:/board/list";
	}
	

}
