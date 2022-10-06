package org.zerock.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	
	
	// 1. Spring에서 제공하는 HandlerInterceptorAdapter 클래스를 상속받습니다.
	// 2. alt + shift + s -> overriding method를 통해서 3가지 메서드를
	
	// preHandle 메서드는 컨트롤러를 실행하기 전 요청을 가로채서 처리
	// 일반적으로 로그인 , 세션 처리에 사용
	// preHandle에 세션처리를 했다면, 스프링 설정 파일에 <interceptor> 태그를 사용하여
	// 매핑을 설정합니다.
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("user_id");
		if(user_id == null) {
			response.sendRedirect("/MyWeb/session/loginPage");
			return false;
			// return이 false이면 핸들러메서드를 실행후에 Controller를 수행하지 않음
			
		} else {
			return true;
			// return이 true이면 핸들러메서드를 실행후에 Controller를 수행
		}
	
	}


}
