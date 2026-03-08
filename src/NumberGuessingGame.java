import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.println("Lets guess a number between 1 and 100, i will try to find it.");
        System.out.println("Please navigate me until i found your guess: hig(h), low(l), correct(c). ");

        boolean keepGoing = true;
        while (keepGoing) {
            System.out.println("---------------------------------------------------------------------------");
            computerGuess(random, scanner);

            System.out.print("Do you want to play again: (yes/no)");
            String response = scanner.nextLine().trim().toLowerCase();
            keepGoing = "yes".equals(response);
        }

        scanner.close();
    }

    public static void computerGuess(Random random, Scanner scanner) {
        int attemps = 0;
        int low = 0;
        int high = 100;
        while (low <= high) {
            int comGuess = random.nextInt(low, high+1);
            System.out.println("Your guess is: | " + comGuess + " |");
            System.out.print("hig(h), low(l), correct(c): ");
            String response = scanner.nextLine().trim().toLowerCase();

            attemps++;
            if ("c".equals(response)) {
                System.out.printf("Your guess is %d, and i found in %d attempts.%n ",comGuess, attemps);
                return;
            } else if ("h".equals(response)) {
                low = comGuess + 1;
            } else if ("l".equals(response)) {
                high = comGuess-1;
            } else {
                System.out.println("Invalid response: ");
                attemps--;
            }
        }
    }


}
