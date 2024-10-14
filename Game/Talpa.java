import java.util.Random;

public class Talpa extends Thread {
    // variabili d'istanza
    private final Campo campo;
    private Random x = new Random();
    private int posizioneAssegnata;

    // costruttore
    public Talpa(String nome, Campo b) {
        super(nome); // questa volta viene richiamato esplicitamente il costruttore super() della
                     // classe Thread
                     // per passare al thread il nome ricevuto come parametro di ingresso
        campo = b;
        start(); // avvio il thread alla creazione eseguendo le istruzioni di run()
    }

    public void run() {
        posizioneAssegnata = x.nextInt(Campo.numBuchi + 1);
        campo.inserisciTalpa(posizioneAssegnata, this);
    }
}
