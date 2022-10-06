package org.zerock.reply.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zerock.board.command.Criteria;
import org.zerock.reply.command.ReplyVO;

public interface ReplyMapper {
	
	public int insert(ReplyVO vo);
	public ReplyVO read(int rno);
	public int delete(int rno);
	public int update(ReplyVO reply);
	public List<ReplyVO> getListWithPaging(
			@Param("cri") Criteria cri,
			@Param("bno") int bno);
	public int getCountByBno(int bno); // 게시글 댓글의 총 갯수
}
