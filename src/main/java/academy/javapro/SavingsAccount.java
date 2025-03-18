package academy.javapro;

/**
 * SavingsAccount class extending the abstract Account class.
 * Features interest rate and minimum balance requirement.
 */
public class SavingsAccount extends Account {
    private final double interestRate;
    private static final double MIN_BALANCE = 100.0; // Minimum balance requirement

    /**
     * Constructor for creating a new savings account.
     *
     * @param accountNumber The account number
     * @param customerName The name of the account holder
     * @param initialBalance The initial balance
     * @param interestRate The annual interest rate (%)
     */
    public SavingsAccount(String accountNumber, String customerName, double initialBalance, double interestRate) {
        super(accountNumber, customerName, initialBalance); // Call to the parent constructor
        this.interestRate = interestRate;
    }

    /**
     * Calculates the interest amount based on the current balance.
     *
     * @return The calculated interest amount
     */
    public double calculateInterest() {
        return getBalance() * (interestRate /100);
        //throw new UnsupportedOperationException("Method not implemented");
    }

    /**
     * Applies the calculated interest to the account balance.
     */
    public void applyInterest() {
        double interest = calculateInterest();
        deposit(interest);
        System.out.println("Interest applied: $" + String.format("%.2f", interest));
        //throw new UnsupportedOperationException("Method not implemented");
    }

    /**
     * Overrides the withdraw method with savings account-specific rules.
     * Ensures minimum balance is maintained.
     */
    @Override
    public void withdraw(double amount) {
        if (getBalance() - amount >= MIN_BALANCE){
            double newBalance = getBalance() - amount;
            setBalance(newBalance);
            logTransaction("WITHDRAWL", amount);
            System.out.println("Withdrew $" + String.format("%.2f", amount) + " from savings account");
        } else {
            System.out.println("Cannot withdrawl $" + amount + ". Minimum balance of $" + MIN_BALANCE + " must be maintained");
        }
        //throw new UnsupportedOperationException("Method not implemented");
    }

    /**
     * Overrides the displayInfo method to include savings account-specific information.
     */
    @Override
    public void displayInfo() {
        super.displayInfo(); // Call to the parent method
        System.out.println("Account Type: Savings Account");
        System.out.println("Interest Rate: " + interestRate + "%");
        System.out.println("Minimum Balance Requirement: $" + MIN_BALANCE);
    }
}
