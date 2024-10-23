import java.awt.FlowLayout;
import javax.swing.*;

public class prova {
    public static void main(String[] args) {
        JFrame myFrame = new JFrame("Frame Title");
        myFrame.setSize(1200, 800);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setVisible(true);

        ImageIcon imageIcon = new ImageIcon("talpa 256x256.png");
        
        JLabel imageLabel = new JLabel(imageIcon);

        myFrame.add(imageLabel);
        myFrame.setLayout(new FlowLayout());
        myFrame.setVisible(true);

        imageIcon = new ImageIcon("buca 512x512.png");
        
        imageLabel = new JLabel(imageIcon);

        myFrame.add(imageLabel);
        myFrame.setLayout(new FlowLayout());
        myFrame.setVisible(true);
    }
}