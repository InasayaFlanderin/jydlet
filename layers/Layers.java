package jydlet.layers;

import jydlet.NoInputSizeException;

interface Layers {
	public void build();
	public boolean isTrainable();
	public boolean isBuild();
	public boolean hasNInputs();
	public void setNInputs(int nInputs);
	public int getNNeurons();
	public String getName();
}

public class Dense implements Serializable {
	private boolean trainable;
	private boolean build;
	private boolean hasNInputs;
	private int nInputs;
	private int nNeurons;
	public Matrix weights;
	public Vector biases;


	public Dense(int nInputs, int nNeurons, boolean trainable, String name) {
		this.nInputs = nInputs;
		this.nNeurons = nNeurons;
		this.trainable = trainable == null ? true : false;
		this.build = false;
		this.hasNInputs = true;
		this.name = name;
	}

	public Layer(int nNeurons, boolean trainable, String name) {
		this.nNeurons = nNeurons;
		this.trainable = trainable == null ? true : false;
		this.build = false;
		this.hasNInputs = false;
		this.name = name;
	}

	public void build() {
		if(hasNInputs == false) {
			throw new NoInputSizeException(this.name);
		}

		this.weights = Matrix.tranpose(new Matrix(nInputs, nNeurons, true));
		this.biases = new Vector(nNeurons, false);
		this.biases.makeZeros();
		this.build = true;
	}

	public boolean isTrainable() {
		return this.trainable;
	}

	public boolean isBuild() {
		return this.build;
	}

	public boolean hasNInputs() {
		return this.hasNInputs;
	}

	public void setNInputs(int nInputs) {
		this.nInputs = nInputs;
		this.hasNInputs = true;
	}

	public int getNNeurons() {
		return this.nNeurons;
	}

	public String getName() {
		return this.name;
	}
}