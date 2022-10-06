package org.zerock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.board.command.Criteria;
import org.zerock.reply.command.ReplyPageVO;
import org.zerock.reply.command.ReplyVO;
import org.zerock.reply.service.ReplyService;

import lombok.AllArgsConstructor;

@RequestMapping("/replies/")
@RestController
//@Log4j
@AllArgsConstructor
public class ReplyController {
	
	@Autowired
	private ReplyService service;
	
	// 등록처리
	@PostMapping(value="/new",
			consumes = "application/json",
			produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> create(@RequestBody ReplyVO vo) {
		
		System.out.println("ReplyVO : " + vo);
		
		int insertCount = service.register(vo);
		
		System.out.println("Reply Insert count : " + insertCount);
		return insertCount==1 ? 
		new ResponseEntity<>("success", HttpStatus.OK) : 
			new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	// 게시물 확인
	@GetMapping(value = "/pages/{bno}/{page}",
				produces = {MediaType.APPLICATION_XML_VALUE,
							MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<ReplyPageVO> getList(@PathVariable("page") int page, @PathVariable("bno") int bno) {
		System.out.println("getList......");
		Criteria cri = new Criteria(page, 10);
		System.out.println(cri);
		return new ResponseEntity<>(service.getListPage(cri, bno), HttpStatus.OK);
	}
	
	// 댓글 조회
	@GetMapping(value = "/{rno}",
				produces = {MediaType.APPLICATION_XML_VALUE,
							MediaType.APPLICATION_JSON_UTF8_VALUE
				})
	public ResponseEntity<ReplyVO> get(@PathVariable("rno") int rno) {
		System.out.println("get : " + rno);
		return new ResponseEntity<ReplyVO>(service.get(rno),HttpStatus.OK);
	}
	
	// 댓글 삭제
	@DeleteMapping(value = "/{rno}",
			produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> remove(@PathVariable("rno") int rno) {
		System.out.println("remove : " + rno);
		return service.remove(rno)==1 ?
				new ResponseEntity<>("success",HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	// 댓글 수정
	@RequestMapping(value="/{rno}",
					method= {RequestMethod.PUT, RequestMethod.PATCH},
					consumes = "application/json",
					produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> modify(@RequestBody ReplyVO vo,
											@PathVariable("rno") int rno) {
		vo.setRno(rno);
		System.out.println("rno : " + rno);
		System.out.println("modify : " + vo);
		
		return service.modify(vo) ==1 ? new ResponseEntity<>("success",HttpStatus.OK)
									  : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
