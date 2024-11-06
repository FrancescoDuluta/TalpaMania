/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.*;
import java.awt.*;
/**
 *
 * @author duluta11265
 */
public class LobbyFrame extends javax.swing.JFrame {

    protected int difficulty; 
    /**
     * Creates new form GameFrame
     */
    public LobbyFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        pnlTitoli = new javax.swing.JPanel();
        lblTitolo = new javax.swing.JLabel();
        lblSottotitolo = new javax.swing.JLabel();
        pnlDifficolta = new javax.swing.JPanel();
        lblScegliDifficicolta = new javax.swing.JLabel();
        rbFacile = new javax.swing.JRadioButton();
        rbMedia = new javax.swing.JRadioButton();
        rbDifficile = new javax.swing.JRadioButton();
        sfondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TalpaMania");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(204, 255, 255));
        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/cursor.png")), new Point(0, 0), "Custom Cursor"));
        setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        setForeground(java.awt.Color.white);
        setIconImages(null);
        setLocation(new java.awt.Point(500, 250));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlTitoli.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        pnlTitoli.setOpaque(false);

        lblTitolo.setFont(new java.awt.Font("Segoe Print", 1, 36)); // NOI18N
        lblTitolo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitolo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitolo.setText("TalpaMania");
        lblTitolo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblSottotitolo.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        lblSottotitolo.setForeground(new java.awt.Color(255, 255, 255));
        lblSottotitolo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSottotitolo.setText("Acchiappa le talpe prima che sia troppo tardi...");

        javax.swing.GroupLayout pnlTitoliLayout = new javax.swing.GroupLayout(pnlTitoli);
        pnlTitoli.setLayout(pnlTitoliLayout);
        pnlTitoliLayout.setHorizontalGroup(
            pnlTitoliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTitoliLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSottotitolo, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(pnlTitoliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlTitoliLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lblTitolo, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        pnlTitoliLayout.setVerticalGroup(
            pnlTitoliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTitoliLayout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addComponent(lblSottotitolo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(pnlTitoliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlTitoliLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lblTitolo, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(43, Short.MAX_VALUE)))
        );

        getContentPane().add(pnlTitoli, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 100));

        pnlDifficolta.setOpaque(false);

        lblScegliDifficicolta.setFont(new java.awt.Font("Segoe Print", 1, 24)); // NOI18N
        lblScegliDifficicolta.setForeground(new java.awt.Color(255, 255, 255));
        lblScegliDifficicolta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblScegliDifficicolta.setText("Scegli una difficoltà:");

        rbFacile.setBackground(new java.awt.Color(102, 51, 255));
        buttonGroup1.add(rbFacile);
        rbFacile.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        rbFacile.setForeground(new java.awt.Color(255, 255, 255));
        rbFacile.setText("Facile");
        rbFacile.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rbFacile.setIconTextGap(10);
        rbFacile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbFacileActionPerformed(evt);
            }
        });

        rbMedia.setBackground(new java.awt.Color(102, 51, 255));
        buttonGroup1.add(rbMedia);
        rbMedia.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        rbMedia.setForeground(new java.awt.Color(255, 255, 255));
        rbMedia.setText("Media");
        rbMedia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rbMedia.setIconTextGap(10);
        rbMedia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbMediaActionPerformed(evt);
            }
        });

        rbDifficile.setBackground(new java.awt.Color(102, 51, 255));
        buttonGroup1.add(rbDifficile);
        rbDifficile.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        rbDifficile.setForeground(new java.awt.Color(255, 255, 255));
        rbDifficile.setText("Difficile");
        rbDifficile.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rbDifficile.setIconTextGap(10);
        rbDifficile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbDifficileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDifficoltaLayout = new javax.swing.GroupLayout(pnlDifficolta);
        pnlDifficolta.setLayout(pnlDifficoltaLayout);
        pnlDifficoltaLayout.setHorizontalGroup(
            pnlDifficoltaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDifficoltaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDifficoltaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbFacile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rbMedia, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
                    .addComponent(rbDifficile, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(lblScegliDifficicolta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlDifficoltaLayout.setVerticalGroup(
            pnlDifficoltaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDifficoltaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblScegliDifficicolta, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rbFacile)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbMedia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbDifficile)
                .addGap(86, 86, 86))
        );

        getContentPane().add(pnlDifficolta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 600, 280));

        sfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/background.png"))); // NOI18N
        sfondo.setText(" ");
        getContentPane().add(sfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbFacileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbFacileActionPerformed
        GameFrame gameFrame = new GameFrame();
        gameFrame.show(); //display gameFrame here
        difficulty = 1;
        dispose(); // close current frame (lobby) after opening gameFrame
    }//GEN-LAST:event_rbFacileActionPerformed

    private void rbMediaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbMediaActionPerformed
        GameFrame gameFrame = new GameFrame();
        gameFrame.show(); //display gameFrame here
        difficulty = 2;
        dispose(); // close current frame (lobby) after opening gameFrame
    }//GEN-LAST:event_rbMediaActionPerformed

    private void rbDifficileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbDifficileActionPerformed
        GameFrame gameFrame = new GameFrame();
        gameFrame.show(); //display gameFrame here
        difficulty = 3;
        dispose(); // close current frame (lobby) after opening gameFrame
    }//GEN-LAST:event_rbDifficileActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LobbyFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LobbyFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LobbyFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LobbyFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LobbyFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel lblScegliDifficicolta;
    private javax.swing.JLabel lblSottotitolo;
    private javax.swing.JLabel lblTitolo;
    private javax.swing.JPanel pnlDifficolta;
    private javax.swing.JPanel pnlTitoli;
    private javax.swing.JRadioButton rbDifficile;
    private javax.swing.JRadioButton rbFacile;
    private javax.swing.JRadioButton rbMedia;
    private javax.swing.JLabel sfondo;
    // End of variables declaration//GEN-END:variables
}