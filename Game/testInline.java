import java.util.*;

public class testInline {
    public static void main(String[] args) {
        Campo x = new Campo();
        final int talpeDaSpawnare = 20;
        int counterTalpeSpawnate = 0;
        int counterTalpeAmmazzate = 0;

        ArrayList<Talpa> talpe = new ArrayList<>(talpeDaSpawnare);
        for (Talpa x : talpe) {
            x = new Talpa();
        }
    }
}
