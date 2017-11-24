package com.cs.assignment.test;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import com.cs.assignment.main.Evaluator;
import com.cs.assignment.main.Main;

@Ignore
public class EvaluatorTest {

	@Ignore
	@Test
	public void testXGreaterThanOrEqualToY() {
		
		System.out.println("Running Test: testXGreaterThanOrEqualToY");
		int x = 4;
		int y = 2;
		
		boolean isXGreaterThanOrEqualToY = Evaluator.isXGreaterThanOrEqualToY(x, y);
		assertTrue(isXGreaterThanOrEqualToY);
	}
	
	@Ignore
	@Test
	public void testYGreaterThanX() {
		
		System.out.println("Running Test: testYGreaterThanX");
		int x = 2;
		int y = 4;
		
		boolean isXGreaterThanOrEqualToY = Evaluator.isXGreaterThanOrEqualToY(x, y);
		assertFalse(isXGreaterThanOrEqualToY);
	}
	
	
	@Test
	public void testMainXgtY(){
		
		System.out.println("Running Test: testMainXgtY");
		System.out.println("Inputs: x=3,y=2");
		Main.main((new String[] {"3", "2"}));
	}
	
	@Test
	public void testMainYgtX(){
		
		System.out.println("Running Test: testMainXgtY");
		System.out.println("Inputs: x=2,y=3");
		Main.main((new String[] {"2", "3"}));
	}

}
