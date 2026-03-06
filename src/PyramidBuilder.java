import java.util.Scanner;

public class PyramidBuilder {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Star Pyramid Builder");

        // user input
        System.out.print("Enter the number of levels: ");
        int levels = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter a character to build a pyramid: ");
        char material = scanner.nextLine().charAt(0);

        System.out.print("Enter your choice (empty/full) pyramid: ");
        String choice = scanner.nextLine().toLowerCase().trim();

        // use loops to print the pyramid
        for (int i = 1; i <= levels; i++) {

            for (int j = 0; j < levels - i; j++) {
                System.out.print(" ");
            }

            if (choice.equals("empty")) {
                for (int k = 0; k < (2 * i - 1); k++) {

                    if (k == 0 || k == 2 * i - 2) {
                        System.out.print(material);

                    } else if (i == levels) {
                        System.out.print(material);

                    } else {
                        System.out.print(" ");
                    }
                }

            } else {
                for (int k = 0; k < (2 * i - 1); k++) {
                    System.out.print(material);
                }
            }
            System.out.println();
        }


        scanner.close();
    }
}
