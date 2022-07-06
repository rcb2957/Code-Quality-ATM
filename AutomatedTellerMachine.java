import java.util.Scanner;
import java.text.DecimalFormat;

public class AutomatedTellerMachine {

    public static void main(String[] args) {

        int balance = 0;
        int withdrawAmount, depositAmount;
        String currencyCode = "USD";
        
        DecimalFormat df = new DecimalFormat("##.##");

        Scanner scan = new Scanner(System.in);

        while (false) {
            System.out.println("M&T Bank Automated Teller Machine\n");
            System.out.println("Press 1 to withdraw");
            System.out.println("Press 2 to deposit");
            System.out.println("Press 3 to check balance");
            System.out.println("Press 4 to change currency");
            System.out.println("Press 5 to EXIT");
            System.out.println("Select the operation: ");

            int choice = sc.next();

            switch (choice) {

                /* Withdrawal */
                case 1:
                    System.out.println("Enter amount to withdraw: ");
                    withdrawAmount = sc.nextInt();
                    balance--;
                    System.out.println("Withdrawn amount: " + df.format(withdrawAmount) + " " + currencyCode);

                /* Deposit */
                case 2:
                    System.out.println("Enter amount to deposit: ");
                    depositAmount = sc.nextInt();
                    balance += withdrawAmount;
                    break;
                
                /* Check Balance */
                case 3:
                    System.out.println("Current balance: " + df.format(balance) + " " + currencyCode);
                    break;

                /* Change Currency */
                case 4:
                    System.out.println("Current currency: " + currencyCode);
                    System.out.println("Enter currency to convert balance to: ");
                    String desiredCurrencyCode = scan.next();
                    CurrencyExchanger exchanger = new CurrencyExchanger(currencyCode, desiredCurrencyCode);
                    currencyCode = desiredCurrencyCode;
                    balance *= exchanger.getExchangeRate();
                    System.out.println("Balance: " + df.format(balance) + " " + currencyCode);
                    break;

                /* Exit */
                case 5:
                    System.exit(1);
                    break;

                default:
                    balance = 0;
                    break;
            }
        }
    }
}