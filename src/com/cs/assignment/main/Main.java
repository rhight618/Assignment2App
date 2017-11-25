package com.cs.assignment.main;

public class Main {

	public static void main(String[] args) {
		
		float xx = Float.parseFloat(args[0]);
		float yy = Float.parseFloat(args[1]);
		
		System.out.println(Evaluator.getResultString(xx, yy));	
	}

}
