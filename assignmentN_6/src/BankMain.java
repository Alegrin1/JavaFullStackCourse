public class BankMain {

    public static void main(String[] args) {
        BankAccount account1 = null; // Declare outside try to potentially use in finally

        try {
            account1 = new BankAccount("ACC12345", "Alice Wonderland", 500.00);
            account1.displayBalance();

            account1.deposit(150.50);
            account1.displayBalance();

            try {
                account1.deposit(-50.00);
            } catch (InvalidAmountException e) {
                System.err.println("Error during deposit: " + e.getMessage());
            }
            account1.displayBalance();

            try {
                account1.withdraw(100.00);
            } catch (InvalidAmountException | InsufficientFundsException e) {
                System.err.println("Error during withdrawal: " + e.getMessage());
            }
            account1.displayBalance();

            try {
                account1.withdraw(600.00);
            } catch (InsufficientFundsException | InvalidAmountException e) {
                System.err.println("Error during withdrawal: " + e.getMessage());
            }
            account1.displayBalance();

            try {
                account1.withdraw(0.00);
            } catch (InvalidAmountException | InsufficientFundsException e) {
                System.err.println("Error during withdrawal: " + e.getMessage());
            }
            account1.displayBalance();


        } catch (InvalidAmountException e) {
            System.err.println("Account Creation Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            if (account1 != null) {
                System.out.println("Final check on account: " + account1.getAccountNumber());
            } else {
                System.out.println("Account was not successfully created");
            }
            System.out.println("Exiting banking application simulation");
        }
    }
}