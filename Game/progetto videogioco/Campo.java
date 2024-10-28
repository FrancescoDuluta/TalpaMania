import java.util.*;

public class Campo {
    // variabili d'istanza
    private ArrayList<Buco> campo;
    public static final int numBuchi = 5;

    // costruttore
    public Campo() {
        campo = new ArrayList<>(numBuchi);
    }

    // metodo per verificare se il campo è senza buche
    public boolean vuoto() {
        for (Buco x : campo)
            if (!x.isVuoto())
                return false;
        return true;
    }

    // metodo che copia nel campo la talpa passatagli come parametro
    public synchronized void inserisciTalpa(int posizione, Talpa talpa) {
        while (!vuoto()) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        campo.get(posizione).entraTalpa(talpa);
        notifyAll(); // ora ho più thread consumatori da svegliare
    }

    // metodo che rimane in attesa di leggere il contenuto del buffer non appena
    // questo viene scritto
    public synchronized ArrayList<Buco> liberaCampo() {
        while (vuoto()) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        ArrayList<Buco> buffer = campo;
        campo = null;
        notifyAll(); /*
                      * Diversamente da prima, ora i consumatori che invocano "leggi()" devono,
                      * al termine della lettura, svegliare i produttori successivi
                      * (prima avevo 1 solo produttore per cui, una volta che questo aveva agito a
                      * inizio programma,
                      * il consumatore non aveva altri produttori da svegliare)
                      */
        return buffer;
    }
}
