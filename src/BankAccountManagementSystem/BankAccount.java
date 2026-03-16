package BankAccountManagementSystem;

public abstract class BankAccount {
    private String accountNumber;
    private double balance;
    private String accountHolderName;

    public BankAccount(String accountNumber, double balance, String accountHolderName) {
        setAccountNumber(accountNumber);
        setBalance(balance);
        setAccountHolderName(accountHolderName);
    }

    public void deposit(double amount) {
        if  (amount > 0) {
            setBalance(getBalance() + amount);
            System.out.println("Amount deposited: " + amount);
        } else {
            System.out.println("Invalid amount");
        }


    }

    public abstract void withdraw(double amount);

    // getters
    public String getAccountNumber() {
        return this.accountNumber;
    }

    public double getBalance() {
        return this.balance;
    }

    public String getAccountHolderName(){
        return this.accountHolderName;
    }

    // setters
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

}

