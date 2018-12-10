
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import Connection.*;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class user_form extends javax.swing.JFrame {

    public user_form() {
        initComponents();
        tampiltabel();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = getSize();
        setLocation(
                (screenSize.width - frameSize.width) / 2,
                (screenSize.height - frameSize.height) / 2);
    }
    String id_user;

    void tampiltabel() {
        try {
            Koneksi objkoneksi = new Koneksi();
            Connection con = objkoneksi.bukakoneksi();
            Statement st = con.createStatement();
            String sql = "select *from data_user";
            ResultSet set = st.executeQuery(sql);
            ResultSetTableModel model = new ResultSetTableModel(set);
            tabel.setModel(model);
        } catch (SQLException e) {
            System.out.println("gagal query ini" + e);
        }
    }

    private void clear() {
        nik_user.setText("");
        nama_user.setText("");
        alamat_user.setText("");
        telp_user.setText("");
        username_user.setText("");
        password_user.setText("");
        tipe_user.setSelectedItem("--Pilih Tipe--");
    }

    void hapus() {
        try {
            Koneksi objkoneksi = new Koneksi();
            Connection con = objkoneksi.bukakoneksi();
            Statement st = con.createStatement();
            String id = String.valueOf(tabel.getValueAt(tabel.getSelectedRow(), 0));
            String sql = "delete from data_user where nik_user= '" + id + "'";
            int confirm = JOptionPane.showConfirmDialog(this,
                    "Yakin untuk menghapus data ini?",
                    "Konfirmasi Hapus ",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
            if (confirm == JOptionPane.YES_OPTION) {
                int row = st.executeUpdate(sql);
                if (row == 1) {
                    JOptionPane.showMessageDialog(null, "data sudah dihapus dari database", "informasi", JOptionPane.INFORMATION_MESSAGE);
                    con.close();
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "data tidak dihapus" + e, "informasi", JOptionPane.INFORMATION_MESSAGE);
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "data tidak dihapus" + e, "informasi", JOptionPane.INFORMATION_MESSAGE);
        }
        tampiltabel();
        clear();
    }

    void ubah() {
        try {

            Koneksi objkoneksi = new Koneksi();
            Connection con = objkoneksi.bukakoneksi();
            Statement st = con.createStatement();
            String id = String.valueOf(tabel.getValueAt(tabel.getSelectedRow(), 0));
            String sql = "update data_user set nik_user = '" + nik_user.getText() + "',"
                    + "nama_user= '" + nama_user.getText() + "',"
                    + "alamat_user= '" + alamat_user.getText() + "',"
                    + "telp_user= '" + telp_user.getText() + "',"
                    + "username_user= '" + username_user.getText() + "',"
                    + "password_user = '" + password_user.getText() + "',"
                    + "type_user = '" + tipe_user.getSelectedItem() + "'"
                    + "where nik_user ='" + id + "'";
            int row = st.executeUpdate(sql);
            if (row == 1) {
                JOptionPane.showMessageDialog(null, "Data sudah diupdate", "informasi", JOptionPane.INFORMATION_MESSAGE);
                con.close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data tidak diubah"
                    + e, "informasi", JOptionPane.INFORMATION_MESSAGE);
        }
        clear();
        tampiltabel();
    }

    void tambah() {
        if (username_user.getText().isEmpty() || password_user.getText().isEmpty() || tipe_user.getSelectedItem().equals("--Pilih Tipe--")) {
            JOptionPane.showMessageDialog(this, "Data yang dimasukkan tidak lengkap!");
        } else {
            try {
                Koneksi objkoneksi = new Koneksi();
                Connection con = objkoneksi.bukakoneksi();
                Statement st = con.createStatement();
                String sql = "insert into data_user (nik_user, nama_user, alamat_user, telp_user, username_user, password_user, type_user)" + "values ('" + nik_user.getText() + "','" + nama_user.getText() + "','" + alamat_user.getText() + "','" + telp_user.getText() + "','" + username_user.getText() + "','" + password_user.getText() + "','" + tipe_user.getSelectedItem() + "')";
                int row = st.executeUpdate(sql);
                if (row == 1) {
                    JOptionPane.showMessageDialog(null, "Data user sudah ditambahkan ke database ", " informasi ", JOptionPane.INFORMATION_MESSAGE);
                    con.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Data user tidak ditambahkan ke database " + e, " informasi ", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        clear();
        tampiltabel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGlass1 = new usu.widget.ButtonGlass();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        btn_create_user = new usu.widget.ButtonGlass();
        btn_Edit_user = new usu.widget.ButtonGlass();
        btn_Delete_user = new usu.widget.ButtonGlass();
        panelGlass1 = new usu.widget.glass.PanelGlass();
        username_user = new javax.swing.JTextField();
        password_user = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tipe_user = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        nik_user = new javax.swing.JTextField();
        nama_user = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        alamat_user = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        telp_user = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonGlass1.setForeground(new java.awt.Color(242, 242, 242));
        buttonGlass1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/arrow_left.png"))); // NOI18N
        buttonGlass1.setText("Kembali");
        buttonGlass1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGlass1ActionPerformed(evt);
            }
        });
        getContentPane().add(buttonGlass1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 120, 40));

        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "", "", ""
            }
        ));
        tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 450, 580, 100));

        btn_create_user.setForeground(new java.awt.Color(255, 255, 255));
        btn_create_user.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/plus.png"))); // NOI18N
        btn_create_user.setText("Tambah");
        btn_create_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_create_userActionPerformed(evt);
            }
        });
        getContentPane().add(btn_create_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 390, 190, -1));

        btn_Edit_user.setForeground(new java.awt.Color(255, 255, 255));
        btn_Edit_user.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/pencil_edit.png"))); // NOI18N
        btn_Edit_user.setText("Ubah");
        btn_Edit_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Edit_userActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Edit_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 390, 190, -1));

        btn_Delete_user.setForeground(new java.awt.Color(255, 255, 255));
        btn_Delete_user.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/trash_box.png"))); // NOI18N
        btn_Delete_user.setText("Hapus");
        btn_Delete_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Delete_userActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Delete_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 390, 190, -1));

        username_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                username_userActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("NIK                  :");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Username     :");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Password     :");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Type               :");

        tipe_user.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--Pilih Tipe--", "Admin", "Karyawan" }));
        tipe_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipe_userActionPerformed(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/user_tambah_icon.png"))); // NOI18N

        nik_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nik_userActionPerformed(evt);
            }
        });

        nama_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nama_userActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Nama              :");

        jLabel8.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Alamat            :");

        alamat_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alamat_userActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("No. Telp         :");

        telp_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telp_userActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelGlass1Layout = new javax.swing.GroupLayout(panelGlass1);
        panelGlass1.setLayout(panelGlass1Layout);
        panelGlass1Layout.setHorizontalGroup(
            panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGlass1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelGlass1Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(tipe_user, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelGlass1Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(password_user, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGlass1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(nik_user, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGlass1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nama_user, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(panelGlass1Layout.createSequentialGroup()
                            .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel8))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(username_user, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(alamat_user, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGlass1Layout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(telp_user, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(49, 49, 49)
                .addComponent(jLabel6)
                .addContainerGap())
        );
        panelGlass1Layout.setVerticalGroup(
            panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGlass1Layout.createSequentialGroup()
                .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGlass1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(nik_user, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(nama_user, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(alamat_user, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(telp_user, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(username_user, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(password_user, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(panelGlass1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tipe_user, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap())
        );

        getContentPane().add(panelGlass1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 680, 290));

        jLabel15.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Tambah User");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/backOk.png"))); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(957, 200));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -29, 840, 760));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
        int baris = tabel.getSelectedRow();
        if (evt.getClickCount() > 0) {
            try {
                Koneksi objkoneksi = new Koneksi();
                Connection con = objkoneksi.bukakoneksi();
                Statement st = con.createStatement();
                String sql = "select * from data_user where nik_user='" + tabel.getValueAt(baris, 0).toString() + "'";
                ResultSet rs = st.executeQuery(sql);
                rs.last();
                nik_user.setText(rs.getString("nik_user"));
                nama_user.setText(rs.getString("nama_user"));
                alamat_user.setText(rs.getString("alamat_user"));
                telp_user.setText(rs.getString("telp_user"));
                username_user.setText(rs.getString("username_user"));
                password_user.setText(rs.getString("password_user"));
                tipe_user.setSelectedItem(rs.getString("type_user"));
            } catch (SQLException e) {
                System.out.println("gagal mengambil data dari tabel" + e);
            }
        }
    }//GEN-LAST:event_tabelMouseClicked

    private void btn_create_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_create_userActionPerformed
        tambah();
    }//GEN-LAST:event_btn_create_userActionPerformed

    private void btn_Edit_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Edit_userActionPerformed

        ubah();
    }//GEN-LAST:event_btn_Edit_userActionPerformed

    private void btn_Delete_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Delete_userActionPerformed
        hapus();
    }//GEN-LAST:event_btn_Delete_userActionPerformed

    private void tipe_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipe_userActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tipe_userActionPerformed

    private void buttonGlass1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGlass1ActionPerformed
        // TODO add your handling code here:
        new Admin().show();
        super.dispose();
    }//GEN-LAST:event_buttonGlass1ActionPerformed

    private void username_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_username_userActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_username_userActionPerformed

    private void nik_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nik_userActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nik_userActionPerformed

    private void nama_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nama_userActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nama_userActionPerformed

    private void alamat_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alamat_userActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alamat_userActionPerformed

    private void telp_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telp_userActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telp_userActionPerformed

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
            java.util.logging.Logger.getLogger(user_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(user_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(user_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(user_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new user_form().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField alamat_user;
    private usu.widget.ButtonGlass btn_Delete_user;
    private usu.widget.ButtonGlass btn_Edit_user;
    private usu.widget.ButtonGlass btn_create_user;
    private usu.widget.ButtonGlass buttonGlass1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nama_user;
    private javax.swing.JTextField nik_user;
    private usu.widget.glass.PanelGlass panelGlass1;
    private javax.swing.JPasswordField password_user;
    private javax.swing.JTable tabel;
    private javax.swing.JTextField telp_user;
    private javax.swing.JComboBox tipe_user;
    private javax.swing.JTextField username_user;
    // End of variables declaration//GEN-END:variables
}
