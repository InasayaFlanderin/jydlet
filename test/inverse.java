package jydlet.test;

import jydlet.math.Matrix;
import jydlet.math.JydletMath;

public class inverse {
	public static void main(String[] args) {
		double[][] am = {{8,6,7},{5,3,4},{9,1,2}};
		double[][] bm = {{1,2,3},{4,5,6},{7,8,9}};
		double[][] cm = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};

		Matrix a = Matrix.create(am);
		Matrix b = Matrix.create(bm);
		Matrix c = Matrix.create(cm);

		System.out.println(JydletMath.inverse(a).toString());
		System.out.println(JydletMath.inverse(b).toString());
		System.out.println(JydletMath.inverse(c).toString());
	}
}