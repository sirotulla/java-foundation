import java.util.Scanner;

public class BudgetTrackerPlus {
    public static void main(String[] args) {
        /*Enter your monthly income: $5000
Enter your monthly rent: $1500
Enter your monthly groceries expense: $600
Enter your monthly transportation expense: $300
Enter your monthly entertainment expense: $400

********** Budget Summary **********
Monthly Income: $5000.00
Total Expenses: $2800.00
Remaining Budget: $2200.00
Expenses Breakdown:
  Rent: $1500.00 (30.00% of income)
  Groceries: $600.00 (12.00% of income)
  Transportation: $300.00 (6.00% of income)
  Entertainment: $400.00 (8.00% of income)
************************************
*/
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Budget Tracer Plus");

        System.out.print("Enter your monthly income: $");
        double income = scanner.nextDouble();

        System.out.print("Enter your monthly rent: $");
        double rent = scanner.nextDouble();

        System.out.print("Enter your monthly groceries expense: $");
        double groceries = scanner.nextDouble();

        System.out.print("Enter your monthly transportation expense: $");
        double transportation = scanner.nextDouble();

        System.out.print("Enter your monthly entertainment expense: $");
        double entertainment = scanner.nextDouble();

        double totalExpense = rent + groceries + transportation + entertainment;
        double remainingBudget = income - totalExpense;
        double rentPercentage = (rent / income) * 100;
        double groceriesPercentage = (groceries / income) * 100;
        double transportationPercentage = (transportation / income) * 100;
        double entertainmentPercentage = (entertainment / income) * 100;

        System.out.println("\n********** Budget Summary **********");
        System.out.printf("Monthly Income: $%.2f %n", income);
        System.out.printf("Total Expenses: $%.2f %n", totalExpense);
        System.out.printf("Remaining Budget: $%.2f %n%n", remainingBudget);

        System.out.println("Expenses Breakdown:");
        System.out.printf("   Rent: $%.2f (%.2f%% of income) %n", rent, rentPercentage);
        System.out.printf("   Groceries: $%.2f (%.2f%% of income) %n", groceries, groceriesPercentage);
        System.out.printf("   Transportation: $%.2f (%.2f%% of income) %n", transportation, transportationPercentage);
        System.out.printf("   Entertainment: $%.2f (%.2f%% of income) %n", entertainment, entertainmentPercentage);

        System.out.println("************************************");

        scanner.close();

    }
}
