import java.util.Scanner;

public class EncoderDecoderGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Encoder-Decoder Game!");
        String text = "";
        boolean keepGoing = true;
        while (keepGoing) {
            System.out.println("1. Encode a string\n" +
                    "2. Decode a string");
            System.out.print("Choose an option (1 or 2): ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            System.out.println("------------------------------------------------------------");

            if (choice == 1 || choice == 2) {
                System.out.print("Enter the string: ");
                text = scanner.nextLine();
            }

            switch (choice) {
                case 1:
                    text = encoder(text, 0);
                    System.out.println("Encoded string: " + text);
                    break;
                case 2:
                    text = decoder(text, 0);
                    System.out.println("Dncoded string: " + text);
                    break;
                default:
                    System.out.println("Invalid option. ");
                    break;
            }

            System.out.println("------------------------------------------------------------");
            System.out.print("Do you want to continue or exit: (yes/no): ");
            String response = scanner.nextLine().trim().toLowerCase();
            keepGoing = response.equals("yes");
            System.out.println();
        }
        scanner.close();
    }


    public static String encoder(String input, int index) {
        if (index == input.length()) {
            return "";
        }
        char ch = input.charAt(index);
        char encodedChar = atBash(ch);
        return encodedChar + encoder(input, index+1);
    }


    public static String decoder(String input, int index) {
        if (index == input.length()){
            return "";
        }
        char ch = input.charAt(index);
        char decodedChar = atBash(ch);
        return decodedChar + decoder(input, index+1);
    }


    public static char atBash(char ch){
        // a=97, z=122
        // A=65, Z=90
        if (ch >= 'a' && ch <= 'z') {
            return (char) ('z' - (ch - 'a'));
        }else if (ch >= 'A' && ch <= 'Z') {
            return (char) ('Z' - (ch - 'A'));
        } else {
            return ch;
        }
    }


}
