package jydlet.test;

import jydlet.math.*;

public class dotproduct {
	public static void main(String[] args) {
		Matrix a = new Matrix(3,4,true);
		Matrix b = new Matrix(4,5,true);

		for(int i = 0; i < a.rows; i++) {
			for(int j = 0; j < a.columns; j++) {
				a.matrix[i][j] = i*j;
			}
		}

		for(int i = 0; i < b.rows; i++) {
			for(int j = 0; j < b.columns; j++) {
				b.matrix[i][j] = 20 - i*j;
			}
		}


		Matrix c = JydletMath.multiplication(a,b);

		System.out.println(a.toString());
		System.out.println(b.toString());
		System.out.println(c.toString());
	}
}