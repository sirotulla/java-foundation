package PasswordValidator;

public class PasswordMismatchedException extends Exception {
    public PasswordMismatchedException(String message) {
        super(message);
    }
}
