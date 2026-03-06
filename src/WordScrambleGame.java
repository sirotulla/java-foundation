import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class WordScrambleGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String[] wordList = {
                "apple", "table", "chair", "bread", "plant",
                "orange", "window", "flower", "planet", "garden",
                "computer", "keyboard", "internet", "database", "software"
        };
        System.out.println("Welcome to the Word Scramble Game!\n\n" +
                "In this game, a word will appear with its letters mixed up.\n" +
                "Your task is to guess the correct word.\n\n" +
                "Type your answer and press Enter.\n" +
                "Good luck and have fun!");
        System.out.println("-------------------------------------------------------");

        int score = 0;
        boolean conGame = true;
        while (conGame) {

            String word = wordList[random.nextInt(wordList.length)];
            String newWord = shuffleWord(word);
            int attempt = 3;
            for (int i = 0; i < 3; i++) {
                System.out.println("Scramble word: " + newWord);

                System.out.print("Enter your guess: ");
                String userGuess = scanner.nextLine();
                if (word.equals(userGuess)) {
                    score++;
                    System.out.println("Amazing you found");
                    System.out.println("Your current score:" + score);
                    System.out.println("-------------------------------------------------------");
                    break;
                } else {
                    attempt--;
                    System.out.println("Wrong guess, try again");
                    System.out.println("You have left " + attempt + " attempts");
                    if (attempt == 0) {
                        System.out.println("You can't found");
                        System.out.println("Your current score:" + score);
                    }
                }
                System.out.println("-------------------------------------------------------");

            }

            System.out.println("Do you want to continue: (yes/no)");
            String choice = scanner.nextLine().trim().toLowerCase();

            if (!choice.equals("yes")){
                conGame = false;
            }

        }

        scanner.close();
    }

    public static String shuffleWord(String word) {
        Random random = new Random();
        char[] letters = word.toCharArray();
        for (int i = letters.length - 1; i > 0 ; i--) {
            int j = random.nextInt(i + 1);

            char temp = letters[i];
            letters[i] = letters[j];
            letters[j] = temp;
        }
        return new String(letters);
    }

}
