import java.util.Scanner;
public class SimpleChatbot {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("To stop the chat enter (exit):");
        System.out.println("If you want to see the list of keywords, just type (key)");

        boolean exitOfProgram = true;
        while (exitOfProgram) {
            System.out.print("\nChatbot: Please enter something: ");
            String message = scanner.nextLine();

            if (message.equalsIgnoreCase("hello") ||
                    message.equalsIgnoreCase("hi")) {
                System.out.print("Chatbot Hello, How can i help you today! ");

            } else if (message.equalsIgnoreCase("how are you") ||
            message.equalsIgnoreCase("how is it going")) {
                System.out.println("Chatbot: I'm just a bot, but I'm here to help you");

            } else if (message.equalsIgnoreCase("weather")) {
                System.out.print("Chatbot: I haven't real-life data," +
                        " but in the digital world the weather is always sunny");

            } else if (message.equalsIgnoreCase("exit")) {
                System.out.print("Chatbot: Thank you for using the chatbot.");
                exitOfProgram = false;

            } else if (message.equalsIgnoreCase("by") ||
                    message.equalsIgnoreCase("good by")) {
                System.out.print("Chatbot: Good by, See you later.");
                exitOfProgram = false;

            } else if (message.equalsIgnoreCase("key")) {
                System.out.println("Chatbot keywords: \n" +
                        "\tKey \n" +
                        "\tHello \n" +
                        "\tHi \n" +
                        "\tWeather \n" +
                        "\tHow are you \n" +
                        "\tHow is it going \n" +
                        "\tBy \n" +
                        "\tGood by \n" +
                        "\tExit");

            } else {
                System.out.print("Chatbot: Sorry i confused, I did not recognize that key." +
                        " \nTo see the list of keywords type (key)");
            }
        }
        scanner.close();
    }
}