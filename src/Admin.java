import java.awt.Dimension;
import java.awt.Toolkit;

public class Admin extends javax.swing.JFrame {

    public Admin() {
        initComponents();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = getSize();
        setLocation(
                (screenSize.width - frameSize.width) / 2,
                (screenSize.height - frameSize.height) / 2);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGlass1 = new usu.widget.ButtonGlass();
        buttonGlass3 = new usu.widget.ButtonGlass();
        buttonGlass4 = new usu.widget.ButtonGlass();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        omzet = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonGlass1.setForeground(new java.awt.Color(246, 246, 246));
        buttonGlass1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/user_iconn.png"))); // NOI18N
        buttonGlass1.setText("Tambah User");
        buttonGlass1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGlass1ActionPerformed(evt);
            }
        });
        getContentPane().add(buttonGlass1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        buttonGlass3.setForeground(new java.awt.Color(246, 249, 254));
        buttonGlass3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/add_mobil.png"))); // NOI18N
        buttonGlass3.setText("Tambah Mobil");
        buttonGlass3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGlass3ActionPerformed(evt);
            }
        });
        getContentPane().add(buttonGlass3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, -1, -1));

        buttonGlass4.setForeground(new java.awt.Color(254, 254, 254));
        buttonGlass4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/close_delete.png"))); // NOI18N
        buttonGlass4.setText("Log Out");
        buttonGlass4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGlass4ActionPerformed(evt);
            }
        });
        getContentPane().add(buttonGlass4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, -1, -1));

        jLabel2.setFont(new java.awt.Font("Bebas Neue", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(254, 254, 254));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 180, 30));

        jLabel4.setFont(new java.awt.Font("Bebas Neue", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(254, 254, 254));
        jLabel4.setText("Menu Admin");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, -1, -1));

        omzet.setFont(new java.awt.Font("Bebas Neue", 0, 24)); // NOI18N
        omzet.setForeground(new java.awt.Color(254, 254, 254));
        omzet.setText("Rp.");
        getContentPane().add(omzet, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/backOk.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 280));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonGlass1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGlass1ActionPerformed
        // TODO add your handling code here:
        new user_form().show();
        super.dispose();
    }//GEN-LAST:event_buttonGlass1ActionPerformed

    private void buttonGlass3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGlass3ActionPerformed
        // TODO add your handling code here:
        new mobil_form().show();
        super.dispose();
    }//GEN-LAST:event_buttonGlass3ActionPerformed

    private void buttonGlass4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGlass4ActionPerformed
        // TODO add your handling code here:
        new login_form().show();
        super.dispose();
    }//GEN-LAST:event_buttonGlass4ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private usu.widget.ButtonGlass buttonGlass1;
    private usu.widget.ButtonGlass buttonGlass3;
    private usu.widget.ButtonGlass buttonGlass4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel omzet;
    // End of variables declaration//GEN-END:variables
}
