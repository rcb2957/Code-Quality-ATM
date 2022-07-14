import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class ATM {
	
	double balance;
	String currentCurrency;
	private final List<String> supportedCurrencyCodeList = Arrays.asList("USD", "CAD", "EUR");
	
	/* Class constructor */
	public ATM(double initialBalance, String currencyCode) throws Exception {
		if(initialBalance >= 0){
			balance = initialBalance;
		} else {
			System.out.println("The initial balance cannot be less than 0");
		}
		if (supportedCurrencyCodeList.contains(currencyCode)) {
			currentCurrency = currencyCode;
		} else {
			throw new UnsupportedCurrencyCodeException(currencyCode + " is not a supported currency. Supported currencies are " + supportedCurrencyCodeList.toString());
		}
	}
	
	 /* Method to check the current balance of the account */
	public double checkBalance() {
		printBalance();
		return balance;
	}
	
	/* Method to check the current currency in use */
	public String checkCurrency() {
		return currentCurrency;
	}
	
	/* Method to deposit (add) money to the account */
	public void deposit(double depositAmount) {
		System.out.println("Depositing " + depositAmount + " " + currentCurrency)
		if(depositAmount > 0){
			balance += depositAmount;
		} else {
			System.out.println("All deposits must exceed a currency amount of 0");
		}
	}
	
	/* Method to withdraw (subtract) money from the account */
	public void withdraw(double withdrawalAmount) {
		System.out.println("Withdrawing " + withdrawalAmount + " " + currentCurrency);
		if(withdrawalAmount > 0 && (balance - withdrawalAmount) >= 0){
			balance -= withdrawalAmount;
		} else if(withdrawalAmount <= 0){
			System.out.println("All withdrawls must exceed a currency amount of 0");
		} else {
			System.out.println("The amount of money withdrawn cannot exceed the account's balance");
		}
	}
	
	/* Method to convert the current currency to USD, CAD, or EUR */
	public void exchangeCurrency(String desiredCurrency) throws Exception {
		if (supportedCurrencyCodeList.contains(desiredCurrency)) {
			currentCurrency = currencyCode;
			CurrencyExchanger exchanger = new CurrencyExchanger();
			double exchangeRate = exchanger.getExchangeRate(currentCurrency, desiredCurrency);
			currentCurrency = desiredCurrency;
			balance *= exchangeRate;
		} else {
			throw new UnsupportedCurrencyCodeException(currencyCode + " is not a supported currency. Supported currencies are " + supportedCurrencyCodeList.toString());
		}
	}
	
	/* Helper method that prints the current balance.
	 * You may assume this method works correctly and should not modify it. */
	public void printBalance() {
		System.out.println("Current balance: " + balance + " " + currentCurrency);
	}
}
