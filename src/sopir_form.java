
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author fadwa
 */
public class sopir_form extends javax.swing.JFrame {

    /**
     * Creates new form sopir_form
     */
    public sopir_form() {
        initComponents();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = getSize();
        setLocation(
                (screenSize.width - frameSize.width) / 2,
                (screenSize.height - frameSize.height) / 2);
        tampiltabel();
    }

    void clear() {
        id_sopir.setText("");
        nama_sopir.setText("");
        alamat_sopir.setText("");
        telp_sopir.setText("");
        no_sim.setText("");
        tarif_sopir.setText("");

    }

    void tampiltabel() {
        try {
            Koneksi objkoneksi = new Koneksi();
            Connection con = objkoneksi.bukakoneksi();
            Statement st = con.createStatement();
            String sql = "select *from data_sopir";
            ResultSet set = st.executeQuery(sql);
            ResultSetTableModel model = new ResultSetTableModel(set);
            tabel_sopir.setModel(model);
        } catch (SQLException e) {
            System.out.println("gagal query ini" + e);
        }
    }

    void tambah() {

        if (id_sopir.getText().isEmpty() || nama_sopir.getText().isEmpty() || alamat_sopir.getText().isEmpty() || telp_sopir.getText().isEmpty() || no_sim.getText().isEmpty() || tarif_sopir.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Lengkapi data yang anda masukkan terlebih dahulu!");
        } else {
            try {
                Koneksi objkoneksi = new Koneksi();
                Connection con = objkoneksi.bukakoneksi();
                Statement st = con.createStatement();
                String sql = "insert into data_sopir (id_sopir, nama_sopir, alamat_sopir, telp_sopir, no_sim, tarif_sopir) values ('" + id_sopir.getText() + "','" + nama_sopir.getText() + "','" + alamat_sopir.getText() + "','" + telp_sopir.getText() + "','" + no_sim.getText() + "','" + tarif_sopir.getText() + "')";
                int row = st.executeUpdate(sql);
                if (row == 1) {
                    JOptionPane.showMessageDialog(null, "Data Sopir Sudah Ditambahkan", "informasi", JOptionPane.INFORMATION_MESSAGE);
                    con.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Data Sopir Gagal Ditambahkan" + e, "informasi", JOptionPane.INFORMATION_MESSAGE);
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
            String id = String.valueOf(tabel_sopir.getValueAt(tabel_sopir.getSelectedRow(), 0));
            String sql = "update data_sopir set nama_sopir = '" + nama_sopir.getText() + "',"
                    + "alamat_sopir = '" + alamat_sopir.getText() + "',"
                    + "telp_sopir = '" + telp_sopir.getText() + "',"
                    + "no_sim = '" + no_sim.getText() + "',"
                    + "tarif_sopir = '" + tarif_sopir.getText() + "'"
                    + "where id_sopir ='" + id + "'";
            int row = st.executeUpdate(sql);
            if (row == 1) {
                JOptionPane.showMessageDialog(null, "Data sudah diubah", "informasi", JOptionPane.INFORMATION_MESSAGE);
                con.close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "data tidak diubah"
                    + e, "informasi", JOptionPane.INFORMATION_MESSAGE);
        }
        clear();
        tampiltabel();
    }

    void hapus() {
        try {
            Koneksi objkoneksi = new Koneksi();
            Connection con = objkoneksi.bukakoneksi();
            Statement st = con.createStatement();
            String id = String.valueOf(tabel_sopir.getValueAt(tabel_sopir.getSelectedRow(), 0));
            String sql = "delete from data_sopir where id_sopir= '" + id + "'";
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

    void cari() {
        if (txt_search_sopir.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Isikan data pencarian");
        } else {
            try {

                Koneksi objkoneksi = new Koneksi();
                Connection con = objkoneksi.bukakoneksi();
                Statement st = con.createStatement();
                String sql = "select *from data_sopir where id_sopir LIKE '%" + txt_search_sopir.getText() + "%' OR nama_sopir LIKE '%" + txt_search_sopir.getText() + "%' OR alamat_sopir LIKE '%" + txt_search_sopir.getText() + "%' OR no_sim LIKE '%" + txt_search_sopir.getText() + "%' OR tarif_sopir LIKE '%" + txt_search_sopir.getText() + "%'";
                ResultSet set = st.executeQuery(sql);
                ResultSetTableModel model = new ResultSetTableModel(set);
                tabel_sopir.setModel(model);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Pencarian Error");
            }
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGlass4 = new usu.widget.glass.PanelGlass();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        nama_sopir = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        alamat_sopir = new javax.swing.JTextArea();
        jLabel21 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        telp_sopir = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        id_sopir = new javax.swing.JTextField();
        tarif_sopir = new javax.swing.JTextField();
        no_sim = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        buttonGlass1 = new usu.widget.ButtonGlass();
        btn_create_sopir = new usu.widget.ButtonGlass();
        jLabel35 = new javax.swing.JLabel();
        btn_Delete__hapus = new usu.widget.ButtonGlass();
        btn_Edit_sopir = new usu.widget.ButtonGlass();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_sopir = new javax.swing.JTable();
        panelGlass6 = new usu.widget.glass.PanelGlass();
        txt_search_sopir = new javax.swing.JTextField();
        btn_Search_sopir = new usu.widget.ButtonGlass();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText(":");

        jLabel18.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText(":");

        jLabel19.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("ID Sopir");

        jLabel30.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Alamat ");

        jLabel31.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText(":");

        jLabel32.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Telp");

        jLabel33.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText(":");

        nama_sopir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nama_sopirActionPerformed(evt);
            }
        });

        alamat_sopir.setColumns(20);
        alamat_sopir.setRows(5);
        jScrollPane3.setViewportView(alamat_sopir);

        jLabel21.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Data Sopir");

        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/sopircon.png"))); // NOI18N

        telp_sopir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telp_sopirActionPerformed(evt);
            }
        });

        jLabel36.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Nama");

        id_sopir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_sopirActionPerformed(evt);
            }
        });

        tarif_sopir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tarif_sopirActionPerformed(evt);
            }
        });

        no_sim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                no_simActionPerformed(evt);
            }
        });

        jLabel37.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("No SIM");

        jLabel38.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText(":");

        jLabel39.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("Tarif/jam");

        jLabel40.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText(":");

        javax.swing.GroupLayout panelGlass4Layout = new javax.swing.GroupLayout(panelGlass4);
        panelGlass4.setLayout(panelGlass4Layout);
        panelGlass4Layout.setHorizontalGroup(
            panelGlass4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGlass4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelGlass4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGlass4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelGlass4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelGlass4Layout.createSequentialGroup()
                                .addGroup(panelGlass4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelGlass4Layout.createSequentialGroup()
                                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelGlass4Layout.createSequentialGroup()
                                        .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(2, 2, 2))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGlass4Layout.createSequentialGroup()
                                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jLabel21)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGlass4Layout.createSequentialGroup()
                            .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelGlass4Layout.createSequentialGroup()
                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelGlass4Layout.createSequentialGroup()
                        .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelGlass4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGlass4Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(panelGlass4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nama_sopir, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(no_sim, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelGlass4Layout.createSequentialGroup()
                                .addGroup(panelGlass4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(telp_sopir, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(42, 42, 42)
                                .addComponent(jLabel34))))
                    .addComponent(id_sopir, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tarif_sopir, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        panelGlass4Layout.setVerticalGroup(
            panelGlass4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGlass4Layout.createSequentialGroup()
                .addGroup(panelGlass4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGlass4Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel21))
                    .addGroup(panelGlass4Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(panelGlass4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(id_sopir, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19)
                            .addComponent(jLabel17))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelGlass4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nama_sopir, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel36))
                .addGroup(panelGlass4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGlass4Layout.createSequentialGroup()
                        .addGroup(panelGlass4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelGlass4Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(panelGlass4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel30)
                                    .addComponent(jLabel31)))
                            .addGroup(panelGlass4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelGlass4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(telp_sopir, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelGlass4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel33)
                                .addComponent(jLabel32)))
                        .addGap(18, 18, 18)
                        .addGroup(panelGlass4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(no_sim, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelGlass4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel38)
                                .addComponent(jLabel37)))
                        .addGroup(panelGlass4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelGlass4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tarif_sopir, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelGlass4Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(panelGlass4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel39)
                                    .addComponent(jLabel40)))))
                    .addGroup(panelGlass4Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel34)))
                .addContainerGap())
        );

        getContentPane().add(panelGlass4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 660, 390));

        buttonGlass1.setForeground(new java.awt.Color(238, 243, 254));
        buttonGlass1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/arrow_left.png"))); // NOI18N
        buttonGlass1.setText("Kembali");
        buttonGlass1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGlass1ActionPerformed(evt);
            }
        });
        getContentPane().add(buttonGlass1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 110, -1));

        btn_create_sopir.setForeground(new java.awt.Color(255, 255, 255));
        btn_create_sopir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/plus.png"))); // NOI18N
        btn_create_sopir.setText("Tambah");
        btn_create_sopir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_create_sopirActionPerformed(evt);
            }
        });
        getContentPane().add(btn_create_sopir, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 460, 190, -1));

        jLabel35.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("Tambah Data Sopir");
        getContentPane().add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, -1, -1));

        btn_Delete__hapus.setForeground(new java.awt.Color(255, 255, 255));
        btn_Delete__hapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/trash_box.png"))); // NOI18N
        btn_Delete__hapus.setText("Hapus");
        btn_Delete__hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Delete__hapusActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Delete__hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 460, 190, -1));

        btn_Edit_sopir.setForeground(new java.awt.Color(255, 255, 255));
        btn_Edit_sopir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/pencil_edit.png"))); // NOI18N
        btn_Edit_sopir.setText("Ubah");
        btn_Edit_sopir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Edit_sopirActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Edit_sopir, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 460, 190, -1));

        tabel_sopir.setModel(new javax.swing.table.DefaultTableModel(
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
        tabel_sopir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_sopirMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel_sopir);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 580, 450, 90));

        btn_Search_sopir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/search_lense.png"))); // NOI18N
        btn_Search_sopir.setRoundRect(true);
        btn_Search_sopir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Search_sopirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelGlass6Layout = new javax.swing.GroupLayout(panelGlass6);
        panelGlass6.setLayout(panelGlass6Layout);
        panelGlass6Layout.setHorizontalGroup(
            panelGlass6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGlass6Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(txt_search_sopir, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Search_sopir, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelGlass6Layout.setVerticalGroup(
            panelGlass6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGlass6Layout.createSequentialGroup()
                .addGroup(panelGlass6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGlass6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txt_search_sopir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_Search_sopir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(panelGlass6, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 520, 550, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/backOk.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -50, 860, 780));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nama_sopirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nama_sopirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nama_sopirActionPerformed

    private void telp_sopirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telp_sopirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telp_sopirActionPerformed

    private void buttonGlass1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGlass1ActionPerformed
        // TODO add your handling code here:
        new Home().show();
        super.dispose();
    }//GEN-LAST:event_buttonGlass1ActionPerformed

    private void btn_create_sopirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_create_sopirActionPerformed
        tambah();
    }//GEN-LAST:event_btn_create_sopirActionPerformed

    private void btn_Edit_sopirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Edit_sopirActionPerformed
        ubah();
    }//GEN-LAST:event_btn_Edit_sopirActionPerformed

    private void btn_Delete__hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Delete__hapusActionPerformed
        hapus();
    }//GEN-LAST:event_btn_Delete__hapusActionPerformed

    private void btn_Search_sopirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Search_sopirActionPerformed
        cari();
    }//GEN-LAST:event_btn_Search_sopirActionPerformed

    private void id_sopirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_sopirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_id_sopirActionPerformed

    private void no_simActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_no_simActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_no_simActionPerformed

    private void tarif_sopirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tarif_sopirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tarif_sopirActionPerformed

    private void tabel_sopirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_sopirMouseClicked
        // TODO add your handling code here:
        int baris = tabel_sopir.getSelectedRow();
        if (evt.getClickCount() > 0) {
            try {
                Koneksi objkoneksi = new Koneksi();
                Connection con = objkoneksi.bukakoneksi();
                Statement st = con.createStatement();
                String sql = "select *from data_sopir where id_sopir='" + tabel_sopir.getValueAt(baris, 0).toString() + "'";
                ResultSet rs = st.executeQuery(sql);
                rs.last();
                id_sopir.setText(rs.getString("id_sopir"));
                nama_sopir.setText(rs.getString("nama_sopir"));
                alamat_sopir.setText(rs.getString("alamat_sopir"));
                telp_sopir.setText(rs.getString("telp_sopir"));
                no_sim.setText(rs.getString("no_sim"));
                tarif_sopir.setText(rs.getString("tarif_sopir"));
            } catch (SQLException e) {
                System.out.println("gagal mengambil data dari tabel" + e);
            }
        }
    }//GEN-LAST:event_tabel_sopirMouseClicked

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
            java.util.logging.Logger.getLogger(sopir_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(sopir_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(sopir_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(sopir_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new sopir_form().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea alamat_sopir;
    private usu.widget.ButtonGlass btn_Delete__hapus;
    private usu.widget.ButtonGlass btn_Edit_sopir;
    private usu.widget.ButtonGlass btn_Search_sopir;
    private usu.widget.ButtonGlass btn_create_sopir;
    private usu.widget.ButtonGlass buttonGlass1;
    private javax.swing.JTextField id_sopir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField nama_sopir;
    private javax.swing.JTextField no_sim;
    private usu.widget.glass.PanelGlass panelGlass4;
    private usu.widget.glass.PanelGlass panelGlass6;
    private javax.swing.JTable tabel_sopir;
    private javax.swing.JTextField tarif_sopir;
    private javax.swing.JTextField telp_sopir;
    private javax.swing.JTextField txt_search_sopir;
    // End of variables declaration//GEN-END:variables
}
