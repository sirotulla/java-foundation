import java.util.Random;

public class Question {
    // Step 1: Defines a Question class to generate
    // arithmetic questions and validate answers.

    private int operand1;
    private int operand2;
    private char operator;
    private double correctAnswer;

    // Constructor to generate a random arithmetic question
    public Question(int choice){
        Random random = new Random();
        switch (choice) {
            case 1:
                this.operand1 = random.nextInt(10)+1;
                this.operand2 = random.nextInt(10)+1;
                break;
            case 2:
                this.operand1 = random.nextInt(11, 50)+1;
                this.operand2 = random.nextInt(11, 50)+1;
                break;
            case 3:
                this.operand1 = random.nextInt(51, 100)+1;
                this.operand2 = random.nextInt(51, 100)+1;
                break;
            case 4:
                this.operand1 = random.nextInt(100)+1;
                this.operand2 = random.nextInt(100)+1;
                break;
        }


        char[] operators = {'+', '-', '*', '/'};
        this.operator = operators[random.nextInt(4)];
        calculateAnswer();
    }

    // Step 2: Implement method to calculate the correct answer
    private void calculateAnswer() {
        switch (operator) {
            case '+':
                correctAnswer = operand1 + operand2;
                break;
            case '-':
                correctAnswer = operand1 - operand2;
                break;
            case '*':
                correctAnswer = operand1 * operand2;
                break;
            case '/':
                correctAnswer = (double) operand1 / operand2;
                break;
        }
    }

    // Step 3: Method to display the generated question
    public void generateQuestion() {
        System.out.println("What is " + operand1 + " "
                + operator + " " + operand2 + "?");
    }

    // Step 4: Method to check if the user's answer is correct
    public boolean checkAnswer(double userAnswer) {
        return Math.abs(userAnswer - correctAnswer) < 0.001; // allowing
        // a small tolerance for floating-point answers
    }

}
