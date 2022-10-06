package org.zerock.member.command;

import java.util.Date;

import lombok.Data;

@Data
public class MemberVO {
	
	private String id;
	private String pw;
	private String name;
	private Date regdate;
	
//	public MemberVO() {}
//
//	public MemberVO(String id, String pw, String name, Date regdate) {
//		super();
//		this.id = id;
//		this.pw = pw;
//		this.name = name;
//		this.regdate = regdate;
//	}
//
//	public String getId() {
//		return id;
//	}
//
//	public void setId(String id) {
//		this.id = id;
//	}
//
//	public String getPw() {
//		return pw;
//	}
//
//	public void setPw(String pw) {
//		this.pw = pw;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public Date getRegdate() {
//		return regdate;
//	}
//
//	public void setRegdate(Date regdate) {
//		this.regdate = regdate;
//	}
//	
//	
}
