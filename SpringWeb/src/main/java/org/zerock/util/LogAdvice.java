package org.zerock.util;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component	// bean 자동 생성 어노테이션
@Aspect	// Aspect클래스를 의미하는 어노테이션
public class LogAdvice {
	
	// 해당 기능은 로그를 출력할수 있는 기능
	// log4j.xml에 레벨 설정해야 합니다.
	// <logger name="org.zerock.util">
	// <level value="info" />
	// </logger>
	
	private static final Logger logger = LoggerFactory.getLogger(LogAdvice.class);
	
	// 맨앞 * 는 접근제한자를 의미함. 맨뒤에 *은 메서드를 의미함
//	@Before("execution(* org.zerock.board.service.BoardServiceImpl*.*(..))")
//	@Before("execution(* org.zerock.controller.*Controller*.*(..))")
//	public void beforeLog() {
//		logger.info("----- Before -----");
//		System.out.println("@Before 어노테이션 동작");
//		
//	}
//	
//	@After("execution(* org.zerock.board.service.BoardServiceImpl.*(..))")
//	public void afterLog() {
//		logger.info("----- After -----");
//		logger.info("----- BoardServiceImpl 동작 후 처리 -----");
//	}
	
	// 권한을 가지고 실행 전, 실행 후 처리가 가능
	// @Around가 적용되는 메서드(어드바이스)는 반드시 리턴이 있어야 합니다
	@Around("execution(* org.zerock.board.service.BoardServiceImpl.*(..))")
	public Object aroundLog(ProceedingJoinPoint jp) {
		long start = System.currentTimeMillis();
		
		// 해당 기능을 통해서 메서드 실행전 결과를 확인할 수 있어요!
		System.out.println("적용 클래스 : " + jp.getTarget());
		System.out.println("적용 파라미터 : " + Arrays.toString(jp.getArgs()));
		
		Object result = null;
		
		try {
			// proceed()는 타겟 메서드를 지칭한다, 해당 메서드를 실행시켜야
			// 타겟이 되는 메서드가 실행됩니다.
			// 해당 메서드를 만나기 전까지 Before어드바이스가 실행된다.
			result = jp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println("메서드 수행에 걸리 시간 : " + (end-start));
		
		return result;
	}
	
	// 해당 어노테이션 예외가 발생하면 동작합니다
	// pointcut - 어떤 메서드에 적용할 것이냐...
	// throwing - 처리할 에러 변수
	@AfterThrowing(pointcut="execution(* org.zerock.member.service.memberService*.*(..))", throwing = "e")
	public void erroeLog(Exception e) {
		logger.info("에러가 뭔가요? " + e);
	}

}
