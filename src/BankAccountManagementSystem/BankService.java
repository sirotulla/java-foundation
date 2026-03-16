package BankAccountManagementSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {

    private final ArrayList<BankAccount> accounts = new ArrayList<>();
    private final ArrayList<String> history = new ArrayList<>();
    private final Map<String, ArrayList<String>> transactionHistory = new HashMap<>();

    public BankAccount createSavingsAccount(String accNum, String name, double initialDeposit) {
        BankAccount account = findAccount(accNum);
        if (account != null) {
            System.out.println(accNum + "account number " + accNum + " already exists!");
            return null;
        }

        SavingsAccount acc = new SavingsAccount(accNum, name, initialDeposit);
        accounts.add(acc);
        return acc;
    }


    public BankAccount createCurrentAccount(String accNum, String name, double initialDeposit) {
        BankAccount account = findAccount(accNum);
        if (account != null) {
            System.out.println(accNum + "account number already exists!");
            return null;
        }

        CurrentAccount acc = new CurrentAccount(accNum, name, initialDeposit);
        accounts.add(acc);
        return acc;
    }


    public void deleteAccount(String accNum) {
        for (BankAccount acc : accounts) {
            if (acc.getAccountNumber().equals(accNum)) {
                accounts.remove(acc);
                System.out.println(accNum + " account deleted successfully");
            } else {
                System.out.println("Account not found");
            }
        }
    }


    public BankAccount findAccount(String accountNumber) {
        for (BankAccount acc : accounts) {
            if (acc.getAccountNumber().equals(accountNumber)) {
                return acc;
            }
        }
        return null;
    }


    public boolean deposit(String accountNumber, double amount) {
        BankAccount acc = findAccount(accountNumber);

        if (acc == null ) {
            System.out.println("Account Not Found");
            return false;
        }

        if (amount <=0) {
            System.out.println("Invalid amount");
            return false;
        }


        transactionHistory.putIfAbsent(accountNumber, new ArrayList<>());
        transactionHistory.get(accountNumber).add("Deposited amount " + amount);

        acc.deposit(amount);
        return true;
    }


    public boolean withdraw(String accountNumber, double amount) {
        BankAccount acc = findAccount(accountNumber);
        if (acc == null ) {
            System.out.println("Account Not Found");
            return false;
        }

        if (amount <=0) {
            System.out.println("Invalid amount");
            return false;
        }

        transactionHistory.putIfAbsent(accountNumber, new ArrayList<>());
        transactionHistory.get(accountNumber).add("Withdrawal amount " + amount);

        acc.withdraw(amount);
        return true;
    }


    public double getBalance (String accountNumber) {
        BankAccount acc = findAccount(accountNumber);
        return (acc == null) ? -1 : acc.getBalance();
    }


    public void displayAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts found.");
            return;
        }

        int numberOfUsers = 0;
        for (BankAccount acc : accounts) {
            numberOfUsers++;
            System.out.println("User " + numberOfUsers);
            System.out.println("| Account Number: " + acc.getAccountNumber());
            System.out.println("| Name: " + acc.getAccountHolderName());
            System.out.println("| Balance: " + acc.getBalance());
        }
    }


    public void displayHistory(String accNum) {
        BankAccount acc = findAccount(accNum);
        if (acc == null) {
            System.out.println("Account Not Found");
            return;
        }

        List<String> history = transactionHistory.get(accNum);

        if (history == null || history.isEmpty()) {
            System.out.println("No transaction history found for " + accNum);
            return;
        }

        System.out.println("History for " + accNum + ":");
        for (String record : history) {
            System.out.println("- " + record);
        }

    }

}
