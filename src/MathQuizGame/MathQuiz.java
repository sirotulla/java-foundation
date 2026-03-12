package MathQuizGame;

import java.util.Scanner;

public class MathQuiz {
    //Step 5: Defines a MathQuiz class to run
    // a five-question quiz and track the user's score.
    private int score;
    private int choice;

    public MathQuiz(){
        this.score = 0;
    }

    // Step 6: Implement method to start the quiz
    public void startQuiz() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many quiz you want to solve: ");
        int numOfTest = scanner.nextInt();
        scanner.nextLine();

        System.out.println("1. easy (1-10)" +
                "\n2. medium (11-50)" +
                "\n3. hard (51-100)" +
                "\n4. mix (1-100)");
        boolean isChoiceCorrect = true;
        while (isChoiceCorrect) {
            System.out.print("Enter difficulty level: ");
            choice = scanner.nextInt();
            if (choice > 0 && choice < 5) {
                isChoiceCorrect = false;
            } else {
                System.out.println("Incorrect choice: try (1/2/3/4)");
            }
        }

        for (int i = 0; i < numOfTest; i++) {
            askQuestion(scanner);
        }

        System.out.println("Your final score is: " + score + "/" + numOfTest);
        scanner.close();
    }

    // Step 7: Implement method to generate a question,
    // get user input, and check the answer
    private void askQuestion(Scanner scanner) {
        Question question = new Question(choice);
        question.generateQuestion();

        System.out.print("Your answer: ");
        double userAnswer = scanner.nextDouble();

        if(question.checkAnswer(userAnswer)) {
            System.out.println("Correct!");
            score++;
        } else {
            System.out.println("Incorrect");
        }
    }

}
