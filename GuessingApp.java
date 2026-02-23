import java.util.Scanner;
/**
 * MAIN CLASS
 *
 * Coordinates the game flow:
 * 1. Initialize game
 * 2. Accept user guesses
 * 3. Validate guesses
 * 4. Provide hints
 * 5. Stop when game ends
 *
 * @author Developer
 * @version 3.0
 */
public class GuessingApp{

    public static void main(String[] args){

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
			int guess =scanner.nextInt();
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
