package org.zerock.board.command;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardVO {
	
	private int bno;
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	private Date updatedate;
	
//	public BoardVO() {}
//
//	public BoardVO(int bno, String title, String content, String writer, Date regdate, Date updatedate) {
//		super();
//		this.bno = bno;
//		this.title = title;
//		this.content = content;
//		this.writer = writer;
//		this.regdate = regdate;
//		this.updatedate = updatedate;
//	}
//
//	public int getBno() {
//		return bno;
//	}
//
//	public void setBno(int bno) {
//		this.bno = bno;
//	}
//
//	public String getTitle() {
//		return title;
//	}
//
//	public void setTitle(String title) {
//		this.title = title;
//	}
//
//	public String getContent() {
//		return content;
//	}
//
//	public void setContent(String content) {
//		this.content = content;
//	}
//
//	public String getWriter() {
//		return writer;
//	}
//
//	public void setWriter(String writer) {
//		this.writer = writer;
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
//	public Date getUpdatedate() {
//		return updatedate;
//	}
//
//	public void setUpdatedate(Date updatedate) {
//		this.updatedate = updatedate;
//	}
//
//	
}
