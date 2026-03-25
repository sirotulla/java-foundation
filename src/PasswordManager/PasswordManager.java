package PasswordManager;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.util.*;

public class PasswordManager {
    private static final String FILE_NAME = "src/PasswordManager/password.dat";
    private static final String KEY_FILE_NAME = "src/PasswordManager/aeskey.dat";
    private static SecretKey secretKey;
    private String encryptedMasterPassword;
    private List<PasswordEntry> entries = new ArrayList<>();


    public static void loadOrGenerateKey() {
        File keyFile = new File(KEY_FILE_NAME);
        if(keyFile.exists()) {
            try (FileInputStream fis = new FileInputStream(keyFile)) {

                byte[] keyBytes = fis.readAllBytes();
                secretKey = new SecretKeySpec(keyBytes, "AES");

            } catch (Exception e) {
                throw new RuntimeException("Error loading encryption key", e);
            }
        } else {
            try {
                KeyGenerator keyGen = KeyGenerator.getInstance("AES");
                keyGen.init(128);
                secretKey = keyGen.generateKey();

                try (FileOutputStream fos = new FileOutputStream(KEY_FILE_NAME)) {
                    fos.write(secretKey.getEncoded());
                }

            } catch (Exception e) {
                throw new RuntimeException("Error generating encryption key", e);
            }
        }
    }


    public boolean initialize() {
        File file = new File(FILE_NAME);
        if(!file.exists()) {
            System.out.println("No master password found. " +
                    "Setting up a new master password.");
            setMasterPassword();
        } else {
            this.loadEntries();
            if (!authenticate()) return false;
        }
        return true;
    }


    private void setMasterPassword() {
        String masterPassword = InputUtils.getString("Set your Master Password: ");

        this.encryptedMasterPassword = encrypt(masterPassword);
        saveEntries();

    }


    private boolean authenticate(){
        String encryptedEnteredPassword = encrypt(InputUtils.getString(
                "Enter Master Password: "));
        return encryptedMasterPassword.equals(encryptedEnteredPassword);
    }


    public void saveEntries() {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {

            oos.writeObject(encryptedMasterPassword);
            oos.writeObject(entries);

        } catch (IOException e) {
            System.out.println("Error saving passwords: " + e.getMessage());
        }
    }


    private void loadEntries() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            this.encryptedMasterPassword = (String) ois.readObject();
            entries = (List<PasswordEntry>) ois.readObject();

        } catch (FileNotFoundException e) {
            System.out.println("No saved passwords found. Starting fresh.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading password: " + e.getMessage());
        }
    }


    private String encrypt(String data) {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encryptedBytes = cipher.doFinal(data.getBytes());
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            throw new RuntimeException("Error encrypting data", e);
        }
    }


    private String decrypt(String encryptedData) {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedData));
            return new String(decryptedBytes);
        } catch (Exception e) {
            throw new RuntimeException("Error decrypting data", e);
        }
    }


    private void addPassword() {
        String account = InputUtils.getString("Enter Account Name: ");
        String username = InputUtils.getString("Enter Username: ");
        String password = InputUtils.getString("Enter Password: ");

        String encryptedPassword = encrypt(password);
        PasswordEntry entry = new PasswordEntry(account, username, encryptedPassword);
        entries.add(entry);

        System.out.println("Password added successfully.");
    }


    private void viewPassword() {
        if (entries.isEmpty()) {
            System.out.println("List is empty.");
        } else {
            for (PasswordEntry entry : entries) {
                String decryptedPassword = decrypt(entry.getEncryptedPassword());
                System.out.println("\nAccount: " + entry.getAccountName());
                System.out.println("Username: " + entry.getUsername());
                System.out.println("Password: " + decryptedPassword);
            }
        }
    }


    private void removePassword() {
        String accountName = InputUtils.getString("Enter account name to remove: ");

        boolean removed = entries.removeIf(entry ->
                entry.getAccountName().equalsIgnoreCase(accountName));

        if (removed) {
            System.out.println("Password removed successfully.");
        } else {
            System.out.println("Account not found.");
        }

    }


    public void run() {
        while(true) {
            System.out.println("\n=============Password Manager=============");
            System.out.println("1. Add Password");
            System.out.println("2. View Passwords");
            System.out.println("3. Remove Password");
            System.out.println("4. Exit");
            int choice = InputUtils.getInt("Choose an option: ");
            switch (choice) {
                case 1:
                    System.out.println("-----------Add Password-----------");
                    addPassword();
                    break;
                case 2:
                    System.out.println("-----------View Password-----------");
                    viewPassword();
                    break;
                case 3:
                    System.out.println("-----------Remove Password-----------");
                    removePassword();
                    break;
                case 4:
                    System.out.println("Program is stopping...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;

            }
        }
    }


}
