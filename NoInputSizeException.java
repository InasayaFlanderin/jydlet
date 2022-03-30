package jydlet;

public class NoInputSizeException extends JydletException {
	public NoInputSizeException(String layername) {
		super(layername + "has no input size");
	}
}