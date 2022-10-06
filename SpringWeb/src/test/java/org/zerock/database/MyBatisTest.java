package org.zerock.database;


import java.util.ArrayList;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.board.command.BoardVO;
import org.zerock.testmapper.TestMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MyBatisTest {

	@Autowired
	private SqlSessionFactoryBean session;
	// private SqlSessionFactory session;
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private TestMapper mapper;	// sql테스트용...
	
	@Test
	public void testFactory() {
		try {
			System.out.println("주입성공? >>>>>"+ session);
			System.out.println("-----------------------");
			System.out.println("주입성공? >>>>>" + dataSource);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testSelect() {
		
		ArrayList<BoardVO> list = mapper.testSelect();
		for(BoardVO vo : list) {
			System.out.println(vo.getBno());			
			System.out.println(vo.getTitle());
			System.out.println(vo.getWriter());
			System.out.println(vo.getContent());
			System.out.println(vo.getRegdate());
			System.out.println(vo.getUpdatedate());
			System.out.println("--------------------");
		}
	}
	
}
