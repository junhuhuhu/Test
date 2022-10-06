package org.zerock.member.mapper;

import org.zerock.member.command.MemberVO;

public interface MemberMapper {
	
	public int join(MemberVO vo); // 회원 가입
	public int login(MemberVO vo);	// 로그인 처리
	public int idCheck(String id); //  아이디 체크
	
}
