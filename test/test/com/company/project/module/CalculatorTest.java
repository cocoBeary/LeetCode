package com.company.project.module;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {
	@BeforeClass
	public static void beforeClass() throws Exception {
		System.out.println("before Class method");
	}
	
	@Before
	public void before() throws Exception {
		System.out.println("before method");
	}
	
	@Test(timeout=100)
	public void testAdd() throws Exception {
		Thread.sleep(5);
		assertEquals(3, new Calculator().add(1, 2));
	}
	@Test(expected = Exception.class)
	public void testAdd2() {
		new Calculator().sub(1, 2);
	}
}
