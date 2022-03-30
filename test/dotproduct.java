package jydlet.test;

import jydlet.math.*;

public class dotproduct {
	public static void main(String[] args) {
		Matrix a = new Matrix(3,4,true);
		Matrix b = new Matrix(4,5,true);
		Matrix c = JydletMath.multiplication(a,b);

		System.out.println(a.toString());
		System.out.println(b.toString());
		System.out.println(c.toString());
	}
}