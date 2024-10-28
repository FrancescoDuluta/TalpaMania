import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UI extends JFrame {

    JButton startButton;
    JPanel contentPanel;
    JPanel bgPanel;
    Image cursorImage = new ImageIcon("com/louiskounios/images/mouse-cursor.png").getImage();
    Point hotspot = new Point(0, 0);
    String cursorName = "Lightsaber Cursor";

    public UI() {
        setTitle("Whac-a-Skeletas");
        setCursor(getToolkit().createCustomCursor(cursorImage, hotspot, cursorName));

        bgPanel = new JPanel();
        bgPanel.setLayout(new BorderLayout());
        bgPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        contentPanel = new JPanel();
        contentPanel.setOpaque(false);
        contentPanel.setLayout(new GridBagLayout());

        startButton = new JButton("Start");
        startButton.setPreferredSize(new Dimension(400, 368));
        startButton.setOpaque(false);
        startButton.setBorderPainted(false);
        startButton.setContentAreaFilled(false);
        startButton.setIcon(new ImageIcon("com/louiskounios/images/start-button.png"));
        startButton.addMouseListener(new MyMouseListener());
        contentPanel.add(startButton);

        bgPanel.add(contentPanel);

        getContentPane().add(bgPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 800);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public class MyMouseListener extends MouseAdapter {
        public void mouseEntered(MouseEvent a) {
            System.out.println("Hovered.");
            startButton.setIcon(new ImageIcon("com/louiskounios/images/start-button-hovered.png"));
        }

        public void mouseExited(MouseEvent a) {
            System.out.println("Left.");
            startButton.setIcon(new ImageIcon("com/louiskounios/images/start-button.png"));
        }

        public void mouseClicked(MouseEvent a) {
            System.out.println("Clicked.");
            startButton.setIcon(new ImageIcon("com/louiskounios/images/start-button-pressed.png"));
            contentPanel.removeAll();
            contentPanel.repaint();
        }
    }

    public static void main(String[] args) {
        UI test = new UI();
    }
}