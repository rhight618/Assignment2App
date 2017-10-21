package com.cs.assignment.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cs.assignment.main.Evaluator;
import com.cs.assignment.main.Main;

public class EvaluatorTest {

	@Test
	public void testXGreaterThanOrEqualToY() {
		
		System.out.println("Running Test: testXGreaterThanOrEqualToY");
		int x = 4;
		int y = 2;
		
		boolean isXGreaterThanOrEqualToY = Evaluator.isXGreaterThanOrEqualToY(x, y);
		assertTrue(isXGreaterThanOrEqualToY);
	}
	
	@Test
	public void testGetXGreaterThanOrEqualToYString() {
		
		System.out.println("Running Test: testGetXGreaterThanOrEqualToYString");
		int x = 4;
		int y = 2;
		
		assertEquals(Evaluator.getResultString(x, y), "x is greater than or equal to y");
	}
	
	@Test
	public void testYGreaterThanX() {
		
		System.out.println("Running Test: testYGreaterThanX");
		int x = 2;
		int y = 4;
		
		boolean isXGreaterThanOrEqualToY = Evaluator.isXGreaterThanOrEqualToY(x, y);
		assertFalse(isXGreaterThanOrEqualToY);
	}
	
	@Test
	public void testYGreaterThanXString() {
		
		System.out.println("Running Test: testYGreaterThanXString");
		int x = 2;
		int y = 4;

		assertEquals(Evaluator.getResultString(x, y), "y is greater than x");
	}
	
	@Test
	public void testMain(){
		
		System.out.println("Running Test: testMain");
		Main.main((new String[] {"3", "2"}));
	}

}
