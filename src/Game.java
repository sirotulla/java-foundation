public class Game {
    private Dice dice1;
    private Dice dice2;
    private int score;
    private int targetScore;

    // Step 4: Constructor to initialize the game with a target score
    public Game(int targetScore) {
        this.dice1 = new Dice();
        this.dice2 = new Dice();
        this.score = 0;
        this.targetScore = targetScore;
    }


    // Step 5: Method to roll both dice and update the score
    public void rollDice() {
        dice1.roll();
        dice2.roll();
        System.out.println("Dice1: " + dice1.getValue());
        System.out.println("Dice2: " + dice2.getValue());

        this.score += dice1.getValue() + dice2.getValue();

        // Step 6: Check for doubles and add bonus points
        if (dice1.getValue() == dice2.getValue()) {
            System.out.println("You rolled a double! Bonus points added.");
            score += 10;
        }

    }


    // Step 7: Method to display the current score
    public void displayScore(){
        System.out.println("Current Score: " + this.score);
        System.out.println("Target Score: " + this.targetScore);
    }

    // Step 8: Method to check if the target score is reached
    public boolean isTargetReached(){
        return this.score >= this.targetScore;
    }

}
