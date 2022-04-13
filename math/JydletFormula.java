package jydlet.math;

import jydlet.JydletException;

import java.util.Queue;
import java.util.LinkedList;

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

	static boolean isZero(Vector vector) {
		for(int i = 0; i < vector.length; i++) {
			if(vector.vector[i] != 0) {
				return false;
			}
		}

		return true;
	}

	static Matrix submatrix(Matrix matrix, int rowS, int columnS, int rowE, int columnE) {
		Matrix result = new Matrix(rowE - rowS + 1, columnE - columnS + 1);

		Queue<Double> numbers = new LinkedList<>();

		for(int i = rowS; i < rowE + 1; i++) {
			for(int j = columnS; j < columnE + 1; j++) {
				numbers.add(matrix.matrix[i][j]);
			}
		}

		for(int i = 0; i < result.rows; i++) {
			for(int j = 0; j < result.columns; j++) {
				result.matrix[i][j] = numbers.remove();
			}
		}

		result.full = true;

		return result;
	}

	static Matrix submatrix(Matrix matrix, int rowS, int columnS, int rank) {
		Matrix result = new Matrix(rank, rank);
		
		Queue<Double> numbers = new LinkedList<>();

		for(int i = rowS; i < rowS + rank; i++) {
			for(int j = columnS; j < columnS + rank; j++) {
				numbers.add(matrix.matrix[i][j]);
			}
		}

		for(int i = 0; i < result.rows; i++) {
			for(int j = 0; j < result.columns; j++) {
				result.matrix[i][j] = numbers.remove();
			}
		}

		result.full = true;

		return result;
	}

	static Matrix setSmatrix(Matrix matrix, Matrix submatrix, int rowS, int columnS, int rank) {
		Matrix result = new Matrix(matrix.rows, matrix.columns);

		for(int i = 0; i < result.rows; i++) {
			for(int j = 0; j < result.columns; j++) {
				result.matrix[i][j] = matrix.matrix[i][j];
			}
		}

		result.full = true;

		for(int i = rowS; i < rowS + rank; i++) {
			for(int j = columnS; j < columnS + rank; j++) {
				result.matrix[i][j] = submatrix.matrix[i][j];
			}
		}

		return result;
	}
}