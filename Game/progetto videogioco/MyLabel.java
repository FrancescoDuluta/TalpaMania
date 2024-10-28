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

    public MyLabel(String etichetta) {
        // super(etichetta+" "+valore+" ");
        this.etichetta = etichetta + " ";
        setHorizontalAlignment(JLabel.CENTER);
        setFont(new Font("SANS-SERIF", Font.PLAIN, 20));
        setText(this.etichetta);
    }
}
