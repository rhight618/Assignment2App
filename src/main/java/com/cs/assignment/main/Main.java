package com.cs.assignment.main;

public class Main {

	public static void main(String[] args) {
		int x = Integer.parseInt(args[0]);
		int y = Integer.parseInt(args[1]);
		
		System.out.println(Evaluator.getResultString(x, y));	
	}

}
