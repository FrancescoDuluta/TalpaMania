
public class GameFrame extends JFrame {

    import java.awt.BorderLayout;
    import java.awt.Color;
    import java.awt.FlowLayout;
    import java.awt.GridLayout;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    import java.awt.event.MouseAdapter;
    import java.awt.event.MouseEvent;
    import javax.swing.*;

    private int numCaselleSlot;
    // protected CasellaSlot[] txtsPayLine;
    protected JButton[] btnsBlocco;
    private JButton btnCoin, btnRipristina;
    protected JButton btnGioca;
    private JCheckBox cbConferma;
    private JComboBox comboCoin;
    protected MyLabel lblJackpot, lblCoin;

    public GameFrameFrame(int numCaselleSlot) {
        super("Frame By TuoCognome TuoNome"); // CONSEGNA 1: IMPOSTA il tuo nome reale
        this.setSize(450, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.numCaselleSlot = numCaselleSlot; 
        
        initComponenti();
        initPannelli();
        initAscoltatori();
        
        pack();
        setVisible(true);
        btnRipristina.doClick();
    }

    private void initComponenti() {

        txtsPayLine = new CasellaSlot[numCaselleSlot];
        btnsBlocco = new JButton[numCaselleSlot];

        lblJackpot = new MyLabel("JACKPOT", 100);

        for (int i = 0; i < numCaselleSlot; i++) {
            txtsPayLine[i] = new CasellaSlot();
            btnsBlocco[i] = new JButton("BLOCCA");
        }

        btnCoin = new JButton("INSERT COIN");
        cbConferma = new JCheckBox("Conferma Giocata");

        /*
         * String[] tagli = {"","Full","20 euro","10 euro","5 euro"};
         * comboCoin = new JComboBox(tagli);
         * 
         * IN ALTERNATIVA SI PUO' SCRIVERE ...
         */
        comboCoin = new JComboBox();
        comboCoin.addItem("");
        comboCoin.addItem("Full");
        comboCoin.addItem("20 euro");
        comboCoin.addItem("10 euro");
        comboCoin.addItem("5 euro");

        lblCoin = new MyLabel("N.ro COIN", 0);

        btnGioca = new JButton("GIOCA");
        btnRipristina = new JButton("RIPRISTINA");

    } /* ----------- FINE metodo initComponenti --------------- */

    private void initPannelli() {

        /*
         * CONSEGNA 2 - INIT PANNELLO NORD (pnlNord): ETICHETTA JACKPOT
         * HA LayoutManager -> FlowLayout CENTRATO
         * Vedi DEMO
         */
        JPanel pnlNord = new JPanel();
        pnlNord.add(lblJackpot);

        /*
         * CONSEGNA 3 - INIT PANNELLO CENTRO (pnlCentro): LA PAYLINE (LINEA DELLE
         * CASELLE SLOT) E DEI BOTTONI DI BLOCCO
         * Una volta creato il pannello, per distanziare il suo contenuto rispetto al
         * suo bordo scrivere:
         * pnlCentro.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
         * Impostare lo sfondo GRIGIO
         * Inserire le componenti della PAYLINE e dei BOTTONI di BLOCCO rispettando
         * l'ordine di
         * inserimento che richiede il GridLayout (da sx->dx e dall'alto->basso)
         * Vedi DEMO.
         */
        JPanel pnlCentro = new JPanel(new GridLayout(2, 3, 5, 5));
        pnlCentro.setBackground(Color.GRAY);
        pnlCentro.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        for (int i = 0; i < numCaselleSlot; i++) {
            pnlCentro.add(txtsPayLine[i]);
        }
        for (int i = 0; i < numCaselleSlot; i++) {
            pnlCentro.add(btnsBlocco[i]);
        }

        /*
         * CONSEGNA 4 - INIT PANNELLO SUD (pnlSud): COMPOSTO DA 2 SOTTOPANNELLI inseriti
         * su GridLayout (2,1)
         * pnlSudUp: è un GridLayout (2,3) vedi DEMO
         * pnlSudDown: è un FlowLayout allineamneto a DESTRA vedi DEMO
         */

        JPanel pnlSudUp = new JPanel(new GridLayout(2, 3, 5, 5));
        pnlSudUp.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        pnlSudUp.add(btnCoin);
        pnlSudUp.add(lblCoin);
        pnlSudUp.add(new JPanel());
        pnlSudUp.add(comboCoin);
        pnlSudUp.add(cbConferma);
        pnlSudUp.add(new JPanel());

        JPanel pnlSudDown = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        pnlSudDown.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        pnlSudDown.add(btnGioca);
        pnlSudDown.add(btnRipristina);

        JPanel pnlSud = new JPanel(new GridLayout(2, 1));
        pnlSud.add(pnlSudUp);
        pnlSud.add(pnlSudDown);

        /*
         * CONSEGNA 5 - INIT CONTENT PANE
         * Imposta le 3 aree interessate del content pane
         */
        this.getContentPane().add(pnlNord, BorderLayout.NORTH);
        this.getContentPane().add(pnlCentro, BorderLayout.CENTER);
        this.getContentPane().add(pnlSud, BorderLayout.SOUTH);

    }/* ----------- FINE metodo initPannelli --------------- */

    private void initAscoltatori() {

        /*
         * CONSEGNA 6 - ASCOLTATORE A :
         * Per ogni BOTTONE DI BLOCCO devi associate un ascoltatore implementato su
         * classe ESTERNA
         * La classe dovrà essere nominata BtnsBloccoListener
         * 
         * COME RISPONDE L'ASCOLTATORE:
         * Se la manche permette di giocare (ci sono monete Coin disponibili) ...
         * deve bloccare la relativa casella slot (se è sbloccata) che diventa di colore
         * BLUE
         * deve abilitare la casella slot (se è bloccata) che diventa di colore GIALLO
         * contestualmente, il button stesso passa da "BLOCCA" in "ABILITA" e viceversa.
         * 
         * Bloccare una casella Slot significa che, alla prossima giocata, il valore
         * presente resta fisso (non varia)
         * L'azione di blocco casella costa 1 euro alla manche di gioco che va a
         * incrementare il jackpot.
         * 
         * Se non sono disponibili Coin btnGioca viene disabilistato e viene impostata
         * la stringa "GAME OVER"
         * 
         * Prova la DEMO per capire con precisione come si comporta tale scoltatore
         * nelle varie situazioni
         * 
         */

        for (int i = 0; i < numCaselleSlot; i++) {
            btnsBlocco[i].addActionListener(new BtnsBloccoListener(this, i)); /* ESTERNA */
        }

        /*
         * CONSEGNA 7 - ASCOLTATORE B:
         * Su btnCoin deve essere associato un ascoltatore implementato su classe
         * ANONIMA
         * L'ascoltatore permette di incrementare (di una unità) le Coin della mache di
         * giocata fino al raggiungimente di un valore massimo di 50 Coin.
         * Raggiunto tale limite il bottone si auto-disabilista e disbilita anche la
         * comboCoin.
         * 
         * Prova la DEMO per capire con precisione come si comporta tale scoltatore
         * nelle varie situazioni
         * 
         */
        btnCoin.addActionListener(new ActionListener() { /* ANONIMA */
            @Override
            public void actionPerformed(ActionEvent e) {
                lblCoin.incrementa();
                if (lblCoin.getValore() == 50) {
                    btnCoin.setEnabled(false);
                    comboCoin.setEnabled(false);
                }
            }
        });

        /*
         * CONSEGNA 8 - ASCOLTATORE C:
         * Su ComboCoin deve essere associato un ascoltatore implementato su classe
         * ANONIMA
         * L'ascoltatore si comporta in modo simile a btnCoin, la differenza sta nel
         * fatto che è possibile aggiornare la giocata in funzione della selezione
         * presente sulla combo stessa:
         * "FULL" imposta una manche di giocata piena (50 coin)
         * "20 EURO" aggiorna la manche di giocata incrementandola di 20 euro
         * "10 EURO" aggiorna la manche di giocata incrementandola di 10 euro
         * "5 EURO" aggiorna la manche di giocata incrementandola di 5 euro
         * L'aggiornamento deve essere tale da raggiungere il limite massimo di 50 euro,
         * in tal caso la comboCoin si auto-disbilita
         * e disabiita anche btnCoin.
         * 
         * Prova la DEMO per capire con precisione come si comporta tale scoltatore
         * nelle varie situazioni
         * 
         */
        comboCoin.addActionListener(new ActionListener() { /* ANONIMA */
            @Override
            public void actionPerformed(ActionEvent e) {
                int numMonete = 0;
                switch ((String) comboCoin.getSelectedItem()) {
                    case "Full":
                        numMonete = 50;
                        break;
                    case "20 euro":
                        numMonete = 20;
                        break;
                    case "10 euro":
                        numMonete = 10;
                        break;
                    case "5 euro":
                        numMonete = 5;
                        break;
                }
                lblCoin.aggiungi(numMonete);
                if (lblCoin.getValore() >= 50) {
                    lblCoin.setValore(50);
                    btnCoin.setEnabled(false);
                    comboCoin.setEnabled(false);
                }
            }
        });

        /*
         * CONSEGNA 9 - ASCOLTATORE D:
         * Su cbConferma, btnGioca e btnRipristina deve essere associato un unico
         * ascoltatore ActionListener su classe INTERNA
         * La classe dovrà essere nominata OtherBtnsListener
         * Tale ascoltatore deve essere in grado di risalire alla sorgente
         * che ha generato l'evento per mezzo del metodo getSource()
         * 
         * Se l'evento è stato generato da cbConferma
         * Si auto-disabilita e ciò significa che si conferma la mamnche di gioco
         * (numero di Coin che si vuole azzardare)! ... e non deve essere possibile
         * inserirne altri.
         * A questo punto abilita btnGioca che permette di giocare la manche
         * Prova la DEMO per capire con precisione come si comporta tale scoltatore
         * nelle varie situazioni
         * 
         * Se l'evento è stato generato da btnGioca
         * Permette di impostare un valore casuale (min 1 max 10) nelle claselle slot
         * della PayLine (solo su quelle non bloccate)
         * La giocata permette di ottenere un esito che potrebbe essere uno tra i
         * seguenti:
         * 1) Tutte le caselle slot della PayLine sono uguali -> si vince il JACKPOT
         * (segnalato come testo su btnGioca) e la manche termina!
         * 2) Le caselle slot della PayLine assumono una configurazione palindroma -> si
         * vince il JACKPOT (segnalato come testo su btnGioca) e la manche termina!
         * 3) Le caselle slot della PayLine assumono una configurazione di valori
         * consecutivi crescenti -> si vince il JACKPOT (segnalato come testo su
         * btnGioca) e la manche termina!
         * 4) La giocata non presenta nessuno dei 3 acenri precedenti -> si continua a
         * giocare la manche in corso fino ad esaurimento Coin.
         * Dopo la giocata abilita tutte le celle bloccate
         * Ogni singola giocata costa 1 euro che viene tolto dalla manche di gioco per
         * incrementare il jackpot
         * Esauriti i Coin della manche si auto setta in "GAME OVER"
         * Prova la DEMO per capire con precisione come si comporta tale scoltatore
         * nelle varie situazioni
         * 
         * Se l'evento è stato generato da btnRipristina
         * Permette di reimpostare lo stato iniziale del form ovvero:
         * - Il jackpot viene reimpostato a 100 euro
         * - tutte le caselle slot della PyLine sono resettate
         * - tutti i btn di blocco vengono reimpostati a "BLOCCA"
         * - btnCoin e comboCoin vengono abilitati
         * - cbConferma viene abilitata e non selezionata
         * - lblCoin viene azzerata
         * - btnGioca viene reimpostata a "GIOCA" e disabilitata
         * Prova la DEMO per capire con precisione come si comporta tale scoltatore
         * nelle varie situazioni
         */

        ActionListener ascoltatore = new OtherBtnsListener();
        btnGioca.addActionListener(ascoltatore); /* INTERNA */
        cbConferma.addActionListener(ascoltatore); /* INTERNA */
        btnRipristina.addActionListener(ascoltatore); /* INTERNA */

    }/* ----------- FINE metodo initAscoltatori --------------- */

    private class OtherBtnsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == btnRipristina) {
                for (int i = 0; i < numCaselleSlot; i++) {
                    txtsPayLine[i].resetCasella();
                    btnsBlocco[i].setText("BLOCCA");
                }
                btnCoin.setEnabled(true);
                lblCoin.setValore(0);
                lblJackpot.setValore(100);
                comboCoin.setEnabled(true);
                comboCoin.setSelectedIndex(0);
                cbConferma.setEnabled(true);
                cbConferma.setSelected(false);
                btnGioca.setEnabled(false);
                btnGioca.setText("GIOCA");
            }

            if (e.getSource() == btnGioca) {
                if (lblCoin.getValore() > 0) {
                    lblJackpot.incrementa();
                    lblCoin.decrementa();
                    for (int i = 0; i < numCaselleSlot; i++) {
                        int ran = (int) (Math.random() * 10) + 1;
                        if (!txtsPayLine[i].isBloccata())
                            txtsPayLine[i].setValore(ran);
                    }
                    for (int i = 0; i < numCaselleSlot; i++) {
                        btnsBlocco[i].setText("BLOCCA");
                        if (txtsPayLine[i].isBloccata())
                            txtsPayLine[i].bloccaSblocca();
                    }
                    btnGioca.setText(esitoGiocata()); // richiama il metodo privato che stabilisce se ho fatto JACKPOT o
                                                      // se devo continuare a giocare
                    if (!btnGioca.getText().equals("GIOCA"))
                        btnGioca.setEnabled(false);
                }
                if (lblCoin.getValore() == 0) {
                    btnGioca.setText("GAME OVER");
                    btnGioca.setEnabled(false);
                }
            }

            if (e.getSource() == cbConferma) {
                if (cbConferma.isSelected() && lblCoin.getValore() > 0) {
                    btnCoin.setEnabled(false);
                    comboCoin.setEnabled(false);
                    btnGioca.setEnabled(true);
                    cbConferma.setEnabled(false);
                    btnGioca.doClick();

                }
            }

        }

        private String esitoGiocata() {

            int[] ls = new int[numCaselleSlot]; // arrray di supporto
            for (int i = 0; i < numCaselleSlot; i++) {
                ls[i] = txtsPayLine[i].getValore();
            }

             Controllo di sequenza con caselle slot tutte uguali
            boolean uguali = true;
            for (int i = 1; i < numCaselleSlot; i++) {
                if (ls[0] != ls[i])
                    uguali = false;
            }
            if (uguali)
                return "JACKPOT per " + numCaselleSlot + " caselle UGUALI";

             Controllo di sequenza con caselle slot in configurazione palindroma */
            boolean isPalindroma = true;
            int i = 0;
            int j = numCaselleSlot - 1;
            while (i < j && isPalindroma) {
                if (ls[i] != ls[j])
                    isPalindroma = false;
                i++;
                j--;
            }
            if (isPalindroma)
                return "JACKPOT per sequenza PALINDROMA";

            /*
             * Controllo di sequenza con caselle slot in configurazione di valori
             * consecutivi crescenti
             */
           boolean isCrescente = true;
            i = 0;
            while (i < numCaselleSlot - 1 && isCrescente) {
                if (ls[i] != ls[i + 1] - 1)
                    isCrescente = false;
                i++;
            }
            if (isCrescente)
                return "JACKPOT per sequenza CRESCENTE";

            /*
             * Se arrivo a questo punto significa che non si è verificato nessuno dei casi
             * precedenti
             * e il gioco più continuare ...
             */
            return "GIOCA";

        }
    } /* FINE CLASSE INTERNA OtherBtnsListener */

} /* ----------- FINE CLASSE Frame ---------------- */
