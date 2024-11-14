import javax.swing.*;
//import java.awt.*;
import java.util.concurrent.Semaphore;

/**
 * La classe Talpa rappresenta una talpa che appare e scompare in un gioco di
 * tipo "acchiappa la talpa".
 * La talpa appare in modo casuale in uno dei buchi e scompare dopo un breve
 * periodo. Se viene colpita,
 * aggiorna il punteggio.
 */
public class Talpa extends Thread {

    private Semaphore semaforo; // serve per gestire la coda delle talpe (ossia come gestire il numero di talpe
                                // visibili contemporaneamente)
    private JButton[] buchi; // zone dove possono apparire le talpe
    private boolean visibile; // boolean che come indica il nome gestisce la visibilità della talpa
    private int tDAT; // tempo di attesa della talpa da quando appare, alla fine del quale la talpa
                      // scompare.
    private int tRDATM; // tempo random di apparizione talpa massimo, ossia il tempo massimo che può
                        // aspettare la talpa prima di apparire (gestito randomicamente)
    private int id; // numero della talpa
    private ImageIcon immagineTalpa; // immagine della talpa da caricare da pc

    /**
     * Costruttore della classe Talpa.
     * 
     * @param id               L'identificatore unico della talpa
     * @param semaforo         Il semaforo per limitare il numero di talpe visibili
     *                         contemporaneamente
     * @param buchi            L'array di bottoni che rappresentano i buchi dove le
     *                         talpe possono apparire
     * @param tDAT             Il tempo massimo di visibilità della talpa in
     *                         millisecondi
     * @param tRDATM           Il tempo massimo di attesa prima che la talpa appaia,
     *                         in millisecondi
     * @param percorsoImmagine Il percorso del file immagine della talpa
     */
    public Talpa(int id, Semaphore semaforo, JButton[] buchi, int tDAT, int tRDATM, String percorsoImmagine) {
        this.id = id;
        this.semaforo = semaforo;
        this.buchi = buchi;
        this.visibile = false;
        this.tDAT = tDAT;
        this.tRDATM = tRDATM;
        immagineTalpa = new ImageIcon(percorsoImmagine); // Carico l'immagine
    } // Talpa

    /**
     * Metodo principale che fa funzionare il comportamento della talpa.
     * La talpa aspetta un tempo casuale, poi appare in un buco, resta visibile per
     * un tempo casuale
     * e poi scompare. Questo ciclo si ripete continuamente.
     */
    public void run() {
        try {
            while (true) {
                // facciamo attendere alla talpa un tempo randomico tra 500 e tRDATM
                // millisecondi
                Thread.sleep(500 + (int) (Math.random() * (tRDATM - 500)));

                // Acquisisci il semaforo per mettere in coda la talpa
                semaforo.acquire();
                visibile = true;
                buchi[id].setIcon(immagineTalpa); // La talpa appare (setBackground(Color.RED)

                // La talpa resta visibile per un tempo limitato randomico tra 200 e tDAT
                // millisecondi
                Thread.sleep(200 + (int) (Math.random() * (tDAT - 200)));

                // Scompare
                visibile = false;
                buchi[id].setIcon(null); // La talpa scompare setBackground(Color.LIGHT_GRAY)

                // Rilasciamo il semaforo per permettere a una atra talpa di comparire
                semaforo.release();
            } // while
        } catch (InterruptedException e) {
            // e.printStackTrace();
        } // try-catch
    } // run

    /**
     * Metodo che verifica se la talpa è stata colpita.
     * Se la talpa è visibile, la rende invisibile e restituisce true.
     * Se non è visibile, restituisce false.
     * 
     * @return true se la talpa è stata colpita, false altrimenti
     */
    public synchronized boolean isColpita() {
        if (visibile) {
            visibile = false;
            return true;
        } else {
            return false; // DA GESTIRE QUA LA PERDITA DI PUNTI
        } // else
    } // colpita
} // Talpa
