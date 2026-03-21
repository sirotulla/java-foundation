import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordFrequencyCounter {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        boolean keepEntering = true;
        while(keepEntering) {

            String paraghraph = getString("Enter a paraghraph: ");
            String normalizedText = normalizeText(paraghraph);


            System.out.println("Normalized Text" + normalizedText);
            System.out.println("-----------------------------------");
            String[] words = normalizedText.split(" ");

            HashMap<String, Integer> wordFrequency = new HashMap<>();

            for (String word : words) {
                if (!word.isEmpty()) {
                    wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
                }
            }


            int maxFrequency = 0;
            for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
                if (entry.getValue() > maxFrequency) {
                    maxFrequency = entry.getValue();
                }
            }

            // tie handling
            for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
                if (entry.getValue() == maxFrequency) {
                    System.out.println("-----------------------------------");
                    System.out.println("The " + " frequency word: \"" + entry.getKey() + "\" with frequency: " + maxFrequency);
                }
            }

            // show top 3 word frequency
            wordFrequency.entrySet().stream()
                    .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                            .limit(3)
                                    .forEach(e -> System.out.println("Top word: " + e.getKey() + " Count: " + e.getValue()));

            System.out.println("-----------------------------------");
            String exit = getString("Do you want to continue: (yes/no)").toLowerCase().trim();
            keepEntering = exit.equals("yes");

        }
        System.out.println("Thanks for using the program");
    }


    public static String normalizeText(String text) {
        StringBuilder normalize = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (Character.isLetterOrDigit(ch) || Character.isWhitespace(ch)){
                normalize.append(Character.toLowerCase(ch));
            }
        }
        return normalize.toString().replaceAll("\\s+", " "); // "\\s+" -> removes extra space from text
    }


    public static String getString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

}
