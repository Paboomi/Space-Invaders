package spaceinvaders.frontend.opciones;

import java.awt.BorderLayout;
import javax.swing.*;
import spaceinvaders.backend.Contador;
import spaceinvaders.backend.GameLoop;
import spaceinvaders.frontend.juego.Juego;

public class SpaceInvaders extends javax.swing.JFrame {

    private Contador contador;

    public SpaceInvaders() {
        Juego juego = new Juego();
        initComponents();
        pnlJuego.setLayout(new BorderLayout());
        pnlJuego.add(juego, BorderLayout.CENTER);
        contador = new Contador(90,
                e -> lblTimer.setText(Integer.toString(contador.getCount())),
                () -> JOptionPane.showMessageDialog(this, "Termino el tiempo")
        );
        contador.start();
        setVisible(true);
        new GameLoop(juego).start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlIndicadores = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblScore = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblTimer = new javax.swing.JLabel();
        pnlJuego = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlIndicadores.setBackground(new java.awt.Color(5, 42, 117));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/spaceinvaders/Images/score.png"))); // NOI18N

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Score");

        lblScore.setBackground(new java.awt.Color(0, 0, 0));
        lblScore.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblScore.setForeground(new java.awt.Color(255, 255, 255));
        lblScore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblScore.setText("0");
        lblScore.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/spaceinvaders/Images/temporizador.gif"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Time");

        lblTimer.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblTimer.setForeground(new java.awt.Color(255, 255, 255));
        lblTimer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTimer.setText("90");

        javax.swing.GroupLayout pnlIndicadoresLayout = new javax.swing.GroupLayout(pnlIndicadores);
        pnlIndicadores.setLayout(pnlIndicadoresLayout);
        pnlIndicadoresLayout.setHorizontalGroup(
            pnlIndicadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlIndicadoresLayout.createSequentialGroup()
                .addGap(278, 278, 278)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(pnlIndicadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblScore, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(66, 66, 66)
                .addComponent(jLabel3)
                .addGroup(pnlIndicadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlIndicadoresLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel4))
                    .addGroup(pnlIndicadoresLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblTimer, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(489, Short.MAX_VALUE))
        );
        pnlIndicadoresLayout.setVerticalGroup(
            pnlIndicadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlIndicadoresLayout.createSequentialGroup()
                .addGroup(pnlIndicadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlIndicadoresLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTimer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlIndicadoresLayout.createSequentialGroup()
                        .addGroup(pnlIndicadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlIndicadoresLayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel1))
                            .addGroup(pnlIndicadoresLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblScore, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlIndicadoresLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout pnlJuegoLayout = new javax.swing.GroupLayout(pnlJuego);
        pnlJuego.setLayout(pnlJuegoLayout);
        pnlJuegoLayout.setHorizontalGroup(
            pnlJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1178, Short.MAX_VALUE)
        );
        pnlJuegoLayout.setVerticalGroup(
            pnlJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 587, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlIndicadores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(pnlJuego, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlIndicadores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(597, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(117, Short.MAX_VALUE)
                    .addComponent(pnlJuego, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblScore;
    private javax.swing.JLabel lblTimer;
    private javax.swing.JPanel pnlIndicadores;
    private javax.swing.JPanel pnlJuego;
    // End of variables declaration//GEN-END:variables
}
