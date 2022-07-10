/* This class is a custom exception for unsupported currency codes.
* You may assume that this class works correctly and should not modify it in any way. */

public class UnsupportedCurrencyCodeException extends Exception {

	private static final long serialVersionUID = 1L;

	public UnsupportedCurrencyCodeException(String message) {
		super(message);
	}
}
