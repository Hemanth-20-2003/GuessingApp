import java.util.Scanner;

/**
 * MAIN CLASS
 *
 * Use Case 5: Game Result Storage
 *
 * This class coordinates the complete game flow and persists the final result after completion.
 *
 * Responsibilities:
 * - Initialize game configuration
 * - Accept and validate user guesses
 * - Generate hints when applicable
 * - Store game result at the end
 *
 * @author Developer
 * @version 5.0
 */
public class GuessingApp{

    public static void main(String[] args) throws InvalidInputException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("===============================");
        System.out.println("Welcome to the Guessing App");
        System.out.println("===============================\n");
        /*
         * Player name is captured once and stored along with game results.
         */
        System.out.print("Enter Player Name: ");
        String player=scanner.nextLine();

        GameConfig config=new GameConfig();
        config.showRules();

        int attempts=0;

        /*
         * Tracks whether the player successfully guessed the number.
         */
        boolean win=false;

        /*
         * Game loop runs until the player exhausts the maximum attempts.
         */
        while(attempts<config.getMaxAttempts()){
            // Example placeholder for gameplay logic
            System.out.print("Enter your guess: ");
            int guess=ValidationService.validateInput(scanner.nextLine());
            attempts++;

			String result=GuessValidator.validateGuess(guess,config.getTargetNumber());
			
			if("CORRECT".equals(result)){
				System.out.println(result);
				win=true;
				break;
			}
			//Print the generated hints
			System.out.println(HintService.generateHint(config.getTargetNumber(),attempts));
			System.out.println(result);
        }

        /*
         * Final game result is persisted
         * after the game loop completes.
         */
        StorageService.saveResult(player,attempts, win);

        scanner.close();
    }
}
