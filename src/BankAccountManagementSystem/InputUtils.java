package BankAccountManagementSystem;

import java.util.Scanner;

public final class InputUtils {

    public static final Scanner scanner = new Scanner(System.in);

    private InputUtils(){}

    public static String getString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }


    public static int getInt(String prompt) {
        System.out.print(prompt);
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Please enter a valid integer: ");
            }
        }
    }


    public static double getDouble(String prompt) {
        System.out.print(prompt);
        while(true) {
            try {
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Please enter a valid number: ");
            }
        }
    }

}
