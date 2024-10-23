import java.util.Random;
import java.util.Scanner;

public class CrapsGame {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random rnd = new Random();
        boolean playAgain = true;

        System.out.println("Welcome to the Craps Game!");

        // Game loop: Repeats if the user chooses to play again
        while (playAgain) {
            int die1 = rollDie(rnd); // Roll first die
            int die2 = rollDie(rnd); // Roll second die
            int sum = die1 + die2;   // Calculate the sum of dice

            System.out.printf("You rolled: %d + %d = %d%n", die1, die2, sum);

            // Case i and ii: Check for an instant win or loss on the first roll
            if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("Craps! You lose.");
            } else if (sum == 7 || sum == 11) {
                System.out.println("Natural! You win.");
            } else {
                // Case iii: Set the point and keep rolling until point or 7 is hit
                int point = sum;
                System.out.printf("The point is now set to %d.%n", point);

                boolean rollingForPoint = true;
                while (rollingForPoint) {
                    die1 = rollDie(rnd);
                    die2 = rollDie(rnd);
                    sum = die1 + die2;

                    System.out.printf("You rolled: %d + %d = %d%n", die1, die2, sum);

                    if (sum == point) {
                        System.out.println("You made the point! You win.");
                        rollingForPoint = false; // Exit the point-rolling loop
                    } else if (sum == 7) {
                        System.out.println("You rolled a 7! You lose.");
                        rollingForPoint = false; // Exit the point-rolling loop
                    } else {
                        System.out.println("Trying for the point...");
                    }
                }
            }

            // Prompt user to play again
            System.out.print("Do you want to play again? (y/n): ");
            String response = in.nextLine();
            playAgain = response.equalsIgnoreCase("y");
        }

        System.out.println("Thanks for playing Craps!");
        in.close(); // Close the scanner
    }

    // Helper method to roll a die (1-6)
    public static int rollDie(Random rnd) {
        return rnd.nextInt(6) + 1;
    }
}
