import java.util.Random;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
public class SimonSays {

    private int score;
    private int round;
    private int lives;
    private String[] colorArray;
    private String[] colorSequence;
    private ArrayList<String> userInputSequence;
    private int highScore;
    Scanner input = new Scanner(System.in);

    public SimonSays() {
        this.score = 0;
        this.round = 1;
        this.lives = 3;
        this.colorArray = new String[]{"Red", "Green", "Blue", "Yellow"};
        this.highScore = 0;
        this.userInputSequence = new ArrayList<>();

    }


    public String[] generateColorSequence(int round) {
        String[] colorSequence = new String[round];
        for (int i = 0; i < round; i++) {
            colorSequence[i] = pickColor(colorArray);
        }
        return colorSequence;
    }

    public boolean checkSequence(ArrayList<String> userSequence, String[] colourSequence) {
        for (int i = 0; i <  round; i++) {
            if (!userSequence.get(i).equals(colourSequence[i])) {
                return false;
            }
        }
        return true;
    }

    public void updateHighScore(int newScore) {
        try {
            // Read from file
            File file = new File("Highscore.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String currentHighScoreString = reader.readLine();
            reader.close();

            // Convert String to int
            int currentHighScore = Integer.parseInt(currentHighScoreString);

            // Compare new score with current high score
            if (newScore > currentHighScore) {
                // Write new high score to file
                currentHighScore = newScore;
                BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                writer.write(Integer.toString(newScore));
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getHighScore() {
        try {
            // Read from file
            File file = new File("Highscore.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String currentHighScoreString = reader.readLine();
            reader.close();
    
            // Convert String to int
            highScore = Integer.parseInt(currentHighScoreString);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return highScore;
    }

    public boolean loseLife() {
        lives--;
        if (lives == 0) {
            return true;
        }
        return false;
    }

    public void updateScore() {
        score++;
    }

    public void nextRound(){
        round++;
    }
    public int getScore() {
        return score;
    }

    public int getRound() {
        return round;
    }

    public int getLives() {
        return lives;
    }

    public String getColor(int index) {
        return colorArray[index];
    }

    public String[] getColorSequence() {
        return colorSequence;
    }

    public ArrayList<String> getUserInputSequence(){
        return userInputSequence;
    }

   

    public int resetScore(){
        score = 0;
        return score;
        
    }
    public int resetRound(){
        round = 1;
        return round;
        
    }
    public String pickColor(String[] colors) {
        Random rand = new Random();
        int randomIndex = rand.nextInt(colors.length);
        return colors[randomIndex];
    }

    public boolean playAgain(){
        System.out.print("Want to play again?(Yes/No)");
        String play = input.nextLine();
        return play.equalsIgnoreCase("yes");
    }
    
    public void reset(){
        lives = 3;
        round = 1;
        score = 0;
    }

    public void lostLife(){
        lives = lives - 1;
    }

    public void startGame() {
        colorSequence = generateColorSequence(round);
        userInputSequence.clear();
    }

    
  
    public SimonSaysRoundState getRoundState(ArrayList<String> userSequence, String[] colorSequence) {
        for (int i = 0; i < userSequence.size(); i++) {
            if (!userSequence.get(i).equalsIgnoreCase(colorSequence[i])) {
                return SimonSaysRoundState.DONE_FAILED;
            } 
        }
        if (userSequence.size() < colorSequence.length) {                 
            return SimonSaysRoundState.CONTINUE;
        } else if (userSequence.size() == colorSequence.length) {
            return SimonSaysRoundState.DONE_SUCCESS;
        }

        return SimonSaysRoundState.DONE_FAILED;
    }

}
