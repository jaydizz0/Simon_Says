import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
public class MyFrame extends JFrame {
    MyFrame(){
        this.setVisible(true);
        this.setSize(1080,1920);
        this.setTitle("Simon Says");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon image = new ImageIcon("SimonSaysIcon.png");
        this.setIconImage(image.getImage());
        this.getContentPane().setBackground(new Color(0,0,0));
    }
}
