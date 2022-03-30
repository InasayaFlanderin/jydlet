package jydlet;

abstract class JydletException extends Exception {
	public JydletException(String errormsg) {
		super(errormsg);
	}
}