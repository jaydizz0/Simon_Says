import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout; 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.text.AttributeSet.ColorAttribute;
import javax.swing.Timer;
import java.util.TimerTask;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.TimerTask;
import javax.swing.JOptionPane;

public class SimonSaysUI extends JFrame {
    JPanel mainPanel,startButtonPanel,titlePanel;
    JButton playButton;
    JLabel titleLabel;
    Container con;
    JFrame window;
    JPanel scorePanel;
    JLabel scoreLabel;
    JLabel roundLabel;
    JLabel highScoreLabel;
    JLabel wrongLabel;
    Font normalFont = new Font("Comic Sans MS",Font.PLAIN,28);
    private SimonSays simonSays;
    private JButton redButton;
    private JButton greenButton;
    private JButton blueButton;
    private JButton yellowButton;


    public SimonSaysUI(SimonSays simonSays) {
        this.simonSays = simonSays;
        window = new JFrame();
        window.setSize(800,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        window.setLocationRelativeTo(null);

        mainPanel = new JPanel();
        con = window.getContentPane();
        con.add(mainPanel);
    
        //Title
        titlePanel = new JPanel();
        titlePanel.setBounds(300, 50, 200, 100);
        titlePanel.setBackground(Color.black);
        titleLabel = new JLabel("SIMON SAYS");
        titleLabel.setForeground(Color.white);
        titleLabel.setFont(normalFont);
        con.add(titlePanel);
        titlePanel.add(titleLabel);

        // Score Label
        scoreLabel = new JLabel("Score: " + simonSays.getScore());
        scoreLabel.setForeground(Color.white);
        scoreLabel.setFont(new Font("AComic Sans", Font.BOLD, 30));
        scoreLabel.setBounds(100, 150, 200, 100);
        con.add(scoreLabel);
    
        highScoreLabel = new JLabel("High Score: " + simonSays.getHighScore());
        highScoreLabel.setForeground(Color.white);
        highScoreLabel.setFont(new Font("Comic Sans", Font.BOLD, 30));
        highScoreLabel.setBounds(100, 200, 200, 100);
        con.add(highScoreLabel);
        
        roundLabel = new JLabel("Round: " + simonSays.getRound());
        roundLabel.setForeground(Color.white);
        roundLabel.setFont(new Font("AComic Sans", Font.BOLD, 30));
        roundLabel.setBounds(100, 100, 200, 100);
        con.add(roundLabel);


        //Play Button
        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(100,300,100,50);
        startButtonPanel.setBackground(Color.black);
        playButton = new JButton("Play");
        playButton.setBackground(Color.GREEN);
        playButton.setForeground(Color.black);
        playButton.setFont(normalFont);
        playButton.addActionListener(new StartActionListener(simonSays));
        

        startButtonPanel.add(playButton);
        con.add(startButtonPanel);

        // 4 coloured buttons
        JPanel colorButtonsPanel = new JPanel(new GridLayout(2, 2));
        //colorButtonsPanel.setBackground(Color.BLACK);
        
        

        redButton = new JButton("Red");
        redButton.setBackground(Color.red);
        redButton.setBorderPainted(false);
        redButton.setOpaque(true);   
        redButton.setForeground(Color.BLACK);
        redButton.setSize(150,150);
        redButton.addActionListener(new ColorButtonListener("Red"));
       
        
        greenButton = new JButton("Green");
        greenButton.setBorderPainted(false);
        greenButton.setOpaque(true);
        greenButton.setBackground(Color.GREEN);
        greenButton.setForeground(Color.BLACK);
        greenButton.setSize(150,150);
        greenButton.addActionListener(new ColorButtonListener("Green"));
    
        blueButton = new JButton("Blue");
        blueButton.setBackground(Color.BLUE);
        blueButton.setBorderPainted(false);
        blueButton.setOpaque(true);
        blueButton.setForeground(Color.BLACK);
        blueButton.setSize(150,150);
        blueButton.addActionListener(new ColorButtonListener("Blue"));
    
        yellowButton = new JButton("Yellow");
        yellowButton.setBorderPainted(false);
        yellowButton.setOpaque(true);
        yellowButton.setBackground(Color.YELLOW);
        yellowButton.setForeground(Color.BLACK);
        yellowButton.setSize(150,150);
        yellowButton.addActionListener(new ColorButtonListener("Yellow"));
        
        
        colorButtonsPanel.add(redButton);
        colorButtonsPanel.add(greenButton);
        colorButtonsPanel.add(blueButton);
        colorButtonsPanel.add(yellowButton);
        colorButtonsPanel.setBounds(450, 200, 200, 200);
        con.add(colorButtonsPanel);
        window.setVisible(true);


    }
    
    
    public void waitFor(long time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void flashButton(final JButton button, Color originalColor) { 
        button.setOpaque(true);
        button.setBorderPainted(false);
        button.setBackground(Color.WHITE);
        final Timer timer = new javax.swing.Timer(500, new ActionListener() {
            int count = 0;    

            @Override
            public void actionPerformed(ActionEvent e) {
                if (count == 0) {                 
                    count++;
                } else {
                    button.setBackground(originalColor); 
                    ((Timer)e.getSource()).stop();
                    
                }
                
            }

        });
        timer.start();
    }
    
    public void flashButton(String color) {        
        switch (color) {
            case "Red":
                flashButton(redButton, Color.RED);
                break;
            case "Green":
                flashButton(greenButton, Color.GREEN);
                break;
            case "Blue":
                flashButton(blueButton, Color.BLUE);
                break;
            case "Yellow":
                flashButton(yellowButton, Color.YELLOW);
                break;
        }
    }
    

    public void flashButtonSequence() {
        Timer timer = new Timer(500, new ActionListener() {
            int colorIndex = 0;
            public void actionPerformed(ActionEvent e) {
                if (colorIndex == simonSays.getColorSequence().length) {
                    ((Timer)e.getSource()).stop();
                } else {
                    flashButton(simonSays.getColorSequence()[colorIndex]);
                    colorIndex++;
                }
            }
        });
        timer.start();
    }

    class ColorButtonListener implements ActionListener {
        String color;
        ColorButtonListener(String color){
            this.color = color;
        }

        public void actionPerformed(ActionEvent e) {
            flashButton(color);
            simonSays.getUserInputSequence().add(color);
            updateGameState();
        }
    }

    public void endGame() {
        int result = JOptionPane.showConfirmDialog(null, "Game over! Your final score is " + simonSays.getScore() +
                ". The high score is " + simonSays.getHighScore() + ". Do you want to play again?", "Game Over", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            simonSays.reset();
            scoreLabel.setText("Score: " + simonSays.getScore());
            roundLabel.setText("Round: " + simonSays.getRound());
            highScoreLabel.setText("Highscore: " + simonSays.updateHighScore(simonSays.getScore()));
            startGame();
        } else {
            System.exit(0);
        }
    }

    public void updateGameState() {
        SimonSaysRoundState state = simonSays.getRoundState(simonSays.getUserInputSequence(), simonSays.getColorSequence());
        switch(state) {
            case CONTINUE:
                break;
            case DONE_FAILED:
                endGame();
                break;
            case DONE_SUCCESS:
                JOptionPane.showMessageDialog(null, "Correct");
                simonSays.nextRound();
                simonSays.updateScore();
                roundLabel.setText("Round: " + simonSays.getRound());
                scoreLabel.setText("Score " + simonSays.getScore());
                break;
        }

        
    } 
    


    public void startGame(){
        simonSays.startGame();
        flashButtonSequence();
        
    }

     public static void main(String[] args) {
        SimonSays simonSays = new SimonSays();
        new SimonSaysUI(simonSays);
        
    }

    private class StartActionListener implements ActionListener {

        private SimonSays simonSays;

        public StartActionListener(SimonSays simonSays) {
            this.simonSays = simonSays;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            startGame();
        }
            
    }
        
}

