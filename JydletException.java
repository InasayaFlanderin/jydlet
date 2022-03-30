package jydlet;

interface JydletException {}

public class NoInputSizeException extends Exception {
	public NoInputSizeException(String layername) {
		super(layername + "has no input size");
	}
}

public class TransposeException extends Exception {
	public TransposeException() {
		super("Cannot be transpose due to the emptiness");
	}
}