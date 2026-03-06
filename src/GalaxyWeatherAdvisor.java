import java.util.Locale;
import java.util.Scanner;

public class GalaxyWeatherAdvisor {
    public static void main(String[] args) {
        // Step 1: Declare and initialize Scanner object
        Scanner scanner = new Scanner(System.in);

        // Step 2: Display a welcome message
        System.out.println("Welcome to the Galactic Weather Advisor!");
        System.out.println("Please enter the planet you are on (Earth, Mars, Venus, Jupiter):");

        // Step 3: Take user input for planet and convert to lowercase
        System.out.println("Please enter the planet you are on: ");
        String planet = scanner.nextLine().toLowerCase();

        // Step 4: Take current temperature as input
        System.out.println("Please enter the current temperature in Celsius:");
        double temperature = scanner.nextDouble();

        // Step 5: Declare a variable to store response
        String advice = "";

        // Step 6: Compute response based on planet and temperature
        if (planet.equals("earth")) {
            if (temperature < 0) advice = "It’s freezing on Earth. Wear a heavy coat and stay warm!";
            else if (temperature < 10) advice = "Cool weather on Earth. A light jacket should be enough.";
            else if (temperature < 25) advice = "The temperature is pleasant on Earth. Perfect day to go outside!";
            else advice= "It’s very hot on Earth. Stay hydrated and avoid direct sunlight.";

        } else if (planet.equals("mars")) {
            if (temperature < -60) advice = "Extreme cold on Mars! You will need a heated space suit.";
            else if (temperature < -10) advice = "Mars is cold as usual. Stay inside your habitat.";
            else if (temperature < 0) advice = "Mild day on Mars, but still too cold without protection.";
            else advice = "Unexpected warmth on Mars! Check your life-support systems.";

        } else if (planet.equals("venus")) {
            if (temperature > 400) advice = "Venus is extremely hot. Survival outside is impossible!";
            else if (temperature > 200) advice = "The temperature on Venus is dangerously high. Stay in a protected station.";
            else if (temperature > 80) advice = "Even at lower levels, Venus remains scorching hot.";
            else advice = "Venus conditions are intense. Advanced cooling systems are required.";

        } else if (planet.equals("jupyter")) {
            if (temperature < 0) advice = "Jupyter has no solid surface. You cannot stand there!";
            else if (temperature < 10) advice = "The atmosphere of Jupyter is extremely stormy. Be cautious.";
            else if (temperature < 25) advice = "Jupyter's temperature varies greatly. Stay inside your spacecraft.";
            else advice= "Gas giant conditions detected. Exploration requires special equipment.";

        } else advice = "Invalid planet name. Please enter Earth, Mars, Venus, or Jupyter.";

        // Step 7: Display response
        System.out.println(advice);

        // Step 8: Close Scanner
        scanner.close();
    }
}