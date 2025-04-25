public class BankAccount {

    private String accountNumber;
    private String accountHolder;
    private double balance;

    public BankAccount(String accountNumber, String accountHolder, double balance) throws InvalidAmountException {
        if (balance < 0) {
            throw new InvalidAmountException("Initial balance cannot be negative: $" + balance);
        }
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
        System.out.println("Account created for " + accountHolder + " with number " + accountNumber + ". Initial balance: $" + String.format("%.2f", balance));
    }

    public void deposit(double amount) throws InvalidAmountException {
        System.out.println("\nAttempting to deposit: $" + String.format("%.2f", amount));
        if (amount <= 0) {
            throw new InvalidAmountException("Deposit amount must be positive. Attempted: $" + String.format("%.2f", amount));
        }
        this.balance += amount;
        System.out.println("Deposit successful. Current balance: $" + String.format("%.2f", this.balance));
    }

    public void withdraw(double amount) throws InvalidAmountException, InsufficientFundsException {
        System.out.println("\nAttempting to withdraw: $" + String.format("%.2f", amount));
        if (amount <= 0) {
            throw new InvalidAmountException("Withdrawal amount must be positive. Attempted: $" + String.format("%.2f", amount));
        }
        if (amount > this.balance) {
            throw new InsufficientFundsException(
                    "Insufficient funds for withdrawal. Available: $" + String.format("%.2f", this.balance) +
                            ", Attempted: $" + String.format("%.2f", amount)
            );
        }
        this.balance -= amount;
        System.out.println("Withdrawal successful. Current balance: $" + String.format("%.2f", this.balance));
    }

    public void displayBalance() {
        System.out.println("\nAccount Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: $" + String.format("%.2f", balance));
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

}

