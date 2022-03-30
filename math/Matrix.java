package jydlet.math;

import jydlet.TransposeException;

import java.util.Arrays;

public class Matrix {
	public double[][] matrix;
	public int rows;
	public int columns;
	public boolean full;

	public Matrix(int rows, int columns, boolean full) {
		this.matrix = new double[rows][columns];
		this.rows = rows;
		this.columns = columns;
		this.full = full;

		if(this.full == true) {
			fill();
		}
	}

	public Matrix(int rows, int columns) {
		this.matrix = new double[rows][columns];
		this.rows = rows;
		this.columns = columns;
		this.full = false;
	}

	public Matrix tranpose(Matrix matrix) {
		if(matrix.full == false) {
			throw new TransposeException();
		}

		Matrix result = new Matrix(matrix.columns, matrix.rows);
		result.full = true;

		for(int i = 0; i < matrix.rows; i++) {
			for(int j = 0; j < matrix.columns; j++) {
				result.matrix[j][i] = matrix.matrix[i][j];
			}
		}

		return result;
	}

	public void fill() {
		for(int i = 0; i < this.rows; i++) {
			for(int j = 0; j < this.columns; j++) {
				this.matrix[i][j] = Math.random() * 2 - 1;
			}
		}

		this.full = true;
	}

	public void makeZeros() {
		for(int i = 0; i < this.rows; i++) {
			for(int j = 0; j < this.columns; j++) {
				this.matrix[i][j] = 0;
			}
		}

		this.full = true;
	}

	public void makeOnes() {
		for(int i = 0; i < this.rows; i++) {
			for(int j = 0; j < this.columns; j++) {
				this.matrix[i][j] = 1;
			}
		}

		this.full = true;
	}

	public Matrix create(double[][] array) {
		Matrix result = new Matrix(array.length, array[0].length);
		result.full = true;

		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[0].length; j++) {
				result.matrix[i][j] = array[i][j];
			}
		}

		return result;
	}

	public String toString() {
		return Arrays.deepToString(this.matrix);
	}
}