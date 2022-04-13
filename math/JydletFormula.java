package jydlet.math;

import jydlet.JydletException;

/*
	this is where we do private math work (Cannot be access by the user)
	this is hidden work of math
*/

public class JydletFormula {
	static boolean isUpperTriangle(Matrix matrix) {
		if(matrix.rows != matrix.columns) {
			return false;
		}

		for(int i = 0; i < matrix.rows; i++) {
			for(int j = 0; j < matrix.columns; j++) {
				if(j < i && matrix.matrix[i][j] != 0) {
					return false;
				}
			}
		}

		return true;
	}

	static boolean isLowerTriangle(Matrix matrix) {
		if(matrix.rows != matrix.columns) {
			return false;
		}

		for(int i = 0; i < matrix.rows; i++) {
			for(int j = 0; j < matrix.columns; j++) {
				if(j > i && matrix.matrix[i][j] != 0) {
					return false;
				}
			}
		}

		return true;
	}

	static boolean isEchelonForm(Matrix matrix) {
		int count = 0;

		for(int i = 0; i < matrix.rows; i++) {
			for(int j = 0; j < matrix.columns; j++) {
				if(matrix.matrix[i][j] == 0) {
					count++;
				} else {
					break;
				}
			}

			if(count < i) {
				return false;
			}

			count = 0;
		}

		return true;
	}

	static Matrix rrc(Matrix matrix, int row, int column) {
		Matrix result = new Matrix(matrix.rows - 1, matrix.columns - 1);

		int k = 0;
		int l = 0;

		for(int i = 0; i < matrix.rows; i++) {
			if(i == row) {
				continue;
			}

			for(int j = 0; j < matrix.columns; j++) {
				if(j == column) {
					continue;
				}

				result.matrix[l][k] = matrix.matrix[i][j];
				k = (k + 1) % (matrix.rows - 1);
				if(k == 0) {
					l++;
				}
			}
		}

		result.full = true;

		return result;
	}
}