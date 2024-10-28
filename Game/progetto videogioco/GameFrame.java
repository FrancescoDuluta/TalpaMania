
import java.awt.*;
import java.awt.event.MouseAdapter;

import javax.swing.*;

import org.w3c.dom.events.MouseEvent;

public class GameFrame extends JFrame {
    private int numBuche;
    // private JButton btnEsci;
    // protected JButton btnGioca;
    protected MyLabel etichettaLabel;
    Image cursorImage = new ImageIcon("img/cursor.png").getImage();
    Point hotspot = new Point(0, 0);
    String cursorName = "martello";

    public GameFrame(int numBuche) {
        super("TalpaMania");
        this.setSize(450, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        setCursor(getToolkit().createCustomCursor(cursorImage, hotspot, cursorName));
        this.numBuche = numBuche;
        setResizable(false);
        initComponents();
        initPanels();
        initListeners();
        // pack();
        setVisible(true);
    }

    private void initComponents() {
        etichettaLabel = new MyLabel("TalpaMania");
    }

    private void initPanels() {
        JPanel pnl1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pnl1.add(etichettaLabel);
        JPanel pnl2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pnl2.setBackground(Color.GRAY);
        pnl2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.getContentPane().add(pnl1, BorderLayout.NORTH);
    }

    private void initListeners() {
        System.out.println("denian puttana");
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
}