/* Class to return currency exchange rates for USD, CAD and EUR.
 * You may assume that this class works correctly and should not modify it in any way.
 * Rates are from July 7, 2022 */

public class CurrencyExchanger {
	
	public double getExchangeRate(String currentCurrency, String desiredCurrency) throws Exception {
		
		double exchangeRate = 0;
		
		switch (currentCurrency) {
		
			/* Convert USD to other currencies */
		case "USD":
			switch (desiredCurrency) {
				case "USD": exchangeRate = 1.0; break;
				case "CAD": exchangeRate = 1.3; break;
				case "EUR": exchangeRate = 0.98; break;
				default:
					throw new UnsupportedCurrencyCodeException(desiredCurrency + " is not a supported currency to convert to. Supported currencies are: USD, CAD and EUR");
			} break;
			
		/* Convert CAD to other currencies*/
		case "CAD":
			switch (desiredCurrency) {
				case "USD": exchangeRate = 0.7; break;
				case "CAD": exchangeRate = 1.0; break;
				case "EUR": exchangeRate = 0.76; break;
				default:
					throw new UnsupportedCurrencyCodeException(desiredCurrency + " is not a supported currency to convert to. Supported currencies are: USD, CAD and EUR");
			} break;
			
		/* Convert EUR to other currencies */
		case "EUR":
			switch (desiredCurrency) {
			case "USD": exchangeRate = 1.02; break;
			case "CAD": exchangeRate = 1.34; break;
			case "EUR": exchangeRate = 1.0; break;
			default:
				throw new UnsupportedCurrencyCodeException(desiredCurrency + " is not a supported currency to convert to. Supported currencies are: USD, CAD and EUR");
			} break;
		}
		return exchangeRate;
	}
}
