package PasswordValidator;

import java.util.Scanner;

public class UserRegistration {
    protected boolean isFailure = false;
    public void registerUser(String password, String confirmPassword) {
        try (ValidationLogger logger = new ValidationLogger()) {
            PasswordValidator validator = new PasswordValidator();
            validator.validatePassword(password, confirmPassword);
            logger.logSuccess();
            isFailure = true;
        } catch (WeakPasswordException | PasswordMismatchedException e) {
            try (ValidationLogger logger = new ValidationLogger()) {
                logger.logFailure("Password did not mismatch.");
            }
        } finally {
            try (ValidationLogger logger =  new ValidationLogger()) {
                logger.close();
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserRegistration registration = new UserRegistration();


        while (!registration.isFailure) {
            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            System.out.print("Confirm password: ");
            String confirmPassword = scanner.nextLine();

            registration.registerUser(password, confirmPassword);
        }
        scanner.close();
    }


}
