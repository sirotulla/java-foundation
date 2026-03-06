import java.util.Scanner;

public class RearrangeArray {
    public static void main(String[] args) {

        // rearranging array
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the length of array: ");
        int lengthOfArray = scanner.nextInt();
        scanner.nextLine();
        int num;

        int[] numbers = new int[lengthOfArray];

        // adding numbers to array
        for (int i = 0; i < lengthOfArray; i++) {
            System.out.print("Enter the " + (i + 1) + " number: ");
            num = scanner.nextInt();
            scanner.nextLine();
            numbers[i] = num;
        }

        System.out.println("Original array: ");
        for (int i : numbers) {
            System.out.print(i + " ");
        }

        int[] rearranged = new int[numbers.length];

        if (lengthOfArray % 2 == 0) {  // even array situation
            int halfArray = numbers.length / 2;

            for (int i = 0; i < halfArray; i++) {
                rearranged[2 * i] = numbers[i];
                rearranged[2 * i + 1] = numbers[i + halfArray];
            }

            System.out.println("\nRearranged array: ");
            for (int i : rearranged) {
                System.out.print(i + " ");
            }

        } else { // odd array situation
            int halfArray = (numbers.length + 1) / 2;

            for (int i = 0; i < numbers.length / 2; i++) {
                rearranged[2 * i] = numbers[i];
                rearranged[2 * i + 1] = numbers[i + halfArray];
            }

            rearranged[numbers.length - 1] = numbers[halfArray - 1];

            System.out.println("\nRearranged array: ");
            for (int i : rearranged) {
                System.out.print(i + " ");
            }
        }
    }

}


