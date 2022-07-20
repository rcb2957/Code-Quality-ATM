import org.junit.Assert;
import org.junit.jupiter.api.Test;

class TestATM {
	
	@Test
	void testNegativeDeposit() throws Exception {
		ATM atm = new ATM(0, "USD");
		atm.deposit(-5);
		Assert.assertEquals(0, atm.checkBalance(), 0.01);
	}
	
	 @Test
	void testExchangeUSDToUSD() throws Exception {
		ATM atm = new ATM(100, "USD");
		atm.exchangeCurrency("USD");
		Assert.assertEquals(100, atm.checkBalance(), 0.01);
		Assert.assertEquals("USD", atm.checkCurrency());
	}
	/* Write your tests here */

	//Make Account Tests

	@Test
	void testAccountCreation() throws Exception {
		ATM atm = new ATM(0, "USD");
		Assert.assertEquals(0, atm.checkBalance(), 0.01);
		Assert.assertEquals("USD", atm.checkCurrency());
	}

	@Test
	void testPositiveAccountCreation() throws Exception {
		ATM atm = new ATM(20, "USD");
		Assert.assertEquals(20, atm.checkBalance(), 0.01);
		Assert.assertEquals("USD", atm.checkCurrency());
	}


	@Test
	void testNegativeAccountCreation() throws Exception {
		Exception exception = Assert.assertThrows(UnsupportedCurrencyCodeException.class, () -> {
			ATM atm = new ATM(-10, "USD");
		});
		Assert.assertEquals(exception.getMessage(), "The initial balance must be 0 or more");
	}

	@Test
	void testAccountCreationInvalidCurrency() throws Exception {
		Exception exception = Assert.assertThrows(UnsupportedCurrencyCodeException.class, () -> {
			ATM atm = new ATM(0, "RAT");
		});
		Assert.assertEquals(exception.getMessage(), "RAT is not a supported currency. Supported currencies are [USD, CAD, EUR]");
	}

	// Deposit Tests

	@Test
	void testPositiveDeposit() throws Exception {
		ATM atm = new ATM(0, "USD");
		atm.deposit(50);
		Assert.assertEquals(50, atm.checkBalance(), 0.01);
	}

	@Test
	void testPositiveDeposit2() throws Exception {
		ATM atm = new ATM(22, "CAD");
		atm.deposit(12);
		Assert.assertEquals(34, atm.checkBalance(), 0.01);
	}

	@Test
	void testNegativeDeposit2() throws Exception {
		ATM atm = new ATM(20, "CAD");
		atm.deposit(-5);
		Assert.assertEquals(20, atm.checkBalance(), 0.01);
	}

	@Test
	void testNoDeposit() throws Exception {
		ATM atm = new ATM(7, "USD");
		atm.deposit(0);
		Assert.assertEquals(7, atm.checkBalance(), 0.01);
	}

	// Withdrawl Tests

	@Test
	void testNoWithdrawl() throws Exception {
		ATM atm = new ATM(10, "USD");
		atm.withdraw(0);
		Assert.assertEquals(10, atm.checkBalance(), 0.01);
	}

	@Test
	void testPositiveWithdrawl() throws Exception {
		ATM atm = new ATM(10, "USD");
		atm.withdraw(5);
		Assert.assertEquals(5, atm.checkBalance(), 0.01);
	}

	@Test
	void testNegativeWithdrwal() throws Exception {
		ATM atm = new ATM(10, "USD");
		atm.withdraw(-5);
		Assert.assertEquals(10, atm.checkBalance(), 0.01);
	}

	@Test
	void testNegativeBalanceWithdrwal() throws Exception {
		ATM atm = new ATM(0, "USD");
		atm.withdraw(5);
		Assert.assertEquals(0, atm.checkBalance(), 0.01);
	}

	// Currency Changing Tests
	@Test
	void testExchangeEURToUSD() throws Exception {
		ATM atm = new ATM(100, "EUR");
		atm.exchangeCurrency("USD");
		Assert.assertEquals(102, atm.checkBalance(), 0.01);
		Assert.assertEquals("USD", atm.checkCurrency());
	}

	@Test
	void testExchangeCADToUSD() throws Exception {
		ATM atm = new ATM(100, "CAD");
		atm.exchangeCurrency("USD");
		Assert.assertEquals(70, atm.checkBalance(), 0.01);
		Assert.assertEquals("USD", atm.checkCurrency());
	}

	@Test
	void testExchangeUSDToCAD() throws Exception {
		ATM atm = new ATM(100, "USD");
		atm.exchangeCurrency("CAD");
		Assert.assertEquals(130, atm.checkBalance(), 0.01);
		Assert.assertEquals("CAD", atm.checkCurrency());
	}

	@Test
	void testExchangeCADToCAD() throws Exception {
		ATM atm = new ATM(100, "CAD");
		atm.exchangeCurrency("CAD");
		Assert.assertEquals(100, atm.checkBalance(), 0.01);
		Assert.assertEquals("CAD", atm.checkCurrency());
	}

	@Test
	void testExchangeEURToCAD() throws Exception {
		ATM atm = new ATM(100, "EUR");
		atm.exchangeCurrency("CAD");
		Assert.assertEquals(134, atm.checkBalance(), 0.01);
		Assert.assertEquals("CAD", atm.checkCurrency());
	}

	@Test
	void testExchangeUSDToEUR() throws Exception {
		ATM atm = new ATM(100, "USD");
		atm.exchangeCurrency("EUR");
		Assert.assertEquals(98, atm.checkBalance(), 0.01);
		Assert.assertEquals("USD", atm.checkCurrency());
	}

	@Test
	void testExchangeCADToEUR() throws Exception {
		ATM atm = new ATM(100, "CAD");
		atm.exchangeCurrency("EUR");
		Assert.assertEquals(76, atm.checkBalance(), 0.01);
		Assert.assertEquals("EUR", atm.checkCurrency());
	}

	@Test
	void testExchangeEURToEUR() throws Exception {
		ATM atm = new ATM(100, "EUR");
		atm.exchangeCurrency("EUR");
		Assert.assertEquals(100, atm.checkBalance(), 0.01);
		Assert.assertEquals("EUR", atm.checkCurrency());
	}

	@Test
	void testExchangeCADToInvalidCurrency() throws Exception {
		Exception exception = Assert.assertThrows(UnsupportedCurrencyCodeException.class, () -> {
			ATM atm = new ATM(200, "CAD");
			atm.exchangeCurrency("PIE");
		});
		Assert.assertEquals(exception.getMessage(), "PIE is not a supported currency to convert to. Supported currencies are: USD, CAD, EUR");
	}

	@Test
	void testExchangeUSDToInvalidCurrency() throws Exception {
		Exception exception = Assert.assertThrows(UnsupportedCurrencyCodeException.class, () -> {
			ATM atm = new ATM(200, "USD");
			atm.exchangeCurrency("ION");
		});
		Assert.assertEquals(exception.getMessage(), "ION is not a supported currency to convert to. Supported currencies are: USD, CAD, EUR");
	}

	@Test
	void testExchangeEURToInvalidCurrency() throws Exception {
		Exception exception = Assert.assertThrows(UnsupportedCurrencyCodeException.class, () -> {
			ATM atm = new ATM(200, "EUR");
			atm.exchangeCurrency("EGG");
		});
		Assert.assertEquals(exception.getMessage(), "EGG is not a supported currency to convert to. Supported currencies are: USD, CAD, EUR");
	}

}
