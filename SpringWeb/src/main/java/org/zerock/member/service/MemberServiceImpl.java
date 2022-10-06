package org.zerock.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.member.command.MemberVO;
import org.zerock.member.mapper.MemberMapper;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	
	// 마이바티스의 인터페이스
	@Autowired
	private MemberMapper mapper;
	
	/*
	 * 1. 설정을 확인하자
	 * 2. 마이바티스 구현체 xml을 구성하기
	 * 
	 */
	
	@Override
	public int join(MemberVO vo) {
		int result = mapper.join(vo);
		System.out.println("성공? 실패? : " + result);
		
		return result;
	}
	
	@Override
	public int login(MemberVO vo) {
		int result = mapper.login(vo);
		System.out.println("성공? 실패? : " + result);
		
		return result;
	}
	
	@Override
	public int idCheck(String id) {
		int result = mapper.idCheck(id);
		System.out.println("아이디 갯수" + result);
		
		return result;
	}

}
