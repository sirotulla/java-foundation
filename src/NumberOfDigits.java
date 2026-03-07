import java.util.Scanner;

public class NumberOfDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        int numOfDigits = countDigits(number);

        System.out.printf("The digits of %d is: %d", number, numOfDigits);
        scanner.close();
    }

    public static int countDigits(int num) {
        int piece = 0;
        // Base case
        if (num < 10 && num > -10){
            return 1;
        }
        // Recursive case
        return 1 + countDigits(num/10);
    }

}
