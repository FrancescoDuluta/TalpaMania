import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

// Updated classes as per your request

public class Campo {
    private final ArrayList<Buco> buchi;
    private int talpeUscite;
    private int talpeSchiacciate;
    private final JLabel lblTalpeUscite;
    private final JLabel lblTalpeSchiacciate;

    public Campo(JLabel lblTalpeUscite, JLabel lblTalpeSchiacciate) {
        buchi = new ArrayList<>();
        talpeUscite = 0;
        talpeSchiacciate = 0;
        this.lblTalpeUscite = lblTalpeUscite;
        this.lblTalpeSchiacciate = lblTalpeSchiacciate;
    }

    public synchronized void addBuco(Buco buco) {
        buchi.add(buco);
    }

    public synchronized void startGame(int difficolta) {
        int numeroBuchi = difficolta == 1 ? 5 : difficolta == 2 ? 7 : 12;
        int tempoVisibilita = difficolta == 1 ? 4000 : difficolta == 2 ? 2000 : 1000;

        for (int i = 0; i < numeroBuchi; i++) {
            Buco buco = new Buco(i, this);
            addBuco(buco);
        }

        // Genera thread per le talpe
        for (int i = 0; i < 20; i++) {
            new Talpa(this, tempoVisibilita).start();
            try {
                Thread.sleep(new Random().nextInt(3000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized Buco getRandomBuco() {
        return buchi.get(new Random().nextInt(buchi.size()));
    }

    public synchronized void talpaUscita(boolean schiacciata) {
        talpeUscite++;
        lblTalpeUscite.setText("Talpe Uscite: " + talpeUscite);
        if (schiacciata) {
            talpeSchiacciate++;
            lblTalpeSchiacciate.setText("Talpe Schiacciate: " + talpeSchiacciate);
        }
    }

    public synchronized boolean partitaFinita() {
        return talpeUscite >= 20 || talpeSchiacciate >= 10;
    }

    public ArrayList<Buco> getBuchi() {
        return buchi;
    }

}

class Talpa extends Thread {
    private final Campo campo;
    private final int tempoVisibilita;
    private Buco bucoCorrente;
    private final String[] colori = { "blu", "marrone", "gialla", "rossa", "verde" };

    public Talpa(Campo campo, int tempoVisibilita) {
        this.campo = campo;
        this.tempoVisibilita = tempoVisibilita;
    }

    @Override
    public void run() {
        bucoCorrente = campo.getRandomBuco();
        if (bucoCorrente.occupato()) {
            return;
        }
        bucoCorrente.setOccupato(true);
        bucoCorrente.mostraTalpa(colori[new Random().nextInt(colori.length)]);

        try {
            Thread.sleep(tempoVisibilita);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        bucoCorrente.setOccupato(false);
        bucoCorrente.nascondiTalpa();
        campo.talpaUscita(false);
    }
}

class Buco {
    private final int id;
    private boolean occupato;
    private JLabel lblBuco;
    private final Campo campo;

    public Buco(int id, Campo campo) {
        this.id = id;
        this.occupato = false;
        this.campo = campo;
        this.lblBuco = new JLabel();
        lblBuco.setIcon(new ImageIcon("images/buca 512x512.png")); // Placeholder per icona del buco

        lblBuco.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (occupato) {
                    campo.talpaUscita(true);
                    setOccupato(false);
                    nascondiTalpa();
                }
            }
        });
    }

    public synchronized boolean occupato() {
        return occupato;
    }

    public synchronized void setOccupato(boolean occupato) {
        this.occupato = occupato;
    }

    public void mostraTalpa(String colore) {
        lblBuco.setIcon(new ImageIcon("images/talpa" + colore + ".png")); // Cambia immagine del buco con quella della
                                                                          // talpa
    }

    public void nascondiTalpa() {
        lblBuco.setIcon(new ImageIcon("images/buca 512x512.png")); // Cambia immagine del buco senza talpa
    }

    public JLabel getLblBuco() {
        return lblBuco;
    }
}
