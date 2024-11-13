import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.Semaphore;
import java.io.File; //utilizzata per aggiungere il font
import java.io.IOException; //utilizzata per aggiungere il font

/**
 * La classe AcchiappaLaTalpa rappresenta un gioco interattivo in cui il
 * giocatore
 * deve "colpire" le talpe che appaiono e scompaiono in una griglia di buchi.
 * Il gioco tiene traccia del punteggio e del tempo rimanente, ed è dotato di
 * una
 * schermata iniziale e di una schermata di gioco con sfondi personalizzati.
 */

public class AcchiappaLaTalpa extends JFrame {

    private static final int N = 4; // variabile che serve a definire il numero di buche e talpe
    private static final int NUMERO_TALPE = N * N; // definisco il numero di talpe
    private static final int NUMERO_BUCHI = NUMERO_TALPE; // definisco il numero di buche
    private static final int TDAT = 2500; // tempo di attesa della talpa massimo
    private static final int TRDATM = 3000; // tempo random di apparizione talpa massimo
    private static final int TEMPO_GIOCO = 60; // Tempo di gioco in secondi

    // definisco un semaforo da passare alla classe talpa, un array di talpe, e un
    // array di jButton buchi che serviranno ad ospitare le nostre talpe

    private Semaphore semaforo;
    private JButton[] buchi;
    private Talpa[] talpe;

    // definisco i 3 percorsi delle immagini usate nella classe

    private String percorsoImmagineTalpa = "./immagini/talpa6.png";
    private String percorsoImmagineSfondo = "./immagini/sfondo1.png";
    private String percorsoImmagineSfondoIniziale = "./immagini/arcade.png";

    // definisco variabili e etichette per il punteggio e tempo del gioco

    private int punteggio = 0;
    private JLabel etichettaPunteggio;
    private JLabel timerLabel;
    private int tempoRimanente;

    /**
     * Costruttore
     */
    public AcchiappaLaTalpa() {

        // definisco il titolo della schemata, la grandezza e la sua posizione realtiva
        // allo schemo
        setTitle("Acchiappa la Talpa!");
        setSize(800, 800);
        setLocationRelativeTo(null);

        // quando la finestra viene chiusa, l'applicazione viene "terminata"
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Inizializza la schermata iniziale, guardare metodo...
        mostraSchermataIniziale();
    }

    /**
     * Mostra la schermata iniziale del gioco con titolo e font personalizzato
     */
    private void mostraSchermataIniziale() {

        // imposto il font che voglio importare all'interno di un blocco try, così in
        // caso di errore imposti il font di default Arial

        Font customFont = null;
        try {
            // setto il font che ho scaricato
            customFont = Font.createFont(Font.TRUETYPE_FONT, new File("./font/Crang.ttf")).deriveFont(40f);

            // Registro il font nel sistema Java
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);

        } catch (IOException | FontFormatException e) {
            // In caso di errore, usa un font di default
            e.printStackTrace();
            customFont = new Font("Comic-Sans", Font.BOLD, 40);
        }

        // Creo il pannello per la schermata iniziale con sfondo
        BackgroundPanel schermataIniziale = new BackgroundPanel(percorsoImmagineSfondoIniziale);
        schermataIniziale.setLayout(new BorderLayout());

        // Creo il bottone da cliccare per iniziare il gioco
        JButton startButton = new JButton("Clicca per Iniziare");
        startButton.setFont(customFont);
        startButton.setForeground(Color.WHITE);

        // disabilito le impostazioni di default del bottone: la colorazione del
        // contenuto, l'indicatore di focus e il bordo del bottone
        startButton.setContentAreaFilled(false);
        startButton.setFocusPainted(false);
        startButton.setBorderPainted(false);

        // quando viene cliccato sopra il bottone(occupa tutta la schermata) il gioco
        // viene avviato
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Avvia il gioco
                startGame();
            }
        });

        // Aggiungi titolo e pulsante al pannello
        schermataIniziale.add(startButton, BorderLayout.CENTER);

        // Imposta la schermata iniziale come contenuto della finestra
        setContentPane(schermataIniziale);
        revalidate();
        repaint();
    }

    /**
     * Inizia il gioco impostando la griglia di buchi, inizializzando le talpe e
     * avviando il timer per il conto alla rovescia da 60 sec
     */
    private void startGame() {
        JPanel panelPrincipale = new JPanel();
        panelPrincipale.setLayout(new BorderLayout());

        // creo il pannello con l'immagine di sfondo, importando la immagine all'interno
        // della cartella immagini tramite il percorso definito in precedenza (guardare
        // riga 30)
        JPanel panelConSfondo = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon sfondo = new ImageIcon(percorsoImmagineSfondo);
                g.drawImage(sfondo.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        panelConSfondo.setLayout(new GridLayout(N, N));

        // Inizializza i buchi
        buchi = new JButton[NUMERO_BUCHI];
        for (int i = 0; i < NUMERO_BUCHI; i++) {
            buchi[i] = new JButton();
            buchi[i].setContentAreaFilled(false); // Imposta trasparenza
            buchi[i].setBorderPainted(false); // Rimuove i bordi
            buchi[i].setFocusPainted(false); // Rimuove il bordo di messa a fuoco

            final int index = i;
            buchi[index].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (talpe[index] != null && talpe[index].isColpita()) {
                        buchi[index].setIcon(null);
                        aggiornaPunteggio(1); // Aumenta il punteggio
                    } else if (punteggio > 0) {
                        aggiornaPunteggio(-1); // Diminuisci il punteggio
                    }
                }
            });
            panelConSfondo.add(buchi[i]);
        }

        // Inizializza il semaforo
        semaforo = new Semaphore(N);

        // Crea e avvia i thread delle talpe
        talpe = new Talpa[NUMERO_BUCHI];
        for (int i = 0; i < NUMERO_BUCHI; i++) {
            talpe[i] = new Talpa(i, semaforo, buchi, TDAT, TRDATM, percorsoImmagineTalpa);
            new Thread(talpe[i]).start();
        }

        // Inizializza il punteggio e il timer
        etichettaPunteggio = new JLabel("Punteggio: " + punteggio);
        timerLabel = new JLabel("Tempo rimanente: " + TEMPO_GIOCO);

        // Pannello per score e timer
        JPanel panelInfo = new JPanel();
        panelInfo.add(etichettaPunteggio);
        panelInfo.add(timerLabel);

        // Aggiungi i pannelli al pannello principale
        panelPrincipale.add(panelInfo, BorderLayout.NORTH);
        panelPrincipale.add(panelConSfondo, BorderLayout.CENTER);
        setContentPane(panelPrincipale);

        // Inizia il timer
        tempoRimanente = TEMPO_GIOCO;
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tempoRimanente > 0) {
                    tempoRimanente--;
                    timerLabel.setText("Tempo rimanente: " + tempoRimanente);
                } else {
                    ((Timer) e.getSource()).stop();
                    JOptionPane.showMessageDialog(null, "Tempo scaduto! Punteggio finale: " + punteggio);
                    dispose();
                }
            }
        });
        timer.start();
    }

    /**
     * Aggiorna il punteggio del giocatore.
     * 
     * @param incremento il valore da aggiungere (positivo o negativo) al punteggio
     *                   corrente, 1 se viene colpita la talpa e -1 in caso non si
     *                   colpisca nulla
     */
    private void aggiornaPunteggio(int incremento) {
        punteggio += incremento;
        etichettaPunteggio.setText("Punteggio: " + punteggio);
    }

    /**
     * main
     * 
     * @param args
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AcchiappaLaTalpa().setVisible(true));
    }

    /**
     * Classe interna per gestire il pannello con un'immagine di sfondo.
     */
    class BackgroundPanel extends JPanel {
        private Image backgroundImage;

        /**
         * Costruisce un BackgroundPanel caricando un'immagine di sfondo.
         * 
         * @param filePath il percorso del file immagine di sfondo
         */
        public BackgroundPanel(String filePath) {
            try {
                backgroundImage = new ImageIcon(filePath).getImage();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /**
         * "Dipinge" l'immagine di sfondo.
         * 
         * @param g l'oggetto Graphics usato per "disegnare".
         */
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (backgroundImage != null) {
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        }
    }
}
