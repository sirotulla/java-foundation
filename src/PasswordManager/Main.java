package PasswordManager;

public class Main {
    public static void main(String[] args) {

        PasswordManager manager = new PasswordManager();
        PasswordManager.loadOrGenerateKey();

        if (manager.initialize()) {
            manager.run();
            manager.saveEntries();
        }

    }

}
