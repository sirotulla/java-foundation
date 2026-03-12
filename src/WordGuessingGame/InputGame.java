package WordGuessingGame;

import java.util.Scanner;

public class InputGame extends Game{

    protected Scanner scanner;

    public InputGame(String wordToGuess) {
        super(wordToGuess);
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void playGame() {
        super.playGame();
        String userGuess = "";
        while(!userGuess.equalsIgnoreCase(wordToGuess)) {

            displayHint();
            System.out.println("Enter your guess: ");
            userGuess = scanner.nextLine();
            attempts++;

            if (userGuess.equalsIgnoreCase(wordToGuess)) {
                System.out.println("🎉 Congratulations! You've guessed the word in " + attempts + " attempts.");
            } else {
                System.out.println("❌ Incorrect guess. Try again!");
                System.out.println("Revealed so far: " + getRevealedWord());
            }

        }
    }
}
