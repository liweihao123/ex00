package org.zeorck.sample;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {
	
	@Test
	public void testSum() {
		Calculator cal = new Calculator();
		assertEquals(30,cal.sum(20,10));
		System.out.println("test1");
		
	}
	@Test
	public void testSum1() {
		Calculator cal = new Calculator();
		assertEquals(60, cal.sum(50,10));
		System.out.println("test2");
	}
	@BeforeClass //클래스 제일 앞
	public static void beforeTest() {
		System.out.println("BeforeClass");
	}
	@AfterClass //클래스 제일 뒤 
	public static void afterTest() {
		System.out.println("AfterClass");
	}
	@Before //매 test가 호출 되기전
	public void setUp() {
		System.out.println("Before setUp");
	}
	@After //매 test가 호출 된 이후
	public void tearDown() {
		System.out.println("after tearDown");
	}
	

}
