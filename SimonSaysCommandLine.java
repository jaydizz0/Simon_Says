import java.util.ArrayList;
import java.util.Scanner;
public class SimonSaysCommandLine {
    private SimonSays simonSays = new SimonSays();
    public void startGame(){
        while (simonSays.getLives() > 0) {
            Scanner input = new Scanner(System.in);
            String[] colourSequence = simonSays.generateColorSequence(simonSays.getRound());
            String[] userInputSequence = new String[simonSays.getRound()];
            simonSays.getColorSequence();

            simonSays.updateScore();
            
        }
    }

    public void playGame(int round, ArrayList<String> userInputSequence, String[] colourSequence, int score, int lives, Scanner input) {
        // for (int z = 0; z < round; z++) {
        //     System.out.print("Enter your sequence one at a time: ");
        //     userInputSequence[z] = input.nextLine();
        //     if (!simonSays.checkSequence(userInputSequence, colourSequence)) {
        //         System.out.println("WRONG Try again");
        //         lives--;
        //         userInputSequence[z] = " ";

        //         if (lives == 0) {
        //             System.out.println("You Lost!");
        //             simonSays.updateHighScore();
        //             System.out.println("Current High Score: " + simonSays.getHighScore());
        //             if(!simonSays.playAgain()) {
        //                 System.exit(0);
        //             } else {
        //                 break;
        //             }
        //         }
        //         z--;
        //         continue;
        //     } else {
        //         continue;  
        //     }
        }
}

// Need to start game in a meathod in the UI