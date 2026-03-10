import java.util.Scanner;

public class LuckyDiceAdventure {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Lucky Dice Adventure!");
        System.out.print("Enter the target score to win: ");
        int targetScore = scanner.nextInt();
        scanner.nextLine();
        Game game = new Game(targetScore);

        boolean playing = true;
        while (playing) {
            System.out.println("----------------------------------------------");
            System.out.print("Press 'r' to roll the dice, 's' to stop:");
            char rollOrStop = scanner.next().charAt(0);
            switch (rollOrStop) {
                case 'r':
                    game.rollDice();
                    game.displayScore();
                    if (game.isTargetReached()){
                        System.out.println("Congratulations! You've reached the target score!");
                        playing = false;
                    }
                    break;

                case 's':
                    System.out.println("You chose to stop. Final Score: ");
                    game.displayScore();
                    playing = false;
                    break;

                default:
                    System.out.println("Invalid choice: (roll 'r', stop 's')");
                    break;
            }

        }

        scanner.close();

        //Welcome to Lucky Dice Adventure!
        //Enter the target score to win: 20
        //Press 'r' to roll the dice, 's' to stop:
        //r
        //Dice 1: 3
        //Dice 2: 5
        //Current Score: 8
        //Target Score: 20
        //
        //Press 'r' to roll the dice, 's' to stop:
        //r
        //Dice 1: 2
        //Dice 2: 2
        //You rolled a double! Bonus points added.
        //Current Score: 22
        //Target Score: 20
        //
        //Congratulations! You've reached the target score!
    }
}
