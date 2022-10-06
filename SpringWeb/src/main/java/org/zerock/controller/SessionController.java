package org.zerock.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/session/*")
public class SessionController {
	
	// 해당 컨트롤러는 세션 연습 컨트롤러
	
	// 1. main 화면 처리
	@RequestMapping("/mainPage")
	public String mainPage() {
		return "session/mainPage";
	}
	
	// 2. loginPage 처리
	@RequestMapping(value="/loginPage", method=RequestMethod.GET)
	public String loginPage() {
		return "session/loginPage";
	}
	
	// 3. 마이페이지 화면 처리
	@RequestMapping(value="/myPage", method=RequestMethod.GET)
	public String myPage(HttpSession session) {
		// 9. 마이페이지 접근 막기
		// 세션 아이디가 없다면 접근할 수 없도록하고, 메인페이지로 이동
//		if(session.getAttribute("user_id") == null) {
//			return "redirect:/session/loginPage";
//		}
		return "session/myPage";
	}
	
	// 4. updatePage 화면처리
	@RequestMapping(value="/updatePage", method=RequestMethod.GET)
	public String updatePage() {
		// 10. 모든페이지에 세션 검사를 하는 불편함이 생긴다.
		//	(처리하지 않으면 주소를 통해 강제 접근이 가능해진다.)
		return "session/updatePage";
	}
	
	// 5. 로그인 폼 처리
	@RequestMapping("/sessionLogin")
	public String sessionLogin(@RequestParam("id") String id, @RequestParam("pw") String pw, HttpSession session, RedirectAttributes ra) {
		// 6. 아이디가 "abc", 비밀번호가 "1234"라면 로그인 성공이라고 가정
		if(id.equals("abc") && pw.equals("1234")) {
			// 로그인 성공시 세션을 생성
			session.setAttribute("user_id", id);	// 세션에 아이디 저장
			session.setAttribute("user_name", "홍길동");	// 세션에 이름 저장
			return "redirect:/session/myPage";
		} else { // 6. 아이디 비밀번호가 틀린 경우 로그인 화면으로 보내는 경우
			// 7. 리다이렉트 보내면서 1회성 데이터로 파라미터 값을 전달할 경우에 사용
			ra.addFlashAttribute("msg", "아이디, 비밀번호를 확인하세요");
			return "redirect:/session/loginPage";
		}		
	}
	
	// 8. 로그 아웃
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user_id"); // 특정 세션 삭제
		session.invalidate(); // 전체 세션 삭제
		return "redirect:/session/mainPage";
	}
	
}
