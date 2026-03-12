package WordGuessingGame;

public class Game {

    // Step 1: Base class - Handles core game logic
    protected String wordToGuess;
    protected int attempts;
    protected char[] revealedLetters;

    public Game(String wordToGuess){
        this.wordToGuess = wordToGuess;
        this.attempts = 0;
        this.revealedLetters = new char[wordToGuess.length()];
        for (int i = 0; i < revealedLetters.length; i++){
            revealedLetters[i] = '-';
        }
    }

    public void playGame() {
        System.out.println("Welcome to the Word Guessing Game!");
        System.out.println("Try to guess the word!");
    }

    public void displayHint() {
        System.out.println("Hint: The word has " + wordToGuess.length() + " letters.");
    }

    public String getRevealedWord() {
        return new String(revealedLetters);
    }

}
