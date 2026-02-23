import java.util.Scanner;

/**
 * MAIN CLASS
 *
 * Use Case 6: Game Restart & Exit
 *
 * This class coordinates the complete game lifecycle, allowing the player to replay or exit gracefully.
 *
 * Responsibilities:
 * - Start a new game session
 * - Execute the guessing flow
 * - Persist game results
 * - Restart or exit based on user choice
 *
 * @author Developer
 * @version 6.0
 */
public class GuessingApp{

    public static void main(String[] args) throws InvalidInputException{
        Scanner scanner = new Scanner(System.in);
		boolean restart;
        System.out.println("===============================");
        System.out.println("Welcome to the Guessing App");
        System.out.println("===============================\n");
        /*
         * Player name is captured once and stored along with game results.
         */
		do{
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

			// Final game result is persisted  after the game loop completes.
			StorageService.saveResult(player,attempts, win);
			
			//Player decides whether to restart the game or exit.
			
			restart=GameController.restartGame(scanner);
		}while(restart);
        scanner.close();
    }
}
