import java.awt.Font;
import javax.swing.JLabel;

/**
 * Questa classe specializza una JLabel al fine di gestire una variabile che
 * deve prevalentemente comportarsi come un
 * contatore.
 * 
 * @author Duluta
 */
public class MyLabel extends JLabel {

    private String etichetta;
    private int valore;

    public MyLabel(String etichetta, int valore) {
        // super(etichetta+" "+valore+" ");
        this.etichetta = etichetta + " ";
        this.valore = valore;
        setHorizontalAlignment(JLabel.CENTER);
        setFont(new Font("SANS-SERIF", Font.PLAIN, 20));
        setText(this.etichetta + valore);

    }

    public void setValore(int valore) {
        this.valore = valore;
        setText(etichetta + valore);
    }

    public int getValore() {
        return valore;
    }

    public void incrementa() {
        valore++;
        setText(etichetta + valore);
    }

    public void decrementa() {
        valore--;
        setText(etichetta + valore);
    }

    public void aggiungi(int valore) {
        this.valore += valore;
        setText(etichetta + this.valore);
    }
}
