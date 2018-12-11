
import Connection.Koneksi;
import Connection.ResultSetTableModel;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class mobil_form extends javax.swing.JFrame {

    public mobil_form() {
        initComponents();
        tampiltabel();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = getSize();
        setLocation(
                (screenSize.width - frameSize.width) / 2,
                (screenSize.height - frameSize.height) / 2);
    }
    String id_mobil;

    void tampiltabel() {
        try {
            Koneksi objkoneksi = new Koneksi();
            Connection con = objkoneksi.bukakoneksi();
            Statement st = con.createStatement();
            String sql = "select *from data_mobil";
            ResultSet set = st.executeQuery(sql);
            ResultSetTableModel model = new ResultSetTableModel(set);
            tabel_mobil.setModel(model);
        } catch (SQLException e) {
            System.out.println("gagal query ini" + e);
        }
    }

    private void clear() {

        merk_mobil.setText("");
        tipe_mobil.setSelectedItem("--Pilih Tipe--");
        tahun_mobil.setSelectedItem("--Pilih Tahun--");
        nopol_mobil.setText("");
        sewa_mobil.setText("");
        status_mobil.setSelectedItem("--Pilih Status--");

    }

    void tambah() {
        if (merk_mobil.getText().isEmpty() || tipe_mobil.getSelectedItem().equals("--Pilih Tipe--") || tahun_mobil.getSelectedItem().equals("--Pilih Tahun--") || nopol_mobil.getText().isEmpty() || sewa_mobil.getText().isEmpty() || status_mobil.getSelectedItem().equals("--Pilih Status--")) {
            JOptionPane.showMessageDialog(this, "Data yang dimasukkan tidak lengkap!");
        } else {
            try {
                Koneksi objkoneksi = new Koneksi();
                Connection con = objkoneksi.bukakoneksi();
                Statement st = con.createStatement();
                String sql = "insert into data_mobil (nopol_mobil, merk_mobil, tipe_mobil, tahun_mobil, sewa_mobil,status_mobil)" + "values ('" + nopol_mobil.getText() + "','" + merk_mobil.getText() + "','" + tipe_mobil.getSelectedItem() + "','" + tahun_mobil.getSelectedItem() + "','" + sewa_mobil.getText() + "','" + status_mobil.getSelectedItem() + "')";
                int row = st.executeUpdate(sql);
                if (row == 1) {
                    JOptionPane.showMessageDialog(null, "Data mobil sudah ditambahkan ke database", "informasi", JOptionPane.INFORMATION_MESSAGE);
                    con.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Data mobil tidak ditambahkan ke database" + e, "informasi", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        clear();
        tampiltabel();

    }

    void ubah() {
        try {
            Koneksi objkoneksi = new Koneksi();
            Connection con = objkoneksi.bukakoneksi();
            Statement st = con.createStatement();
            String sql = "update data_mobil set merk_mobil = '" + merk_mobil.getText() + "',"
                    + "tipe_mobil = '" + tipe_mobil.getSelectedItem() + "',"
                    + "tahun_mobil = '" + tahun_mobil.getSelectedItem() + "',"
                    + "sewa_mobil = '" + sewa_mobil.getText() + "',"
                    + "status_mobil = '" + status_mobil.getSelectedItem() + "'"
                    + "where nopol_mobil ='" + nopol_mobil.getText() + "'";
            int row = st.executeUpdate(sql);
            if (row == 1) {
                JOptionPane.showMessageDialog(null, "Data sudah diupdate", "informasi", JOptionPane.INFORMATION_MESSAGE);
                con.close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "data tidak diubah"
                    + e, "informasi", JOptionPane.INFORMATION_MESSAGE);
        }
        clear();
        tampiltabel();
    }

    void cari() {
        if (txt_search_AddItem.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Isikan data pencarian");
        } else {
            try {

                Koneksi objkoneksi = new Koneksi();
                Connection con = objkoneksi.bukakoneksi();
                Statement st = con.createStatement();
                String sql = "select *from data_mobil where merk_mobil LIKE '%" + txt_search_AddItem.getText() + "%' OR tipe_mobil LIKE '%" + txt_search_AddItem.getText() + "%' OR nopol_mobil LIKE '%" + txt_search_AddItem.getText() + "%' OR sewa_mobil LIKE '%" + txt_search_AddItem.getText() + "%' OR status_mobil LIKE '%" + txt_search_AddItem.getText() + "%' OR tahun_mobil LIKE '%" + txt_search_AddItem.getText() + "%'";
                ResultSet set = st.executeQuery(sql);
                ResultSetTableModel model = new ResultSetTableModel(set);
                tabel_mobil.setModel(model);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Pencarian Error");
            }
        }
    }

    void hapus() {
        try {
            Koneksi objkoneksi = new Koneksi();
            Connection con = objkoneksi.bukakoneksi();
            Statement st = con.createStatement();
            String id = String.valueOf(tabel_mobil.getValueAt(tabel_mobil.getSelectedRow(), 0));
            String sql = "delete from data_mobil where nopol_mobil= '" + id + "'";
            int confirm = JOptionPane.showConfirmDialog(this,
                    "Yakin untuk menghapus data ini?",
                    "Konfirmasi Hapus ",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
            if (confirm == JOptionPane.YES_OPTION) {
                int row = st.executeUpdate(sql);
                if (row == 1) {
                    JOptionPane.showMessageDialog(null, "Data sudah dihapus dari database", "informasi", JOptionPane.INFORMATION_MESSAGE);
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonBeanInfo1 = new usu.widget.ButtonBeanInfo();
        buttonGlass1 = new usu.widget.ButtonGlass();
        btn_Edit_addItem = new usu.widget.ButtonGlass();
        btn_create_addItem = new usu.widget.ButtonGlass();
        btn_Delete__addItem = new usu.widget.ButtonGlass();
        panelGlass6 = new usu.widget.glass.PanelGlass();
        txt_search_AddItem = new javax.swing.JTextField();
        btn_Search_AddItem = new usu.widget.ButtonGlass();
        panelGlass1 = new usu.widget.glass.PanelGlass();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        merk_mobil = new javax.swing.JTextField();
        tahun_mobil = new javax.swing.JComboBox();
        nopol_mobil = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        status_mobil = new javax.swing.JComboBox();
        jLabel16 = new javax.swing.JLabel();
        tipe_mobil = new javax.swing.JComboBox();
        sewa_mobil = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_mobil = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonGlass1.setForeground(new java.awt.Color(254, 254, 254));
        buttonGlass1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/arrow_left.png"))); // NOI18N
        buttonGlass1.setText("Kembali");
        buttonGlass1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGlass1ActionPerformed(evt);
            }
        });
        getContentPane().add(buttonGlass1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, -1, -1));

        btn_Edit_addItem.setForeground(new java.awt.Color(255, 255, 255));
        btn_Edit_addItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/pencil_edit.png"))); // NOI18N
        btn_Edit_addItem.setText("Ubah");
        btn_Edit_addItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Edit_addItemActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Edit_addItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 370, 190, -1));

        btn_create_addItem.setForeground(new java.awt.Color(255, 255, 255));
        btn_create_addItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/plus.png"))); // NOI18N
        btn_create_addItem.setText("Tambah");
        btn_create_addItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_create_addItemActionPerformed(evt);
            }
        });
        getContentPane().add(btn_create_addItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 370, 190, -1));

        btn_Delete__addItem.setForeground(new java.awt.Color(255, 255, 255));
        btn_Delete__addItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/trash_box.png"))); // NOI18N
        btn_Delete__addItem.setText("Hapus");
        btn_Delete__addItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Delete__addItemActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Delete__addItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 370, 190, -1));

        btn_Search_AddItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/search_lense.png"))); // NOI18N
        btn_Search_AddItem.setRoundRect(true);
        btn_Search_AddItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Search_AddItemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelGlass6Layout = new javax.swing.GroupLayout(panelGlass6);
        panelGlass6.setLayout(panelGlass6Layout);
        panelGlass6Layout.setHorizontalGroup(
            panelGlass6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGlass6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txt_search_AddItem, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Search_AddItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelGlass6Layout.setVerticalGroup(
            panelGlass6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGlass6Layout.createSequentialGroup()
                .addGroup(panelGlass6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_search_AddItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Search_AddItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(panelGlass6, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 430, 550, 60));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Tahun Produksi");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Tipe Kendaraan");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Merk Kendaraan");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("No. Polisi");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Tarif/hari");

        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText(":");

        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText(":");

        jLabel13.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText(":");

        jLabel12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText(":");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText(":");

        merk_mobil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                merk_mobilActionPerformed(evt);
            }
        });

        tahun_mobil.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--Pilih Tahun--", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000" }));
        tahun_mobil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tahun_mobilActionPerformed(evt);
            }
        });

        nopol_mobil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nopol_mobilActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Status");

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText(":");

        status_mobil.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--Pilih Status--", "Tersedia", "Keluar" }));
        status_mobil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                status_mobilActionPerformed(evt);
            }
        });

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/car copy.png"))); // NOI18N

        tipe_mobil.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--Pilih Tipe--", "Sedan", "Mini Bus", "Jip", "Pickup" }));
        tipe_mobil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipe_mobilActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelGlass1Layout = new javax.swing.GroupLayout(panelGlass1);
        panelGlass1.setLayout(panelGlass1Layout);
        panelGlass1Layout.setHorizontalGroup(
            panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGlass1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGlass1Layout.createSequentialGroup()
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(29, 29, 29))
                        .addGroup(panelGlass1Layout.createSequentialGroup()
                            .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelGlass1Layout.createSequentialGroup()
                                    .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(6, 6, 6)
                                    .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(panelGlass1Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(20, 20, 20)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(4, 4, 4)))
                    .addComponent(jLabel2)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(status_mobil, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tipe_mobil, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(merk_mobil)
                    .addComponent(nopol_mobil)
                    .addComponent(tahun_mobil, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sewa_mobil, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addGap(75, 75, 75))
        );
        panelGlass1Layout.setVerticalGroup(
            panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGlass1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGlass1Layout.createSequentialGroup()
                        .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(jLabel10))
                            .addGroup(panelGlass1Layout.createSequentialGroup()
                                .addComponent(merk_mobil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel11)
                                        .addComponent(jLabel5))
                                    .addComponent(tipe_mobil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(jLabel12))
                            .addComponent(tahun_mobil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelGlass1Layout.createSequentialGroup()
                                .addComponent(nopol_mobil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGlass1Layout.createSequentialGroup()
                                .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel13))
                                .addGap(18, 18, 18)))
                        .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(sewa_mobil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGlass1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(status_mobil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)))
                    .addGroup(panelGlass1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        getContentPane().add(panelGlass1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 800, -1));

        tabel_mobil.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "", "", "", ""
            }
        ));
        tabel_mobil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_mobilMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel_mobil);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 520, 710, 130));

        jLabel15.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Tambah Kendaraan");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, -1, -1));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/backOk.png"))); // NOI18N
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nopol_mobilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nopol_mobilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nopol_mobilActionPerformed

    private void tabel_mobilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_mobilMouseClicked
        int baris = tabel_mobil.getSelectedRow();
        if (evt.getClickCount() > 0) {
            try {
                Koneksi objkoneksi = new Koneksi();
                Connection con = objkoneksi.bukakoneksi();
                Statement st = con.createStatement();
                String sql = "select *from data_mobil where nopol_mobil='" + tabel_mobil.getValueAt(baris, 0).toString() + "'";
                ResultSet rs = st.executeQuery(sql);
                rs.last();
                merk_mobil.setText(rs.getString("merk_mobil"));
                tipe_mobil.setSelectedItem(rs.getString("tipe_mobil"));
                tahun_mobil.setSelectedItem(rs.getString("tahun_mobil"));
                nopol_mobil.setText(rs.getString("nopol_mobil"));
                sewa_mobil.setText(rs.getString("sewa_mobil"));
                status_mobil.setSelectedItem(rs.getString("status_mobil"));
            } catch (SQLException e) {
                System.out.println("gagal mengambil data dari tabel" + e);
            }
        }
    }//GEN-LAST:event_tabel_mobilMouseClicked

    private void btn_Search_AddItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Search_AddItemActionPerformed
        cari();
    }//GEN-LAST:event_btn_Search_AddItemActionPerformed

    private void btn_Edit_addItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Edit_addItemActionPerformed
        ubah();
    }//GEN-LAST:event_btn_Edit_addItemActionPerformed

    private void btn_create_addItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_create_addItemActionPerformed
        tambah();
    }//GEN-LAST:event_btn_create_addItemActionPerformed

    private void btn_Delete__addItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Delete__addItemActionPerformed
        hapus();
    }//GEN-LAST:event_btn_Delete__addItemActionPerformed

    private void merk_mobilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_merk_mobilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_merk_mobilActionPerformed

    private void status_mobilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_status_mobilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_status_mobilActionPerformed

    private void buttonGlass1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGlass1ActionPerformed
        // TODO add your handling code here:
        new Admin().show();
        super.dispose();
    }//GEN-LAST:event_buttonGlass1ActionPerformed

    private void tahun_mobilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tahun_mobilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tahun_mobilActionPerformed

    private void tipe_mobilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipe_mobilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tipe_mobilActionPerformed

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mobil_form().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private usu.widget.ButtonGlass btn_Delete__addItem;
    private usu.widget.ButtonGlass btn_Edit_addItem;
    private usu.widget.ButtonGlass btn_Search_AddItem;
    private usu.widget.ButtonGlass btn_create_addItem;
    private usu.widget.ButtonBeanInfo buttonBeanInfo1;
    private usu.widget.ButtonGlass buttonGlass1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField merk_mobil;
    private javax.swing.JTextField nopol_mobil;
    private usu.widget.glass.PanelGlass panelGlass1;
    private usu.widget.glass.PanelGlass panelGlass6;
    private javax.swing.JTextField sewa_mobil;
    private javax.swing.JComboBox status_mobil;
    private javax.swing.JTable tabel_mobil;
    private javax.swing.JComboBox tahun_mobil;
    private javax.swing.JComboBox tipe_mobil;
    private javax.swing.JTextField txt_search_AddItem;
    // End of variables declaration//GEN-END:variables
}
