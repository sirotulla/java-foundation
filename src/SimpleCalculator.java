import java.util.Scanner;

public class SimpleCalculator {

    public static void main(String[] args) {
        // Create a scanner object to take user input
        Scanner scanner = new Scanner(System.in);
        String continueCalculator;

        do {
            System.out.println("Enter the first number: ");
            double num1 = scanner.nextDouble();

            System.out.println("Enter the second number: ");
            double num2 = scanner.nextDouble();
            scanner.nextLine();

            System.out.println("Choose an operation (+, -, *, /): ");
            String sign = scanner.nextLine().trim();

            double result = 0;

            if ("+".equals(sign)) {
                result += num1 + num2;

            } else if ("-".equals(sign)) {
                result += num1 - num2;

            } else if ("*".equals(sign)) {
                result += num1 * num2;

            } else if ("/".equals(sign)) {
                result += num1 / num2;
            } else {
                System.out.println("Incorrect operation! Try again!");
            }
            System.out.println("Result: " + result);

            System.out.println("Do you want to perform another calculation? (yes/no): ");
            continueCalculator = scanner.nextLine().trim().toLowerCase();


        } while ("yes".equals(continueCalculator));
        System.out.println("Calculator session ended. Goodbye!");

        scanner.close();
    }
}