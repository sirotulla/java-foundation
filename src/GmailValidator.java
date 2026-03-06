import java.util.Scanner;

public class GmailValidator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an email address to validate:");
        String email = scanner.nextLine();

        if (isValidationTrue(email)){
            System.out.println("The email address is valid.");
        } else {
            System.out.println("The email address is invalid.");
        }



    }


    public static boolean isValidationTrue(String email) {
        //Check if the email contains exactly one '@'.
        int isContain = 0;

        for (int i = 0; i < email.length(); i++) {
            char letter = email.charAt(i);
            if (letter == '@'){
                isContain++;
            }
        }
        if (isContain != 1) {
            return false;
        }

        //Ensure there are characters before and after the '@'.
        int atIndex = email.indexOf('@');
        if (atIndex < 1 || atIndex > email.length()-1) {
            return false;
        }

        //Verify there is at least one '.' after the '@'.
        String domainPart = email.substring(atIndex+1);
        if (!domainPart.contains(".")){
            return false;
        }

        //Check that the '.' is not the first or last character after the '@'.
        int dotIndex = domainPart.indexOf(".");
        if (dotIndex < 1 || dotIndex == domainPart.length()-1) {
            return false;
        }

        //Ensure there are no spaces in the email.
        if (email.contains(" ")){
            return false;
        }

        return true;
    }





}
