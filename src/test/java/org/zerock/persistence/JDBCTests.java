package org.zerock.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;


import lombok.extern.log4j.Log4j;



@Log4j
public class JDBCTests {//이 작업을 root-context.xml 에 하면 그냥 DataSourceTests 만 있으면된다
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	@Test
	public void testConnection() {
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:XE","spring","spring");
				log.info(con);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
	}

}
