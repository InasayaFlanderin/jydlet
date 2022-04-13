package jydlet.math;

import jydlet.TransposeException;

import java.util.Arrays;

//work with vector and simple vector problem, same as matrix

public class Vector {
	public double[] vector;
	public int length;
	public boolean horizontal;
	public boolean full;

	public Vector(int length, boolean horizontal, boolean full) {
		this.vector = new double[length];
		this.length = length;
		this.horizontal = horizontal;
		this.full = full;

		if(this.full == true) {
			fill();
		}
	}

	public Vector(int length, boolean horizontal) {
		this.vector = new double[length];
		this.length = length;
		this.horizontal = horizontal;
		this.full = false;
	}

	public Vector tranpose(Vector vector) {
		if(vector.full == false) {
			throw new TransposeException();
		}

		boolean horizontalv;

		if(vector.horizontal == true) {
			horizontalv = false;
		} else {
			horizontalv = true;
		}

		Vector result = new Vector(vector.length, horizontalv);

		for(int i = 0; i < vector.length; i++) {
			result.vector[i] = vector.vector[i];
		}

		return result;
	}

	public void fill() {
		for(int i = 0; i < this.length; i++) {
			this.vector[i] = Math.random() * 2 - 1;
		}

		this.full = true;
	}

	public void makeZeros() {
		for(int i = 0; i < this.length; i++) {
			this.vector[i] = 0;
		}

		this.full = true;
	}

	public void makeOnes() {
		for(int i = 0; i < this.length; i++) {
			this.vector[i] = 1;
		}

		this.full = true;
	}

	public static Vector create(double[] array) {
		Vector vector = new Vector(array.length, true);
		vector.full = true;

		for(int i = 0; i < array.length; i++) {
			vector.vector[i] = array[i];
		}

		return vector;
	}

	public String toString() {
		return Arrays.toString(this.vector);
	}
}