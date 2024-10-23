import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class GameFrame extends JFrame {
    private int numBuche;
    private JButton btnEsci;
    protected JButton btnGioca;
    protected MyLabel etichettLabel;

    public GameFrame(int numBuche) {
        super("TalpaMania");
        this.setSize(450, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.numBuche = numBuche;
        initComponents();
        initPanels();
        initListeners();
        pack();
        setVisible(true);
    }

    private void initComponents() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'initComponents'");
    }

    private void initPanels() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'initPanels'");
    }

    private void initListeners() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'initListeners'");
    }

}
