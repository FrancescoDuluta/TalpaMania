import java.awt.*;
import javax.swing.*;

public class GameFrame extends JFrame {
    private int numBuche;
    // private JButton btnEsci;
    // protected JButton btnGioca;
    protected MyLabel etichettaLabel;
    Image cursorIMG = Toolkit.getDefaultToolkit().getImage("img/cursor.png");
    Point cursorPoint = new Point(0, 0);
    Cursor cursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorIMG, cursorPoint, "martello");

    public GameFrame(int numBuche) {
        super("TalpaMania");
        this.setSize(450, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setCursor(cursor);
        this.numBuche = numBuche;
        setResizable(false);
        initComponents();
        initPanels();
        initListeners();
        // pack();
        setVisible(true);
    }

    private void initComponents() {
        etichettaLabel = new MyLabel("Denian puttana");
    }

    private void initPanels() {
        JPanel pnlNord = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pnlNord.add(etichettaLabel);
        this.getContentPane().add(pnlNord, BorderLayout.NORTH);
    }

    private void initListeners() {
        System.out.println("denian puttana");
    }

}
