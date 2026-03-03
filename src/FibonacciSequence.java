import java.util.Scanner;

public class FibonacciSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome! This program help you to calculate fibonacci sequence.");
        // fibonacci sequence
        // 0 1 1 2 3 5 8 13

        System.out.print("Enter the number of terms: ");
        int number = scanner.nextInt();

        int firstTerm = 0, secondTerm = 1, nextTerm;

        if (number == 1){
            System.out.println(firstTerm);
        } else {
            System.out.print(firstTerm + " " + secondTerm);
            for (int i = 3; i <= number ; i++) {
                nextTerm = (firstTerm + secondTerm);
                System.out.print(" " + nextTerm);
                firstTerm = secondTerm;
                secondTerm = nextTerm;

            }
        }

        scanner.close();
    }
}




