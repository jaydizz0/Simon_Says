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
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Timer;

public class SimonSaysUI extends JFrame {
    JPanel mainPanel,startButtonPanel,titlePanel;
    JButton playButton;
    JLabel titleLabel;
    Container con;
    JFrame window;
    Font normalFont = new Font("Comic Sans MS",Font.PLAIN,28);
    private SimonSays simonSays;

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
        titlePanel.setBounds(100, 0, 600, 150);
        titlePanel.setBackground(Color.black);
        titleLabel = new JLabel("SIMON SAYS");
        titleLabel.setForeground(Color.white);
        titleLabel.setFont(normalFont);
        con.add(titlePanel);
        titlePanel.add(titleLabel);


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
        // colorButtonsPanel.setBackground(Color.BLACK);
        
        colorButtonsPanel.setOpaque(true);
        
        JButton redButton = new JButton("Red");
        redButton.setBackground(Color.black);
        redButton.setContentAreaFilled(false);
        redButton.setOpaque(true);        
        redButton.setForeground(Color.BLACK);
        redButton.setSize(150,150);
        redButton.addActionListener(new StartActionListener(simonSays));
       
        
        JButton greenButton = new JButton("Green");
        greenButton.setContentAreaFilled(false);
        greenButton.setOpaque(true);
        greenButton.setBackground(Color.BLACK);
        greenButton.setForeground(Color.BLACK);
        greenButton.setSize(150,150);
        greenButton.addActionListener(new StartActionListener(simonSays));
    
        JButton blueButton = new JButton("Blue");
        blueButton.setContentAreaFilled(false);
        blueButton.setOpaque(true);
        blueButton.setBackground(Color.BLACK);
        blueButton.setForeground(Color.BLACK);
        blueButton.setSize(150,150);
        blueButton.addActionListener(new StartActionListener(simonSays));
    
        JButton yellowButton = new JButton("Yellow");
        yellowButton.setContentAreaFilled(false);
        yellowButton.setOpaque(true);
        yellowButton.setBackground(Color.BLACK);
        yellowButton.setForeground(Color.BLACK);
        yellowButton.setSize(150,150);
        yellowButton.addActionListener(new StartActionListener(simonSays));
        
        
        colorButtonsPanel.add(redButton);
        colorButtonsPanel.add(greenButton);
        colorButtonsPanel.add(blueButton);
        colorButtonsPanel.add(yellowButton);
        colorButtonsPanel.setBounds(450, 200, 200, 200);
        con.add(colorButtonsPanel);
        window.setVisible(true);



        // Dictionary
        // Maps hashtable to string to JButton
        Hashtable<String,JButton> colourArrayToButton = new Hashtable<String,JButton>();
        colourArrayToButton.put(simonSays.getColourArray(1), redButton);
        colourArrayToButton.put(simonSays.getColourArray(2), greenButton);
        colourArrayToButton.put(simonSays.getColourArray(3), blueButton);
        colourArrayToButton.put(simonSays.getColourArray(4), yellowButton);



        window.setVisible(true);

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
            simonSays.playAgain();
            
        }
        
    }
}
