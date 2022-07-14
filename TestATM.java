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

	//Make Account Tests (INCOMPLETE)

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

//	MODIFY
	@Test
	void testNegativeAccountCreation() throws Exception {
		ATM atm = new ATM(-10, "USD");
		Assert.assertEquals(50, atm.checkBalance(), 0.01);

	}

	@Test (expected = UnsupportedCurrencyCodeException.class)
	void testAccountCreationInvalidCurrency() throws Exception {
		ATM atm = new ATM(0, "RAT");
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

	// Currency Changing Tests (INCOMPLETE)
	@Test
	void testExchangeEURToUSD() throws Exception {
		ATM atm = new ATM(100, "EUR");
		atm.exchangeCurrency("USD");
		Assert.assertEquals(100, atm.checkBalance(), 0.01);
		Assert.assertEquals("USD", atm.checkCurrency());
	}

	@Test
	void testExchangeCADToUSD() throws Exception {
		ATM atm = new ATM(100, "CAD");
		atm.exchangeCurrency("USD");
		Assert.assertEquals(100, atm.checkBalance(), 0.01);
		Assert.assertEquals("USD", atm.checkCurrency());
	}

	@Test
	void testExchangeUSDToCAD() throws Exception {
		ATM atm = new ATM(100, "USD");
		atm.exchangeCurrency("CAD");
		Assert.assertEquals(100, atm.checkBalance(), 0.01);
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
		Assert.assertEquals(100, atm.checkBalance(), 0.01);
		Assert.assertEquals("CAD", atm.checkCurrency());
	}

	@Test
	void testExchangeUSDToEUR() throws Exception {
		ATM atm = new ATM(100, "USD");
		atm.exchangeCurrency("EUR");
		Assert.assertEquals(100, atm.checkBalance(), 0.01);
		Assert.assertEquals("USD", atm.checkCurrency());
	}

	@Test
	void testExchangeCADToEUR() throws Exception {
		ATM atm = new ATM(100, "CAD");
		atm.exchangeCurrency("EUR");
		Assert.assertEquals(100, atm.checkBalance(), 0.01);
		Assert.assertEquals("EUR", atm.checkCurrency());
	}

	@Test
	void testExchangeEURToEUR() throws Exception {
		ATM atm = new ATM(100, "EUR");
		atm.exchangeCurrency("EUR");
		Assert.assertEquals(100, atm.checkBalance(), 0.01);
		Assert.assertEquals("EUR", atm.checkCurrency());
	}

	@Test (expected = IllegalArgumentException.class)
	void testExchangeToInvalidCurrency() throws Exception {
		ATM atm = new ATM(200, "CAD");
		atm.exchangeCurrency("PIE");
	}

}
