package org.zerock.member.service;

import org.zerock.member.command.MemberVO;

public interface MemberService {
	
	public int join(MemberVO vo); // 회원 가입
	public int login(MemberVO vo);	// 로그인
	public int idCheck(String id);	// id체크
	

}
