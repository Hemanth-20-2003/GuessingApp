/**
 * GuessingApp - Use Case 1: Game Initialization
 *
 * @author Developer
 * @version 1.0
 *
 * This class serves as the application entry point.
 * It initializes the game configuration and displays game rules.
 *
 * No user input or gameplay logic is implemented at this stage.
 */
class GuessingApp{
	public static void main(String[] a){
		System.out.println("Welcome to the Guessing App");
		GameConfig gameConfig=new GameConfig();
		gameConfig.showRules();
	}
}