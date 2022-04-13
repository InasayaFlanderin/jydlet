package jydlet.test;

import jydlet.math.JydletMath;
import jydlet.math.Matrix;
import java.util.Arrays;

public class adjoint {
	public static void main(String[] args) {
		double[][] a = {{8,5,1},{3,6,7},{5,6,6}};
		Matrix am = Matrix.create(a);

		System.out.println(Arrays.deepToString(am.matrix));

		System.out.println(Arrays.deepToString(JydletMath.adjoint(am).matrix));
	}
}