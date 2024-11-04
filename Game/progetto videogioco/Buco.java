public class Buco {
    private int id;
    private Talpa talpaAssegnata;
    private boolean isTalpaAssegnata;

    public Buco(int id) {
        // this.image: Image
        this.id = id;
        talpaAssegnata = null;
        isTalpaAssegnata = false;
    }

    /**
     * pub getStrite(): Image
     * 
     * 
     * - nel monitor
     * paintComponent(Graphics g)
     * super.paintComponent(g)
     * g.drawImage(x, y, w, h, Buco.getSprite())
     * 
     */

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
