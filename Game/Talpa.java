import java.util.Random;

public class Talpa extends Thread {
    // variabili d'istanza
    private final Campo campo;
    private Random x = new Random();
    private int posizioneAssegnata;

    // costruttore
    public Talpa(String nome, Campo b) {
        super(nome);
        campo = b;
        // start();
    }

    public void run() {
        posizioneAssegnata = x.nextInt(Campo.numBuchi + 1);
        campo.inserisciTalpa(posizioneAssegnata, this);
    }
}
