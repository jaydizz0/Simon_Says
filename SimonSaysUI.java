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
        startButtonPanel = new JPanel();

        // Start Title
        titlePanel = new JPanel();
        titlePanel.setBounds(100, 0, 600, 150);
        titlePanel.setBackground(Color.black);
        titleLabel = new JLabel("SIMON SAYS");
        titleLabel.setForeground(Color.white);
        titleLabel.setFont(normalFont);

        
        con = window.getContentPane();
        startButtonPanel.setBounds(100,300,100,50);
        startButtonPanel.setBackground(Color. black);
        

        // Play Button 
        playButton = new JButton("Play");
        playButton.setBackground(Color.green);
        playButton.setForeground(Color.black);
        playButton.setFont(normalFont);
        playButton.addActionListener(new StartActionListener(simonSays));
        
        window.add(startButtonPanel);
        
        startButtonPanel.add(playButton);
        con.add(startButtonPanel);
        con.add(mainPanel);
        con.add(titlePanel);
        titlePanel.add(titleLabel);
        
        // 4 coloured buttons

    
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
