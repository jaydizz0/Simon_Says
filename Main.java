import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] ars) {
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

            for (int z = 0; z < round; z++) {
                System.out.print("Enter your sequence one at a time: ");
                userInputSequence[z] = input.nextLine();
                if (checkSequence(userInputSequence, colourSequence, z) == false) {
                    System.out.println("WRONG Try again");
                    lives--;
                    userInputSequence[z] = " ";

                    if (lives == 0) {
                        System.out.println("You Lost!");
                        
                        break;
                    }
                    z--;
                    continue;
                } 
                else {
                    continue;  
                }
            }
            round++;
            score++;

        }
       
    }


        
    public static String pickColor(String[] colors) {
        Random rand = new Random();
        int randomIndex = rand.nextInt(colors.length);
        return colors[randomIndex];
    }

    public static boolean checkSequence(String[] userColours, String[] computerColours, int index){
        boolean equalArray = false;
        if(!userColours[index].equals(computerColours[index])){
            equalArray = false;
        }else{
            equalArray = true;
        }
        return equalArray;
    }
}

