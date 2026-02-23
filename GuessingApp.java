import java.util.Scanner;
/**
 * MAIN CLASS
 * Use Case 4 : Error Handling & ValidationEvent
 *
 * Coordinates the game flow:
 * 1. Initialize game
 * 2. Accept user input
 * 3. Validate input using ValidationService
 * 4. Validate guesses
 * 5. Provide hints
 * 6. Stop when game ends
 *
 * @author Developer
 * @version 4.0
 */
public class GuessingApp{

    public static void main(String[] args) throws InvalidInputException{

        System.out.println("Welcome to the Guessing App");

        GameConfig config = new GameConfig();
        config.showRules();

        Scanner scanner = new Scanner(System.in);
        int attempts = 0;

        /*
         * Game loop runs until the player
         * exhausts the maximum attempts.
         */
        while(attempts<config.getMaxAttempts()){ 
			System.out.print("Enter your guess: ");
			//Validating the user input
			int guess =ValidationService.validateInput(scanner.nextLine());
			attempts++;
			
			String result= GuessValidator.validateGuess(guess,config.getTargetNumber());
			
			if("CORRECT".equals(result)){
				System.out.println(result);
				break;
			}
			//Print the generated hints
			System.out.println(HintService.generateHint(config.getTargetNumber(),attempts));
			System.out.println(result);
			
		
		}
    }
}
