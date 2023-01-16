import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class SimonSays {

    public void startGame(){
        Scanner input = new Scanner(System.in);
        int score = 0;
        int round = 1;
        int lives = 3;
        String[] colourArray = {"red", "green", "blue", "yellow"};
        while (lives > 0) {
            String[] colourSequence = new String[round];
            String[] userInputSequence = new String[round];

            for (int i = 0; i < round; i++) {
                colourSequence[i] = pickColor(colourArray);
            }
            for (String colorValue : colourSequence) {
                System.out.println(colorValue + " ");
            }

        }
    }
    
    public void playGame(int round, String[] userInputSequence, String[] colourSequence, int score, int lives, Scanner input){
        for (int z = 0; z < round; z++) {
            System.out.print("Enter your sequence one at a time: ");
            userInputSequence[z] = input.nextLine();
            if (checkIndex(userInputSequence, colourSequence, z) == false) {
                System.out.println("WRONG Try again");
                lives--;
                userInputSequence[z] = " ";

                if (lives == 0) {
                    System.out.println("You Lost!");
                    System.out.println("Current High Score: " + updateHighScore("HighScore.txt", score));
                    if(playAgain() == false){
                        System.exit(0);
                    }
                    else{
                        break;
                    }
                }
                z--;
                continue;
            } 
            else {
                continue;  
            }
        }
    }
    public boolean playAgain(){
        Scanner input = new Scanner(System.in);
        System.out.print("Want to play again?(Yes/No)");
        String play = input.nextLine();
        if(play.equals("No")){
            return false;
        }
        else{
            return true;
        }
    }

    public String pickColor(String[] colors) {
        Random rand = new Random();
        int randomIndex = rand.nextInt(colors.length);
        return colors[randomIndex];
    }

    public boolean checkIndex(String[] userColours, String[] computerColours, int index){
        boolean equalArray = false;
        if(!userColours[index].equals(computerColours[index])){
            equalArray = false;
        }else{
            equalArray = true;
        }
        return equalArray;
    }

    public int updateHighScore(String filePath, int score) {
        try {
            File file = new File(filePath);
            BufferedReader br = new BufferedReader(new FileReader(file));
            int currentHighScore = Integer.parseInt(br.readLine());
            if (score > currentHighScore) {
                FileWriter writer = new FileWriter(file);
                writer.write(Integer.toString(score));
                writer.close();
                return score;
            } else {
                return currentHighScore;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}


