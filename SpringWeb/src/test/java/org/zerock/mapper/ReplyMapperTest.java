package org.zerock.mapper;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.board.command.Criteria;
import org.zerock.reply.command.ReplyVO;
import org.zerock.reply.mapper.ReplyMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyMapperTest {
	
	// 테스트하기 전에 해당 번호로 게시물이 존재하는지 여부를 확인해야 한다
	private int[] bnoArr = {13, 14, 15, 16, 17};
	
	@Setter(onMethod_ = @Autowired)
	private ReplyMapper mapper;
	
	@Test
	public void testCreate() {
		
		IntStream.range(1, 11).forEach(i -> {
			ReplyVO vo = new ReplyVO();
			// 게시물 번호
			vo.setBno(bnoArr[i%5]);
			vo.setReply("댓글 테스트" + i);
			vo.setReplyer("replyer" + i);
			mapper.insert(vo);
		}); 
		
	}
	
	@Test
	public void testRead() {
		
		int targetRno = 5;
		ReplyVO vo = mapper.read(targetRno);
		log.info(vo);
	}
	
	@Test
	public void testDelete() {
		int targetRno = 5;
		int result = mapper.delete(targetRno);
		log.info(result);
	}
	
	@Test
	public void testUpdate() {
		int targetRno = 8;
		ReplyVO vo = mapper.read(targetRno);
		vo.setReply("update Reply");
		int count = mapper.update(vo);
		log.info("UPDATE COUNT : " + count);
	}
	
	@Test
	public void testMapper() {
		log.info(mapper);
	}
	
	@Test
	public void testList() {
		Criteria cri = new Criteria(2, 10);
		// 게시물 129
		List<ReplyVO> replies = mapper.getListWithPaging(cri, 129);
		replies.forEach(reply -> log.info(reply));
	}

}
