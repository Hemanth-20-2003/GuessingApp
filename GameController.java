import java.util.Scanner;

/**
 * GameController class
 * --------------------
 * This class is responsible for handling the game lifecycle decisions.
 * Specifically, it asks the player whether they want to restart the game after completion or exit the application.
 */
class GameController {

    /**
     * restartGame method
     * ------------------
     * Prompts the player with a yes/no question to determine if they want to play again.
     *
     * @param scanner A Scanner object used to read user input from the console.
     * @return true if the player types "yes" (case-insensitive),
     *         false if the player types anything else (including "no").
     */
    public static boolean restartGame(Scanner scanner) {
        // Display the prompt to the player
        System.out.print("Do you want to play again? (yes/no): ");

        // Read the player's response
        String response = scanner.nextLine();

        // Check if the response is "yes" (ignoring case sensitivity)
        return response.equalsIgnoreCase("yes");
    }
}
