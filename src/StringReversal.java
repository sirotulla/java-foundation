import java.util.Scanner;

public class StringReversal {
//    // Variant 1: Recursive method to reverse a string
//    public static String reverseString(String str) {
//        // Base case:
//        if (str.isEmpty() || str.length() == 1) {
//            return str;
//        }
//
//         // Recursive case:
//
//        return str.charAt(str.length() - 1)
//                + reverseString(str.substring(0, str.length() - 1));
//    }

    // Variant 2: Loop method to reverse a string
    public static String reverseString(String str) {
        if (str.isEmpty() || str.length() == 1) {
            return str;
        }

        StringBuilder reversedStr = new StringBuilder();
        for (int i = str.length()-1; i >= 0 ; i--) {
            char ch = str.charAt(i);
            reversedStr.append(ch);
        }
        return reversedStr.toString();
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 2: Ask the user to enter a string
        System.out.println("Enter a string to reflect in the magic mirror:");
        String inputString = scanner.nextLine();
        inputString = inputString.replace(" ", "");
        // Step 3: Reverse the string using the recursive method
        String reversedString = reverseString(inputString);

        // Step 4: Print the reversed string
        System.out.println("The magic mirror reflects: " + reversedString);

        scanner.close();
    }
}
