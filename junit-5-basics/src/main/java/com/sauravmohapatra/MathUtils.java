package com.sauravmohapatra;

public class MathUtils {
	
	public int add(int a,int b) {
		return (a + b);
	}
	
	public int subtract(int a,int b) {
		return (a - b);
	}
	
	public int multiply(int a,int b) {
		return (a * b);
	}
	
	public int divide(int a,int b) {
		return (a / b);
	}
	
	public double computeCircleArea(double radius) {
		double area = Math.PI*radius*radius;
		return area;
	}

}
