package BankAccountManagementSystem;

public class SavingsAccount extends BankAccount{

    public SavingsAccount(String accountNumber, String accountHolderName,  double balance) {
        super(accountNumber, balance, accountHolderName);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount");
            return;
        }

        if (getBalance() - amount >= 100) {
            setBalance(getBalance()-amount);
            System.out.println("Withdrawn $" + amount);
            System.out.println("✅ Withdrawal successful!");
            System.out.println("💰 Remaining Balance: $" + getBalance());
        } else {
            System.out.println("Insufficient funds. Minimum balance of $100 required");
        }
    }
}
