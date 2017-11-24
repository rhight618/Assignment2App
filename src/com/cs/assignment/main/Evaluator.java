package com.cs.assignment.main;

public class Evaluator {
	
	public static boolean isXGreaterThanOrEqualToY(float x, float y){
		
		boolean isTrue = true;
		
		if(x > y){
			isTrue = true;
		}else{
			isTrue = false;
		}
		
		return isTrue;
	}
	
	public static boolean isXGreaterThanY(float x, float y){
		
		Boolean isTrue = null;
		
		if(x > y){
			isTrue = true;
			return isTrue.booleanValue();
		}else{
			isTrue = false;
			return isTrue.booleanValue();
		}
		
	}
	
	
	
	
	public static String getResultString(float x, float y){
		
		if(isXGreaterThanOrEqualToY(x,y)){
			return "x = " + x + " is greater than or equal to y = " + y;
		}else{
			return "y = " + y + " is greater than x = " + x;
		}
	}

}
