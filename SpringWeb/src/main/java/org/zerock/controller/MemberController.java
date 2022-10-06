package org.zerock.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.member.command.MemberVO;
import org.zerock.member.service.MemberService;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	/*
	 *  테이블
	 *  create table members(
	 *  id varchar2(30) primary key,
	 *  pw varchar2(30) not null,
	 *  name varchar2(30),
	 *  regdate date default sysdate
	 *  );
	 *  
	 *  "org.zerock.member.command.MemberVo"를 생성
	 *  
	 */
	
	@Autowired
	private MemberService service;
	
	// 로그인 화면처리
	@RequestMapping("/login")
	public String login() {
		return "member/login";
	}
	
	// 회원가입 화면처리
	@RequestMapping("/join")
	public String join() {
		return "member/join";
	}
	
	// ajax요청 받기
	// json 라이브러리 다운...
//	<!-- json라이브러리 -->
//	<dependency>
//		<groupId>com.fasterxml.jackson.core</groupId>
//		<artifactId>jackson-databind</artifactId>
//		<version>2.9.8</version>
//	</dependency>
	@RequestMapping(value = "/checkId", method = RequestMethod.POST)
	@ResponseBody
	public int CheckId(@RequestParam("id") String id) {
		System.out.println(id);
		int result = service.idCheck(id);
		
		return result;
	}
	
	// join폼 처리
	@RequestMapping("/joinForm")
	public String joinForm(MemberVO vo, RedirectAttributes ra) {
		// join정보 처리
		int result = service.join(vo);
		// 가입처리 성공 여부에 따른 메세지 발송
		if(result == 1) {	// 1을 리턴받았다는 의미는 insert 성공
			ra.addFlashAttribute("msg", "회원가입에 성공했습니다.");
		} else {
			ra.addFlashAttribute("msg", "가입에 실패했습니다.");
		}
		// 리다이렉트 방식으로 로그인으로 접근
		return "redirect:/member/join_result";
	}
	
	@RequestMapping("join_result")
	public String join_result() {
		return "member/join_result";
	}
	
	// 로그인 폼 처리
	@RequestMapping("/loginForm")
	public String loginForm(MemberVO vo, HttpSession session, RedirectAttributes ra) {
		int result= service.login(vo);
		// 로그인 구동을 구현하세요!!
		// 서비스 영역에 login()을 만들어서 동작하게 해주세요
		// 마이바티스에서 login()을 인터페이스에 구현하고, 동작하게 해주세요
		if(result == 1) {
			session.setAttribute("user_id", vo.getId());
			return "redirect:/";
		} else {
			ra.addFlashAttribute("msg", "아이디 혹은 비밀번호를 확인하세요.");	// 1회성 메세지
			return "redirect:/member/login";
		}
	}
	
	// 로그아웃 처리
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	// ajax 테스트
	@RequestMapping("/ajax_test")
	public String test() {
		
		return "member/ajax_test";
	}

}
