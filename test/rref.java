package jydlet.test;

import jydlet.math.Matrix;
import jydlet.math.JydletMath;

import java.util.Arrays;

public class rref {
	public static void main(String[] args) {
		double[][] a = {{1,2,3},{4,5,6},{7,8,9}};

		Matrix am = Matrix.create(a);
		Matrix bm = new Matrix(4, 4, true);

		System.out.println(Arrays.deepToString(JydletMath.rref(am).matrix));
		System.out.println(Arrays.deepToString(JydletMath.rref(bm).matrix));
	}
}