
import java.awt.*;

public class Home extends javax.swing.JFrame {

    public Home() {
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

        jLabel2 = new javax.swing.JLabel();
        buttonGlass4 = new usu.widget.ButtonGlass();
        buttonGlass1 = new usu.widget.ButtonGlass();
        peminjaman = new usu.widget.ButtonGlass();
        buttonGlass5 = new usu.widget.ButtonGlass();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Bebas Neue", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(254, 254, 254));
        jLabel2.setText("RENTAL MOBIL");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, -1, 30));

        buttonGlass4.setForeground(new java.awt.Color(254, 254, 254));
        buttonGlass4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/log_off.png"))); // NOI18N
        buttonGlass4.setText("Log Out");
        buttonGlass4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGlass4ActionPerformed(evt);
            }
        });
        getContentPane().add(buttonGlass4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 170, 210, 70));

        buttonGlass1.setForeground(new java.awt.Color(254, 254, 254));
        buttonGlass1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/kembali_mobil.png"))); // NOI18N
        buttonGlass1.setText("Pengembalian Mobil");
        buttonGlass1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGlass1ActionPerformed(evt);
            }
        });
        getContentPane().add(buttonGlass1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, 210, 70));

        peminjaman.setForeground(new java.awt.Color(254, 254, 254));
        peminjaman.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/pinjam.png"))); // NOI18N
        peminjaman.setText("Peminjaman Mobil");
        peminjaman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                peminjamanActionPerformed(evt);
            }
        });
        getContentPane().add(peminjaman, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 210, 70));

        buttonGlass5.setForeground(new java.awt.Color(254, 254, 254));
        buttonGlass5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/user_iconn.png"))); // NOI18N
        buttonGlass5.setText("Tambah Sopir");
        buttonGlass5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGlass5ActionPerformed(evt);
            }
        });
        getContentPane().add(buttonGlass5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 210, 70));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/backOk.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void peminjamanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_peminjamanActionPerformed
        // TODO add your handling code here:
        new pelanggan_form().show();
        super.dispose();
    }//GEN-LAST:event_peminjamanActionPerformed

    private void buttonGlass4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGlass4ActionPerformed
        // TODO add your handling code here:
        new login_form().show();
        super.dispose();
    }//GEN-LAST:event_buttonGlass4ActionPerformed

    private void buttonGlass5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGlass5ActionPerformed
        // TODO add your handling code here:
        new sopir_form().show();
        super.dispose();
    }//GEN-LAST:event_buttonGlass5ActionPerformed

    private void buttonGlass1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGlass1ActionPerformed
        // TODO add your handling code here:
        new pengembalian_form().show();
        super.dispose();
    }//GEN-LAST:event_buttonGlass1ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private usu.widget.ButtonGlass buttonGlass1;
    private usu.widget.ButtonGlass buttonGlass4;
    private usu.widget.ButtonGlass buttonGlass5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private usu.widget.ButtonGlass peminjaman;
    // End of variables declaration//GEN-END:variables
}