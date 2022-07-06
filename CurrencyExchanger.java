import java.util.Dictionary;

/* Class to return currency exchange rates. Rates are from July 6, 2022 */
public class CurrencyExchanger {

    public CurrencyExchanger(String currentCurrencyCode, String desiredCurrencyCode) {
        String currentCurrencyCode = currentCurrencyCode;
        String desiredCurrencyCode = desiredCurrencyCode;
    }

    public static double getExchangeRate() {
        switch (desiredCurrencyCode) {
            case "USD":
                switch (currencyCode) {
                    case "USD": return 1.0;
                    case "CAD": return 0.77;
                    case "JPY": return 0.0074;
                    case "GBP": return 1.19;
                    case "EUR": return 1.02;
                } break;
            case "CAD":
                switch (currencyCode) {
                    case "USD": return 1.31;
                    case "CAD": return 1.0;
                    case "JPY": return 0.0096;
                    case "GBP": return 1.56;
                    case "EUR": return 1.33;
                } break;
            case "JPY":
                switch (currencyCode) {
                    case "USD": return 135.91;
                    case "CAD": return 104.24;
                    case "JPY": return 1.0;
                    case "GBP": return 162.19;
                    case "EUR": return 130.40;
                } break;
            case "GBP":
                switch (currencyCode) {
                    case "USD": return 0.84;
                    case "CAD": return 0.64;
                    case "JPY": return 0.0062;
                    case "GBP": return 1.0;
                    case "EUR": return 0.85;
                } break;
            case "EUR": 
                switch (currencyCode) {
                    case "USD": return 0.98;
                    case "CAD": return 0.75;
                    case "JPY": return 0.0072;
                    case "GBP": return 1.17;
                    case "EUR": return 1.0;
                } break;
            default:
                System.out.println(desiredCurrencyCode + " is not a valid currency type. Valid types are:\nUSD, CAD, JPY, GBP and EUR");
        }
    }
}