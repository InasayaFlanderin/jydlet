package jydlet.test;

import jydlet.math.Matrix;
import jydlet.math.JydletFormula;

public class triangle {
	public static void main(String[] args) {
		double[][] a = {
					{1,0,0,0},
					{1,2,0,0},
					{1,2,3,0},
					{1,2,3,4}
						};
		double[][] b = {
					{4,3,2,1},
					{0,3,2,1},
					{0,0,2,1},
					{0,0,0,1},
						};
		double[][] c = {
					{0,1,2,3},
					{1,0,2,3},
					{1,2,0,3},
					{1,2,3,0}
						};

		Matrix am = Matrix.create(a);
		Matrix bm = Matrix.create(b);
		Matrix cm = Matrix.create(c);
		Matrix dm = new Matrix(4, 4, true);

		//System.out.printf("am : %b \n bm : %b \n cm : %b dm : %b", JydletFormula.isLowerTriangle(am), JydletFormula.isUpperTriangle(bm), Matrix.isTriangle(cm), Matrix.isTriangle(dm));
	}
}