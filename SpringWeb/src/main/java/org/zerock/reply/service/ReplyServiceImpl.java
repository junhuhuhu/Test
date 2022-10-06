package org.zerock.reply.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.board.command.Criteria;
import org.zerock.reply.command.ReplyPageVO;
import org.zerock.reply.command.ReplyVO;
import org.zerock.reply.mapper.ReplyMapper;

import lombok.Setter;
//import lombok.extern.log4j.Log4j;

@Service
//@Log4j
public class ReplyServiceImpl implements ReplyService {

	@Setter(onMethod_ = {@Autowired})
	private ReplyMapper mapper;
	
	@Override
	public int register(ReplyVO vo) {
		System.out.println("register......"+vo);
		return mapper.insert(vo);
	}

	@Override
	public ReplyVO get(int rno) {
		System.out.println("get........."+rno);
		return mapper.read(rno);
	}

	@Override
	public int modify(ReplyVO vo) {
		System.out.println("modify.........."+vo);
		return mapper.update(vo);
	}

	@Override
	public int remove(int rno) {
		System.out.println("remove........."+rno);
		return mapper.delete(rno);
	}

	@Override
	public List<ReplyVO> getList(Criteria cri, int bno) {
		System.out.println("get Reply List of a Board "+bno);
		return mapper.getListWithPaging(cri, bno);
	}
	
	@Override
	public ReplyPageVO getListPage(Criteria cri, int bno) {
		
		return new ReplyPageVO(mapper.getCountByBno(bno),
							   mapper.getListWithPaging(cri, bno));
	}

}
