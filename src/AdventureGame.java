import java.util.Scanner;

public class AdventureGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Welcome message
        System.out.println("Welcome to the Ultimate Adventure Game!");
        System.out.println("Your goal is to find the hidden treasure. Choose wisely!");

        boolean exit = true;
        while (exit) {
            System.out.print("You are at a crossroad. Do you want to go left or right?\n" +
                    "Type 'left' or 'right': ");
            String choice1 = scanner.nextLine().toLowerCase().trim();
            System.out.println("-----------------------------------------------------------------");
            switch (choice1) {
                case "left": // winning way
                    System.out.println("You walk down a dark path and find a mysterious cave.");
                    System.out.print("Do you want to enter the cave or walk past it?\n" +
                            "Type 'enter' or 'walk': ");
                    String choice2 = scanner.nextLine().toLowerCase().trim();
                    System.out.println("-----------------------------------------------------------------");
                    switch (choice2) {
                        case "enter": // winning way
                            System.out.println("Inside the cave, you find a sleeping dragon!");
                            System.out.print("Do you want to fight the dragon or sneak past it?\n" +
                                    "Type 'fight' or 'sneak': ");
                            String choice3 = scanner.nextLine().toLowerCase().trim();
                            System.out.println("-----------------------------------------------------------------");
                            switch (choice3) {
                                case "fight": //losing way
                                    System.out.println("You draw your weapon and attack the dragon.\n" +
                                            "The dragon wakes up angrily and breathes fire!\n" +
                                            "You are no match for the powerful dragon.\n" +
                                            "You were defeated.\n" +
                                            "Game over.");
                                    break;

                                case "sneak": //winning way
                                    System.out.println("You sneak past the dragon and find the treasure behind it. You win!");
                                    break;

                                default:
                                    System.out.println("Invalid choice. You got lost in the wilderness. Game over.");
                            }
                            break;

                        case "walk": // losing way
                            System.out.println("You decide not to enter the cave and continue walking.\n" +
                                    "The path becomes darker and darker.\n" +
                                    "Suddenly, you fall into a hidden trap!\n" +
                                    "There is no way out.\n" +
                                    "Game over.");
                            break;

                        default:
                            System.out.println("Invalid choice. You got lost in the wilderness. Game over.");
                    }
                    break;

                case "right":
                    System.out.println("You take the right path and walk into a quiet forest.");
                    System.out.println("After a while, you see glowing eyes watching you from the shadows.");
                    System.out.print("Do you want to run or investigate?\n" +
                            "Type 'run' or 'investigate': ");
                    String choice4 = scanner.nextLine().toLowerCase().trim();
                    System.out.println("-----------------------------------------------------------------");

                    switch (choice4) {

                        case "run": // losing way
                            System.out.println("You turn around and start running as fast as you can.\n" +
                                    "The creature chases you through the forest.\n" +
                                    "You trip over a tree root and fall.\n" +
                                    "The creature catches up to you.\n" +
                                    "Game over.");
                            break;

                        case "investigate":
                            System.out.println("You slowly move closer to the glowing eyes.\n" +
                                    "It turns out to be a magical fox guarding a treasure chest.");
                            System.out.print("Do you want to open the chest or leave it?\n" +
                                    "Type 'open' or 'leave': ");
                            String choice5 = scanner.nextLine().toLowerCase().trim();
                            System.out.println("-----------------------------------------------------------------");

                            switch (choice5) {

                                case "open": // WIN
                                    System.out.println("You carefully open the chest.\n" +
                                            "Inside, you find the hidden treasure!\n" +
                                            "You win!");
                                    break;

                                case "leave": // losing
                                    System.out.println("You decide not to risk it and walk away.\n" +
                                            "You leave the forest empty-handed.\n" +
                                            "Game over.");
                                    break;

                                default:
                                    System.out.println("Invalid choice. The forest swallows you in darkness. Game over.");
                            }
                            break;

                        default:
                            System.out.println("Invalid choice. You got lost in the wilderness. Game over.");
                    }
                    break;

                default:
                    System.out.println("Invalid choice. You got lost in the wilderness. Game over.");
                    break;
            }

            System.out.println("=================================================================");
            System.out.println("Do you want to play again (yes/no)");
            String play = scanner.nextLine().trim().toLowerCase();

            if (!play.equals("yes")) {
                System.out.println("You typed 'no' or invalid choice. Game stopped");
                exit = false;
            }
        }

        scanner.close();
    }
}
