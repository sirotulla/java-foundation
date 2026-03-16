package BankAccountManagementSystem;

public class BankAccountManagementSystem {
    public static void main(String[] args) {
        BankService service = new BankService();

        boolean keepGoing = true;
        while(keepGoing) {
            System.out.println("\n========== BANK ACCOUNT MANAGEMENT SYSTEM ==========");
            System.out.println("1️⃣  Create Account");
            System.out.println("2️⃣  Deposit Money");
            System.out.println("3️⃣  Withdraw Money");
            System.out.println("4️⃣  Check Balance");
            System.out.println("5️⃣  Display All Accounts");
            System.out.println("6️⃣  Remove Account");
            System.out.println("7️⃣  Transaction history");
            System.out.println("8️⃣  Exit");
            System.out.println("====================================================");

            int choice = InputUtils.getInt("Enter your choice: ");

            switch (choice) {
                case 1:
                    System.out.println("\n------ Create Account ------");
                    String accountNumber = InputUtils.getString("Enter your account number: ");
                    String accountHolderName = InputUtils.getString("Enter your name: ");
                    double initialDeposit = InputUtils.getDouble("Enter initial deposit ($): ");

                    System.out.println("\n1️⃣  Savings Account: ");
                    System.out.println("2️⃣  Current Account: ");
                    int createAccountChoice = InputUtils.getInt("Choose Account Type:");

                    if (createAccountChoice == 1) {
                        service.createSavingsAccount(accountNumber, accountHolderName, initialDeposit);
                        System.out.println("✅ Account created successfully!");
                    } else if (createAccountChoice == 2) {
                        service.createCurrentAccount(accountNumber, accountHolderName, initialDeposit);
                        System.out.println("✅ Account created successfully!");
                    } else {
                        System.out.println("Invalid choice");
                    }
                    break;

                case 2:
                    System.out.println("\n------ Deposit Money ------");
                    String userAccount1 = InputUtils.getString("Enter Account Number: ");
                    double depositMoney = InputUtils.getDouble("Enter Deposit Amount ($): ");
                    service.deposit(userAccount1, depositMoney);
                    break;

                case 3:
                    System.out.println("\n------ Withdraw Money ------");
                    String userAccount2 = InputUtils.getString("Enter Account Number: ");
                    double withdrawMoney = InputUtils.getDouble("Enter Withdrawal Amount ($): ");
                    service.withdraw(userAccount2, withdrawMoney);
                    break;

                case 4:
                    System.out.println("\n------ Account Balance ------");
                    String userAccount3 = InputUtils.getString("Enter Account Number: ");
                    double balance = service.getBalance(userAccount3);
                    System.out.println("💰 Current Balance: $" + balance);
                    break;

                case 5:
                    System.out.println("\n------ Display All Accounts ------");
                    service.displayAccounts();
                    break;

                case 6:
                    System.out.println("\n------ Delete Account ------");
                    String deleteAcc = InputUtils.getString("Enter Account Number: ");

                    service.deleteAccount(deleteAcc);
                    break;

                case 7:
                    System.out.println("\n------ Transaction History ------");
                    String historyOfAcc = InputUtils.getString("Enter Account Number: ");
                    service.displayHistory(historyOfAcc);
                    break;

                case 8:
                    System.out.println("\n👋 Thank you for using our Bank System!");
                    System.out.println("Have a great day!");
                    keepGoing = false;
                    break;

                default:
                    System.out.println("Invalid choice!");
                    break;
            }


        }
    }
}
