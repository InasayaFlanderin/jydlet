package jydlet;

public class TransposeException extends JydletException {
	public TransposeException() {
		super("Cannot be transpose due to the emptiness");
	}
}