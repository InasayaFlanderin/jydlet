package jydlet.math;

import jydlet.ShapeMismatchException;

public class JydletMath {
	public Matrix addition(Matrix matrix, Matrix smatrix) {
		if(matrix.full == false || smatrix.full == false) {
			throw new Exception("Empty matrix");
		}

		if(matrix.rows != smatrix.rows || matrix.columns != smatrix.columns) {
			throw new ShapeMismatchException("Shape (" + matrix.rows + "," + matrix.columns + ") is not match with shape (" + smatrix.rows + "," + smatrix.columns + ")!");
		}

		Matrix result = new Matrix(matrix.rows, matrix.columns);

		for(int i = 0; i < result.rows; i++) {
			for(int j = 0; j < result.columns; j++) {
				result.matrix[i][j] = matrix.matrix[i][j] + smatrix.matrix[i][j];
			}
		}

		result.full = true;

		return result;
	}

	public Matrix addition(Matrix matrix, Vector vector) {
		if(matrix.full == false || vector.full == false) {
			throw new Exception("Empty matrix or vector");
		}

		if(vector.horizontal == true && matrix.rows != vector.length) {
			throw new ShapeMismatchException("Matrix shape (" + matrix.rows + "," + matrix.columns + ") is not match horizontal vector shape (" + vector.length + ",)!");
		}

		if(vector.horizontal == false && matrix.columns != vector.length) {
			throw new ShapeMismatchException("Matrix shape (" + matrix.rows + "," + matrix.columns + ") is not match vertical vector shape (," + vector.length + ")!");
		}

		Matrix result;

		if(vector.horizontal == true) {
			result = new Matrix(matrix.rows, matrix.columns);

			for(int i = 0; i < result.rows; i++) {
				for(int j = 0; j < result.columns; j++) {
					result.matrix[i][j] = matrix.matrix[i][j] + vector.vector[j];
				}
			}

			result.full = true;
		} else {
			result = new Matrix(matrix.rows, matrix.columns);

			for(int i = 0; i < result.rows; i++) {
				for(int j = 0; j < result.columns; j++) {
					result.matrix[i][j] = matrix.matrix[i][j] + vector.vector[i];
				}
			}

			result.full = true;
		}

		return result;
	}

	public Matrix addition(Vector vector, Matrix matrix) {
		return addition(matrix, vector);
	}

	public Vector addition(Vector vector, Vector svector) {
		if(vector.full == false || svector.full == false) {
			throw new Exception("Empty vector");
		}

		if(vector.length != svector.length) {
			throw new ShapeMismatchException("Shape (" + vector.length + ") is mismatch shape (" + svector.length + ")");
		}

		if(!(vector.horizontal == svector.horizontal)) {
			throw new Exception("Cant defined if targetted vector is horizontal or vertical");
		}

		Vector result = new Vector(vector.length, vector.horizontal);

		for(int i = 0 ; i < result.length; i++) {
			result.vector[i] = vector.vector[i] + svector.vector[i];
		}

		result.full = true;

		return result;
	}

	public Matrix subtraction(Matrix matrix, Matrix smatrix) {
		if(matrix.full == false || smatrix.full == false) {
			throw new Exception("Empty matrix");
		}

		if(matrix.rows != smatrix.rows || matrix.columns != smatrix.columns) {
			throw new ShapeMismatchException("Shape (" + matrix.rows + "," + matrix.columns + ") is not match with shape (" + smatrix.rows + "," + smatrix.columns + ")!");
		}

		Matrix result = new Matrix(matrix.rows, matrix.columns);

		for(int i = 0; i < result.rows; i++) {
			for(int j = 0; j < result.columns; j++) {
				result.matrix[i][j] = matrix.matrix[i][j] - smatrix.matrix[i][j];
			}
		}

		result.full = true;

		return result;
	}

	public Matrix subtraction(Matrix matrix, Vector vector) {
		if(matrix.full == false || vector.full == false) {
			throw new Exception("Empty matrix or vector");
		}

		if(vector.horizontal == true && matrix.rows != vector.length) {
			throw new ShapeMismatchException("Matrix shape (" + matrix.rows + "," + matrix.columns + ") is not match horizontal vector shape (" + vector.length + ",)!");
		}

		if(vector.horizontal == false && matrix.columns != vector.length) {
			throw new ShapeMismatchException("Matrix shape (" + matrix.rows + "," + matrix.columns + ") is not match vertical vector shape (," + vector.length + ")!");
		}

		Matrix result;

		if(vector.horizontal == true) {
			result = new Matrix(matrix.rows, matrix.columns);

			for(int i = 0; i < result.rows; i++) {
				for(int j = 0; j < result.columns; j++) {
					result.matrix[i][j] = matrix.matrix[i][j] - vector.vector[j];
				}
			}

			result.full = true;
		} else {
			result = new Matrix(matrix.rows, matrix.columns);

			for(int i = 0; i < result.rows; i++) {
				for(int j = 0; j < result.columns; j++) {
					result.matrix[i][j] = matrix.matrix[i][j] - vector.vector[i];
				}
			}

			result.full = true;
		}

		return result;
	}

	public Vector subtraction(Vector vector, Vector svector) {
		if(vector.full == false || svector.full == false) {
			throw new Exception("Empty vector");
		}

		if(vector.length != svector.length) {
			throw new ShapeMismatchException("Shape (" + vector.length + ") is mismatch shape (" + svector.length + ")");
		}

		if(!(vector.horizontal == svector.horizontal)) {
			throw new Exception("Cant defined if targetted vector is horizontal or vertical");
		}

		Vector result = new Vector(vector.length, vector.horizontal);

		for(int i = 0 ; i < result.length; i++) {
			result.vector[i] = vector.vector[i] - svector.vector[i];
		}

		result.full = true;

		return result;
	}

	public Matrix multiplication(Matrix matrix, Matrix smatrix) {
		if(matrix.full == false || smatrix.full == false) {
			throw new Exception("Empty matrix");
		}

		if(matrix.columns != smatrix.rows) {
			throw new Exception("Shape (" + matrix.rows + "," + matrix.columns +") is not match shape (" + smatrix.rows + "," + smatrix.columns + ")!");
		}

		Matrix result = new Matrix(matrix.columns, smatrix.rows);
		result.makeZeros();

		for(int i = 0; i < result.rows; i++) {
			for(int j = 0; j < result.columns; j++) {
				for(int k = 0; k < matrix.columns; k++) {
					result.matrix[i][j] += matrix.matrix[i][k] * smatrix.matrix[k][j];
				}
			}
		}

		return result;
	}
}