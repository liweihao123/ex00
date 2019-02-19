package org.zeorck.sample;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class HotelT {
	private static final Logger log = LoggerFactory.getLogger(HotelT.class);
	@Autowired
	private Hotel ho;
	
	@Test
	public void testExist() {
		assertNotNull(ho);
		log.info(ho+"");
		log.info("----------------");
		log.info(ho.getChef()+"");
	}

}
