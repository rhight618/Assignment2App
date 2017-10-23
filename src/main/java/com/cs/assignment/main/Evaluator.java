package com.cs.assignment.main;

public class Evaluator {
	
	public static boolean isXGreaterThanOrEqualToY(int x, int y){
		
		if(x >= y){
			return true;
		}else{
			return false;
		}
	}
	
	public static String getResultString(int x, int y){
		
		if(isXGreaterThanOrEqualToY(x,y)){
			return "x = " + x + " is greater than or equal to y = " + y;
		}else{
			return "y = " + y + " is greater than x = " + x;
		}
	}

}
