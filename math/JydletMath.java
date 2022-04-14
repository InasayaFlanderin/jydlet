package jydlet.math;

import jydlet.ShapeMismatchException;
import jydlet.EmptyException;
import jydlet.JydletException;
import jydlet.math.Matrix;


/*
JydletMath is where we get rid of formula
Use to stored all math performing of the deeplearning library
*/

public class JydletMath {
	public static Matrix addition(Matrix matrix, Matrix smatrix) {
		if(matrix.full == false || smatrix.full == false) {
			throw new EmptyException("Empty matrix");
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

	/*
		this is prefix to get Weight + bias
	*/

	public static Matrix addition(Matrix matrix, Vector vector) {
		if(matrix.full == false || vector.full == false) {
			throw new EmptyException("Empty matrix or vector");
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

	public static Matrix addition(Vector vector, Matrix matrix) {
		return addition(matrix, vector);
	}

	public static Vector addition(Vector vector, Vector svector) {
		if(vector.full == false || svector.full == false) {
			throw new EmptyException("Empty vector");
		}

		if(vector.length != svector.length) {
			throw new ShapeMismatchException("Shape (" + vector.length + ") is mismatch shape (" + svector.length + ")");
		}

		if(!(vector.horizontal == svector.horizontal)) {
			throw new JydletException("Cant defined if targetted vector is horizontal or vertical");
		}

		Vector result = new Vector(vector.length, vector.horizontal);

		for(int i = 0 ; i < result.length; i++) {
			result.vector[i] = vector.vector[i] + svector.vector[i];
		}

		result.full = true;

		return result;
	}

	public static Matrix subtraction(Matrix matrix, Matrix smatrix) {
		if(matrix.full == false || smatrix.full == false) {
			throw new EmptyException("Empty matrix");
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

	//same as addition

	public static Matrix subtraction(Matrix matrix, Vector vector) {
		if(matrix.full == false || vector.full == false) {
			throw new EmptyException("Empty matrix or vector");
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

	public static Vector subtraction(Vector vector, Vector svector) {
		if(vector.full == false || svector.full == false) {
			throw new EmptyException("Empty vector");
		}

		if(vector.length != svector.length) {
			throw new ShapeMismatchException("Shape (" + vector.length + ") is mismatch shape (" + svector.length + ")");
		}

		if(!(vector.horizontal == svector.horizontal)) {
			throw new JydletException("Cant defined if targetted vector is horizontal or vertical");
		}

		Vector result = new Vector(vector.length, vector.horizontal);

		for(int i = 0 ; i < result.length; i++) {
			result.vector[i] = vector.vector[i] - svector.vector[i];
		}

		result.full = true;

		return result;
	}

	//dot product

	public static Matrix multiplication(Matrix matrix, Matrix smatrix) {
		if(matrix.full == false || smatrix.full == false) {
			throw new EmptyException("Empty matrix");
		}

		if(matrix.columns != smatrix.rows) {
			throw new ShapeMismatchException("Shape (" + matrix.rows + "," + matrix.columns +") is not match shape (" + smatrix.rows + "," + smatrix.columns + ")!");
		}

		Matrix result = new Matrix(matrix.rows, smatrix.columns);
		result.makeZeros();

		for(int i = 0; i < result.rows; i++) {
			for(int j = 0; j < result.columns; j++) {
				for(int k = 0; k < smatrix.rows; k++) {
					result.matrix[i][j] += matrix.matrix[i][k] * smatrix.matrix[k][j];
				}
			}
		}

		result.full = true;

		return result;
	}

	public static Matrix multiplication(Matrix matrix, double scalar) {
		if(matrix.full == false) {
			throw new EmptyException("Empty matrix");
		}

		Matrix result = new Matrix(matrix.rows, matrix.columns);

		for(int i = 0; i < result.rows; i++) {
			for(int j = 0; j < result.columns; j++) {
				result.matrix[i][j] = matrix.matrix[i][j] * scalar;
			}
		}

		result.full = true;

		return result;
	}

	public static Matrix multiplication(double scalar, Matrix matrix) {
		return multiplication(matrix, scalar);
	}

	/*
		prefix to get row vector * matrix or matrix * columns vector
		treated vector as a matrix 1xn or nx1
		using matrix dot product as well
	*/

	public static Vector multiplication(Matrix matrix, Vector vector) {
		if(matrix.full == false || vector.full == false) {
			throw new EmptyException("Empty matrix or vector");
		}

		Vector result;

		if(vector.horizontal == false && matrix.columns == vector.length) {
			result = new Vector(matrix.rows, false);
			result.makeZeros();

			for(int i = 0; i < result.length; i++) {
				for(int j = 0; j < vector.length; j++) {
					result.vector[i] += matrix.matrix[i][j] * vector.vector[j];
				}
			}

			result.full = true;
		} else if(vector.horizontal == true && matrix.rows == vector.length) {
			result = new Vector(matrix.columns, true);
			result.makeZeros();

			for(int i = 0; i < result.length; i++) {
				for(int j = 0; j < vector.length; j++) {
					result.vector[i] = matrix.matrix[i][j] * vector.vector[j];
				}
			}

			result.full = true;
		} else {
			throw new JydletException("Matrix cannot multiply this vector!");
		}

		return result;
	}

	public static Vector multiplication(Vector vector, Matrix matrix) {
		return multiplication(matrix, vector);
	}

	//using dot product ( no cross product )

	public static double multiplication(Vector vector, Vector svector) {
		if(vector.full == false || svector.full == false) {
			throw new EmptyException("Empty vector");
		}

		if(vector.length != svector.length) {
			throw new JydletException("This two vector cannot multiply");
		}

		double result = 0;

		for(int i = 0; i < vector.length; i++) {
			result += vector.vector[i] * svector.vector[i];
		}

		return result;
	}

	public static Vector multiplication(Vector vector, double scalar) {
		if(vector.full == false) {
			throw new EmptyException("Empty vector");
		}

		Vector result = new Vector(vector.length, vector.horizontal);

		for(int i = 0; i < result.length; i++) {
			result.vector[i] = vector.vector[i] * scalar;
		}

		result.full = true;

		return result;
	}

	public static Vector multiplication(double scalar, Vector vector) {
		return multiplication(vector, scalar);
	}

	public static Matrix division(Matrix matrix, double scalar) {
		return multiplication(matrix, 1 / scalar);
	}

	public static Vector division(Vector vector, double scalar) {
		return multiplication(vector, 1 / scalar);
	}

	public static Matrix division(double scalar, Matrix matrix) {
		return multiplication(scalar, inverse(matrix));
	}

	public static Vector division(Vector vector, Matrix matrix) {
		return multiplication(vector, inverse(matrix));
	}

	public static Matrix division(Matrix matrix, Matrix smatrix) {
		return multiplication(matrix, inverse(smatrix));
	}

	/*
		this is rref method which reduced matrix into row reduced echelon form matrix
		rref is made by using Gaussian Elimination method
		Gaussian Elimination is method in which we use one vector of the matrix multiply and subtract other vector of the matrix
		after using rref we got det(A) = det(B) where A is matrix before rref and B is matrix after rref
	*/

	public static Matrix rref(Matrix matrix) {
		if(matrix.full == false) {
			throw new EmptyException("Empty matrix");
		}

		Matrix result = new Matrix(matrix.rows, matrix.columns);

		for(int i = 0; i < result.rows; i++) {
			for(int j = 0; j < result.columns; j++) {
				result.matrix[i][j] = matrix.matrix[i][j];
			}
		}

		result.full = true;

		int lead = 0;

		for(int row = 0; row < result.rows; row++) {
			if(lead >= result.columns) {
				return result;
			}

			int i = row;

			while(result.matrix[i][lead] == 0) {
				i++;

				if(i == result.rows) {
					i = row;
					lead++;

					if(result.columns == lead) {
						return result;
					}
				}
			}

			if(i != row) {
				double[] rowTemp = result.matrix[i];
				result.matrix[i] = result.matrix[row];
				result.matrix[row] = rowTemp;
			}

			result.matrix[row] = division(Vector.create(result.matrix[row]), result.matrix[row][lead]).vector;

			for(; i < result.rows; i++) {
				if(i != row) {
					result.matrix[i] = subtraction(Vector.create(result.matrix[i]), multiplication(Vector.create(result.matrix[row]), result.matrix[i][lead])).vector;
				}
			}

			lead++;
		}

		return result;
	}

	public static double det(Matrix matrix) {
		if(matrix.full == false) {
			throw new EmptyException("Empty matrix");
		}

		if(matrix.rows != matrix.columns) {
			throw new JydletException("cannot calculate determinant for this matrix since not a square matrix");
		}

		Matrix temp2 = new Matrix(matrix.rows, matrix.columns);

		for(int i = 0; i < temp2.rows; i++) {
			for(int j = 0; j < temp2.columns; j++) {
				temp2.matrix[i][j] = matrix.matrix[i][j];
			}
		}

		int index;
		double num1, num2;
		double det = 1, total = 1;

		double[] temp = new double[temp2.rows + 1];

		for(int i = 0; i < temp2.rows; i++) {
			index = i;

			while(index < temp2.rows) {
				if(temp2.matrix[index][i] == 0) {
					index++;
				} else {
					break;
				}
			}

			if(index == temp2.rows) {
				continue;
			}

			if(index != i) {
				for(int j = 0; j < temp2.rows; j++) {
					double temp3 = temp2.matrix[index][j];
					temp2.matrix[index][j] = temp2.matrix[i][j];
					temp2.matrix[i][j] = temp3;
				}

				det *= Math.pow(-1, index - i);
			}

			for(int j = 0; j < matrix.rows; j++) {
				temp[j] = temp2.matrix[i][j];
			}

			for(int j = i + 1; j < temp2.rows; j++) {
				num1 = temp[i];
				num2 = temp2.matrix[j][i];

				for(int k = 0; k < matrix.rows; k++) {
					temp2.matrix[j][k] = (num1 * temp2.matrix[j][k]) - (num2 * temp[k]);
				}

				total *= num1;
			}
		}

		for(int i = 0; i < temp2.rows; i++) {
			det *= temp2.matrix[i][i];
		}

		return det / total;
	}

	public static Matrix adjoint(Matrix matrix) {
		if(matrix.full == false) {
			throw new EmptyException("Empty matrix");
		}

		return Matrix.transpose(cofactor(matrix));
	}

	public static Matrix cofactor(Matrix matrix) {
		if(matrix.full == false) {
			throw new EmptyException("Empty matrix");
		}

		Matrix result = new Matrix(matrix.rows, matrix.columns);

		for(int i = 0; i < result.rows; i++) {
			for(int j = 0; j < result.columns; j++) {
				result.matrix[i][j] = Math.pow(-1, i + j) * det(JydletFormula.rrc(matrix, i, j));
			}
		}

		result.full = true;

		return result;
	}

	/*
		this inverse is using "Generalization inverse" in linear algebra
		Generalization inverse can make sure every matrix has inverse
		for square matrix which has det != 0, it's normal inverse (nonsingular matrix)
		for square matrix which has det = 0 and rank r, we find the submatrix rxr which is nonsingular matrix, inverse that part then every part left is zero
		for non-square matrix, work same for singular square matrix
	*/

	public static Matrix inverse(Matrix matrix) {
		if(matrix.full == false) {
			throw new EmptyException("Empty matrix");
		}

		Matrix result = null;
		int rstart = 0;
		int cstart = 0;
		int srank = 0;

		if(matrix.rows == matrix.columns) {
			if(det(matrix) != 0) {
				result = multiplication(1 / det(matrix), adjoint(matrix));
			} else {
				int rank = Matrix.rank(matrix);
				Matrix submatrix = null;

				findinvs:
				for(int i = 0; i < matrix.rows; i++) {
					for(int j = 0; j < matrix.columns; j++) {
						if(i + rank >= matrix.rows || j + rank >= matrix.columns) {
							continue;
						} else {
							Matrix temp = JydletFormula.submatrix(matrix, i, j, rank);
							if(det(temp) != 0) {
								submatrix = multiplication(1 / det(temp), adjoint(temp));
								rstart = i;
								cstart = j;
								srank = rank;
								break findinvs;
							}
						}
					}
				}

				Matrix temp = new Matrix(matrix.rows, matrix.columns);
				for(int i = 0; i < temp.rows; i++) {
					for(int j = 0; j < temp.columns; j++) {
						temp.matrix[i][j] = 0;
					}
				}

				if(submatrix != null) {
					result = Matrix.transpose(JydletFormula.setSmatrix(temp, Matrix.transpose(submatrix), rstart, cstart, srank));
				}
			}
		} else {
			int rank = Matrix.rank(matrix);
			Matrix submatrix = null;

			findinvs:
			for(int i = 0; i < matrix.rows; i++) {
				for(int j = 0; j < matrix.columns; j++) {
					if(i + rank >= matrix.rows || j + rank >= matrix.columns) {
						continue;
					} else {
						Matrix temp = JydletFormula.submatrix(matrix, i, j, rank);
						if(det(temp) != 0) {
							submatrix = multiplication(1 / det(temp), adjoint(temp));
							rstart = i;
							cstart = j;
							srank = rank;
							break findinvs;
						}
					}
				}
			}

			Matrix temp = new Matrix(matrix.rows, matrix.columns);
			for(int i = 0; i < temp.rows; i++) {
				for(int j = 0; j < temp.columns; j++) {
					temp.matrix[i][j] = 0;
				}
			}

			if(submatrix != null) {
				result = Matrix.transpose(JydletFormula.setSmatrix(temp, Matrix.transpose(submatrix), rstart, cstart, srank));
			}
		}

		return result;
	}
}