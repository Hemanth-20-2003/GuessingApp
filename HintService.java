/**
 * HintService class
 * Use Case 3: Hint Generation
 * 
 * This class is responsible for generating controlled hints for players based on the number of incorrect attempts. The hint logic is separated
 * from the main game flow to maintain clarity.
 */
public class HintService{

    /**
     * Generates a hint based on the target number and how many hints
     * have already been used.
     *
     * target   : The number the player is trying to guess
     * hintCount: The number of hints already requested
     * return   : A hint string providing partial information
     */
    public static String generateHint(int target, int hintCount){
        if (hintCount == 1) {
            return (target % 2 == 0)
                ? "Hint: Number is EVEN"
                : "Hint: Number is ODD";
        } else if (hintCount == 2) {
            return (target > 50)
                ? "Hint: Number is greater than 50"
                : "Hint: Number is 50 or less";
        }

        return "No more hints available";
    }
}
