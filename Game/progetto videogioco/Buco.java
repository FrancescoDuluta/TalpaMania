public class Buco {
    private int id;
    private Talpa talpaAssegnata;
    private boolean isTalpaAssegnata;

    public Buco(int id) {
        this.id = id;
        talpaAssegnata = null;
        isTalpaAssegnata = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isVuoto() {
        return talpaAssegnata == null;
    }

    public void entraTalpa(Talpa x) {
        if (!isTalpaAssegnata) {
            this.talpaAssegnata = x;
            isTalpaAssegnata = true;
        } else
            System.out.println("Buca occupata!");
    }
}
