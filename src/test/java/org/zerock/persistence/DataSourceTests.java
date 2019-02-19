package org.zerock.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml") //이 JDBCTest 대신에 root-context.xml 에 하면 그냥 이렇게 가능한다
//java 설정을 사용하는 경우
//@ContextConfiguration(classes = {RootConfig.class})
@Log4j
public class DataSourceTests {
	@Setter(onMethod_= {@Autowired})
	private DataSource dataSource;
	@Setter(onMethod_= {@Autowired})
	private SqlSessionFactory sqlSessionFactory;
	
	@Test //mybats 등록하는 테스트
	public void testMyBatis() {
		try(
				SqlSession session = sqlSessionFactory.openSession();
				Connection con = session.getConnection();
				)
		{
			log.info(session);
			log.info(con);
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testConnection() {
		try {
			Connection con = dataSource.getConnection();
			log.info(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
	}

}
