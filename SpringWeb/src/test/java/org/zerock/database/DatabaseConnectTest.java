package org.zerock.database;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class DatabaseConnectTest {

	@Autowired
	private DataSource dataSource;
	
	@Test
	public void testConnect() {
		try {
			Connection conn = dataSource.getConnection();
			System.out.println("연결 성공");
		} catch (Exception e) {
			System.out.println("연결 실패");
			e.printStackTrace();
		}
	}
	
}
