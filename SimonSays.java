import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class SimonSays {
    private int score;
    private int round;
    private int lives;
    private String[] colourArray;
    private int highScore;
    private Scanner input;

    public SimonSays(){
        this.score = 0;
        this.round = 1;
        this.lives = 3;
        this.colourArray = new String[]{"Red", "Green", "Blue", "Yellow"};
        this.highScore = 0;
        this.input = new Scanner(System.in);
    }


    public boolean playAgain(){
        System.out.print("Want to play again?(Yes/No)");
        String play = input.nextLine();
        return play.equalsIgnoreCase("yes");
    }

    public String[] generateColorSequence(int round) {
        String[] colourSequence = new String[round];
        for (int i = 0; i < round; i++) {
            colourSequence[i] = pickColor(colourArray);
        }
        return colourSequence;
    }

    public int addScore(int Score){
        return Score++;
    }

    public int addRound(int Round){
        return Round++;
    }

    public void displayColorSequence(String[] colorSequence) {
        for (String colorValue : colorSequence) {
            System.out.println(colorValue + " ");
        }
    }

    public boolean checkSequence(String[] userColours, String[] computerColours, int index) {
        return userColours[index].equals(computerColours[index]);
    }

    public String pickColor(String[] colors) {
        Random rand = new Random();
        int randomIndex = rand.nextInt(colors.length);
        return colors[randomIndex];
    }

    public void updateHighScore(int score) {
        if (score > highScore) {
            highScore = score;
        }
    }

    public int getHighScore() {
        return highScore;
    }

    public void setHighScore(int highScore) {
        this.highScore = highScore;
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

    public String[] getColourArray(){
        return colourArray;
    }

    public String[] getGeneratedColourSequence(){
        return generateColorSequence(round);
    }

    
}


           
