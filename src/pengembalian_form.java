
import Connection.Koneksi;
import Connection.ResultSetTableModel;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class pengembalian_form extends javax.swing.JFrame {

    public pengembalian_form() {
        initComponents();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = getSize();
        setLocation(
                (screenSize.width - frameSize.width) / 2,
                (screenSize.height - frameSize.height) / 2);
        Fillcombotrans();
        tampiltabel();
    }
    public Date a;

    void tampiltabel() {
        try {
            Koneksi objkoneksi = new Koneksi();
            Connection con = objkoneksi.bukakoneksi();
            Statement st = con.createStatement();
            String sql = "select *from transaksi";
            ResultSet set = st.executeQuery(sql);
            ResultSetTableModel model = new ResultSetTableModel(set);
            tabel.setModel(model);
        } catch (SQLException e) {
            System.out.println("gagal query ini" + e);
        }
    }

    private void Fillcombotrans() {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/rental_mobil", "root", "");
            st = con.createStatement();
            String sql = "select NoTransaksi from transaksi";
            rs = st.executeQuery(sql);

            while (rs.next()) {
                kode_trans.addItem(rs.getString("NoTransaksi"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                st.close();
                rs.close();
                con.close();

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "ERROR CLOSE");
            }
        }
    }

    private void Filldatamobil() {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/rental_mobil", "root", "");
            st = con.createStatement();
            String sql = "select * from data_mobil where nopol_mobil = '" + nopol_mobil.getText() + "'";
            rs = st.executeQuery(sql);

            while (rs.next()) {
                merk_mobil.setText(rs.getString("merk_mobil"));
                tipe_mobil.setText(rs.getString("tipe_mobil"));
                tahun_mobil.setText(rs.getString("tahun_mobil"));
                sewa_mobil.setText(rs.getString("sewa_mobil"));
                status_mobil.setText(rs.getString("status_mobil"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                st.close();
                rs.close();
                con.close();

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "ERROR CLOSE");
            }
        }
    }

    private void Filldatasopir() {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/rental_mobil", "root", "");
            st = con.createStatement();
            String sql = "select * from data_sopir where id_sopir = '" + id_sopir.getText() + "'";
            rs = st.executeQuery(sql);

            while (rs.next()) {
                nama_sopir.setText(rs.getString("nama_sopir"));
                tarif_sopir.setText(rs.getString("tarif_sopir"));
                alamat_sopir.setText(rs.getString("alamat_sopir"));
                telp_sopir.setText(rs.getString("telp_sopir"));
                sim_sopir.setText(rs.getString("no_sim"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                st.close();
                rs.close();
                con.close();

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "ERROR CLOSE");
            }
        }
    }

    private void Filldatapelanggan() {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/rental_mobil", "root", "");
            st = con.createStatement();
            String sql = "select * from data_pelanggan where NoTransaksi = '" + kode_trans.getSelectedItem() + "'";
            rs = st.executeQuery(sql);

            while (rs.next()) {
                lblNama.setText(rs.getString("nama_pelanggan"));
                lbl_alamat.setText(rs.getString("alamat_pelanggan"));
                lbl_tlp.setText(rs.getString("telp_pelanggan"));
                lbl_ktp.setText(rs.getString("ktp_pelanggan"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                st.close();
                rs.close();
                con.close();

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "ERROR CLOSE");
            }
        }
    }

    private void Filldatatrans() {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/rental_mobil", "root", "");
            st = con.createStatement();
            String sql = "select * from transaksi where NoTransaksi = '" + kode_trans.getSelectedItem() + "'";
            rs = st.executeQuery(sql);

            while (rs.next()) {
                nopol_mobil.setText(rs.getString("nopol_mobil"));
                lbl_total.setText(rs.getString("total_biaya"));
                tanggal_pesan.setText(rs.getString("tgl_pesan"));
                tanggal_pinjam.setText(rs.getString("tgl_pinjam"));
                jam_pinjam.setText(rs.getString("jam_pinjam"));
                rencanatgl_kembali.setText(rs.getString("tgl_kembali_rencana"));
                a = rs.getDate("tgl_kembali_rencana");
                rencanajam_kembali.setText(rs.getString("jam_kembali_rencana"));
                kondisi_pinjam.setText(rs.getString("kondisi_pinjam"));
                kilometer_pinjam.setText(rs.getString("kilometer_pinjam"));
                bbm_pinjam.setText(rs.getString("bbm_pinjam"));
                id_sopir.setText(rs.getString("id_sopir"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                st.close();
                rs.close();
                con.close();

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "ERROR CLOSE");
            }
        }
    }

    void add() {
        if (realtgl_kembali.getDate().equals(null) || realjam_kembali.getFormatedTime().toString().equals("00:00:00") || kondisi_kembali.getText().isEmpty() || kilometer_kembali.getText().isEmpty() || bbm_kembali.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Lengkapi data yang anda masukkan terlebih dahulu!");
        } else {
            try {
                Koneksi objkoneksi = new Koneksi();
                Connection con = objkoneksi.bukakoneksi();
                Statement st = con.createStatement();
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                String sql = "update transaksi set tgl_kembali_real = '" + String.valueOf(format.format(realtgl_kembali.getDate())) + "',"
                        + "jam_kembali_real = '" + realjam_kembali.getFormatedTime() + "',"
                        + "kondisi_kembali = '" + kondisi_kembali.getText() + "',"
                        + "kilometer_kembali = '" + kilometer_kembali.getText() + "',"
                        + "bbm_kembali = '" + bbm_kembali.getText() + "',"
                        + "total_biaya = '" + total_biaya.getText() + "',"
                        + "denda_transaksi = '" + denda.getText() + "',"
                        + "where NoTransaksi ='" + kode_trans.getSelectedItem() + "'";
                int row = st.executeUpdate(sql);
                if (row == 1) {
                    JOptionPane.showMessageDialog(null, "Data sudah diupdate", "informasi", JOptionPane.INFORMATION_MESSAGE);
                    con.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "data tidak diubah"
                        + e, "informasi", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    void update() {
        try {
            Koneksi objkoneksi = new Koneksi();
            Connection con = objkoneksi.bukakoneksi();
            Statement st = con.createStatement();
            String sql = "update data_mobil set status_mobil = 'Tersedia'"
                    + "where nopol_mobil ='" + nopol_mobil.getText() + "'";
            int row = st.executeUpdate(sql);
            if (row == 1) {
                con.close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "data tidak diubah"
                    + e, "informasi", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        panelGlass1 = new usu.widget.glass.PanelGlass();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        lblNama = new javax.swing.JLabel();
        lbl_alamat = new javax.swing.JLabel();
        lbl_tlp = new javax.swing.JLabel();
        lbl_ktp = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        kode_trans = new javax.swing.JComboBox();
        panelGlass3 = new usu.widget.glass.PanelGlass();
        jLabel21 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        denda = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        kondisi_kembali = new javax.swing.JTextArea();
        bbm_kembali = new javax.swing.JTextField();
        kilometer_kembali = new javax.swing.JTextField();
        denda1 = new javax.swing.JLabel();
        realtgl_kembali = new com.toedter.calendar.JDateChooser();
        realjam_kembali = new lu.tudor.santec.jtimechooser.JTimeChooser();
        jLabel59 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        panelGlass2 = new usu.widget.glass.PanelGlass();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        tipe_mobil = new javax.swing.JLabel();
        tahun_mobil = new javax.swing.JLabel();
        sewa_mobil = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        status_mobil = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        merk_mobil = new javax.swing.JLabel();
        nopol_mobil = new javax.swing.JLabel();
        btn_create_addItem = new usu.widget.ButtonGlass();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        panelGlass4 = new usu.widget.glass.PanelGlass();
        jLabel7 = new javax.swing.JLabel();
        lbl_total = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        hitung_total = new usu.widget.ButtonGlass();
        jLabel55 = new javax.swing.JLabel();
        total_denda = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        total_biaya = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        panelGlass5 = new usu.widget.glass.PanelGlass();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        nama_sopir = new javax.swing.JLabel();
        tarif_sopir = new javax.swing.JLabel();
        alamat_sopir = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        telp_sopir = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        sim_sopir = new javax.swing.JLabel();
        id_sopir = new javax.swing.JLabel();
        panelGlass7 = new usu.widget.glass.PanelGlass();
        bbm_pinjam = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        tanggal_pesan = new javax.swing.JLabel();
        tanggal_pinjam = new javax.swing.JLabel();
        jam_pinjam = new javax.swing.JLabel();
        rencanatgl_kembali = new javax.swing.JLabel();
        rencanajam_kembali = new javax.swing.JLabel();
        kondisi_pinjam = new javax.swing.JLabel();
        kilometer_pinjam = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        buttonGlass1 = new usu.widget.ButtonGlass();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Pengembalian Kendaraan");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 450, 40));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Data Peminjam");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nama");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Alamat");

        jLabel22.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("No. Tlp");

        jLabel23.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText(":");

        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText(":");

        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText(":");

        jLabel24.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("No. KTP");

        jLabel25.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText(":");

        lblNama.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblNama.setForeground(new java.awt.Color(255, 255, 255));
        lblNama.setText("Nama");

        lbl_alamat.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_alamat.setForeground(new java.awt.Color(255, 255, 255));
        lbl_alamat.setText("Alamat");

        lbl_tlp.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_tlp.setForeground(new java.awt.Color(255, 255, 255));
        lbl_tlp.setText("No. Tlp");

        lbl_ktp.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_ktp.setForeground(new java.awt.Color(255, 255, 255));
        lbl_ktp.setText("No. KTP");

        jLabel35.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("Kode Trans. :");

        kode_trans.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--Pilih Kode--" }));
        kode_trans.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                kode_transItemStateChanged(evt);
            }
        });
        kode_trans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kode_transActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelGlass1Layout = new javax.swing.GroupLayout(panelGlass1);
        panelGlass1.setLayout(panelGlass1Layout);
        panelGlass1Layout.setHorizontalGroup(
            panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGlass1Layout.createSequentialGroup()
                .addContainerGap(88, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(70, 70, 70))
            .addGroup(panelGlass1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGlass1Layout.createSequentialGroup()
                        .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel24)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbl_ktp, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                            .addComponent(lblNama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_tlp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_alamat, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)))
                    .addGroup(panelGlass1Layout.createSequentialGroup()
                        .addComponent(jLabel35)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(kode_trans, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelGlass1Layout.setVerticalGroup(
            panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGlass1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(12, 12, 12)
                .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel11)
                    .addComponent(lblNama))
                .addGap(12, 12, 12)
                .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel10)
                    .addComponent(lbl_alamat, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23)
                    .addComponent(lbl_tlp))
                .addGap(18, 18, 18)
                .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jLabel25)
                    .addComponent(lbl_ktp))
                .addGap(18, 18, 18)
                .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(kode_trans, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(panelGlass1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 290, 240));

        panelGlass3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Liter");
        panelGlass3.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 300, -1, -1));

        jLabel37.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("KM");
        panelGlass3.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 270, -1, -1));

        denda.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        denda.setForeground(new java.awt.Color(255, 255, 255));
        denda.setText("Denda");
        panelGlass3.add(denda, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 50, -1));

        kondisi_kembali.setColumns(20);
        kondisi_kembali.setRows(5);
        jScrollPane2.setViewportView(kondisi_kembali);

        panelGlass3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, 170, -1));
        panelGlass3.add(bbm_kembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 300, 110, -1));
        panelGlass3.add(kilometer_kembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, 110, -1));

        denda1.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        denda1.setForeground(new java.awt.Color(255, 255, 255));
        denda1.setText("Hari");
        panelGlass3.add(denda1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 50, -1));
        panelGlass3.add(realtgl_kembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, -1, -1));
        panelGlass3.add(realjam_kembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, -1, -1));

        jLabel59.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(255, 255, 255));
        jLabel59.setText(":");
        panelGlass3.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 14, -1));

        jLabel76.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(255, 255, 255));
        jLabel76.setText("Tanggal Selesai");
        panelGlass3.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jLabel78.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(255, 255, 255));
        jLabel78.setText("Jam Selesai");
        panelGlass3.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        jLabel82.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel82.setForeground(new java.awt.Color(255, 255, 255));
        jLabel82.setText(":");
        panelGlass3.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 14, -1));

        jLabel83.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel83.setForeground(new java.awt.Color(255, 255, 255));
        jLabel83.setText("Denda");
        panelGlass3.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        jLabel84.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel84.setForeground(new java.awt.Color(255, 255, 255));
        jLabel84.setText(":");
        panelGlass3.add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 14, -1));

        jLabel85.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel85.setForeground(new java.awt.Color(255, 255, 255));
        jLabel85.setText("Kondisi Kendaraan");
        panelGlass3.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        jLabel86.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel86.setForeground(new java.awt.Color(255, 255, 255));
        jLabel86.setText(":");
        panelGlass3.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 14, -1));

        jLabel87.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel87.setForeground(new java.awt.Color(255, 255, 255));
        jLabel87.setText("Kilometer Kembali");
        panelGlass3.add(jLabel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, -1, -1));

        jLabel88.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel88.setForeground(new java.awt.Color(255, 255, 255));
        jLabel88.setText(":");
        panelGlass3.add(jLabel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, 14, -1));

        jLabel89.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel89.setForeground(new java.awt.Color(255, 255, 255));
        jLabel89.setText("BBM Kembali");
        panelGlass3.add(jLabel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, -1, -1));

        jLabel90.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel90.setForeground(new java.awt.Color(255, 255, 255));
        jLabel90.setText(":");
        panelGlass3.add(jLabel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, 14, -1));

        getContentPane().add(panelGlass3, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 50, 340, 340));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("No. Plat");

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Merk Mobil");

        jLabel27.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Tipe Mobil");

        jLabel29.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Tahun Mobil");

        jLabel30.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText(":");

        jLabel31.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText(":");

        jLabel12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText(":");

        jLabel13.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText(":");

        jLabel33.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Tarif/12 Jam");

        jLabel34.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText(":");

        tipe_mobil.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        tipe_mobil.setForeground(new java.awt.Color(255, 255, 255));
        tipe_mobil.setText("tipe mobil");

        tahun_mobil.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        tahun_mobil.setForeground(new java.awt.Color(255, 255, 255));
        tahun_mobil.setText("tahun mobil");

        sewa_mobil.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        sewa_mobil.setForeground(new java.awt.Color(255, 255, 255));
        sewa_mobil.setText("Tarif Per 12 Jam");

        jLabel36.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Status");

        status_mobil.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        status_mobil.setForeground(new java.awt.Color(255, 255, 255));
        status_mobil.setText("status");

        jLabel38.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText(":");

        merk_mobil.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        merk_mobil.setForeground(new java.awt.Color(255, 255, 255));
        merk_mobil.setText("merk mobil");

        nopol_mobil.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        nopol_mobil.setForeground(new java.awt.Color(255, 255, 255));
        nopol_mobil.setText("plat mobil");

        javax.swing.GroupLayout panelGlass2Layout = new javax.swing.GroupLayout(panelGlass2);
        panelGlass2.setLayout(panelGlass2Layout);
        panelGlass2Layout.setHorizontalGroup(
            panelGlass2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGlass2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelGlass2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGlass2Layout.createSequentialGroup()
                        .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelGlass2Layout.createSequentialGroup()
                        .addGroup(panelGlass2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelGlass2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel29)
                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel9)
                            .addComponent(jLabel33))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelGlass2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelGlass2Layout.createSequentialGroup()
                                .addGroup(panelGlass2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelGlass2Layout.createSequentialGroup()
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(merk_mobil, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelGlass2Layout.createSequentialGroup()
                                        .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(status_mobil)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(panelGlass2Layout.createSequentialGroup()
                                .addGroup(panelGlass2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelGlass2Layout.createSequentialGroup()
                                        .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(sewa_mobil))
                                    .addGroup(panelGlass2Layout.createSequentialGroup()
                                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(tahun_mobil, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGlass2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(panelGlass2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGlass2Layout.createSequentialGroup()
                                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(321, 321, 321))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGlass2Layout.createSequentialGroup()
                                        .addComponent(tipe_mobil, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(194, 194, 194))
                                    .addGroup(panelGlass2Layout.createSequentialGroup()
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nopol_mobil, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(200, 200, 200))))))))
        );
        panelGlass2Layout.setVerticalGroup(
            panelGlass2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGlass2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(panelGlass2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel13)
                    .addComponent(merk_mobil))
                .addGap(19, 19, 19)
                .addGroup(panelGlass2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel12)
                    .addComponent(nopol_mobil))
                .addGap(18, 18, 18)
                .addGroup(panelGlass2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(jLabel31)
                    .addComponent(tipe_mobil))
                .addGap(18, 18, 18)
                .addGroup(panelGlass2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(jLabel30)
                    .addComponent(tahun_mobil))
                .addGap(18, 18, 18)
                .addGroup(panelGlass2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(jLabel34)
                    .addComponent(sewa_mobil))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelGlass2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(jLabel38)
                    .addComponent(status_mobil))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        getContentPane().add(panelGlass2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, 310, 240));

        btn_create_addItem.setForeground(new java.awt.Color(255, 255, 255));
        btn_create_addItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/kembali_mobil.png"))); // NOI18N
        btn_create_addItem.setText("Kembali");
        btn_create_addItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_create_addItemActionPerformed(evt);
            }
        });
        getContentPane().add(btn_create_addItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 430, 170, 60));

        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No. Trans", "No. KTP", "No. Plat", "ID Sopir", "Pinjam", "Kembali", "Selesai", "Biaya", "Total"
            }
        ));
        jScrollPane1.setViewportView(tabel);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 540, 1290, 170));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Total :");

        lbl_total.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbl_total.setForeground(new java.awt.Color(255, 255, 255));
        lbl_total.setText("total");

        jLabel28.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Rp.");

        hitung_total.setForeground(new java.awt.Color(255, 255, 255));
        hitung_total.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/calculator.png"))); // NOI18N
        hitung_total.setText("Hitung");
        hitung_total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hitung_totalActionPerformed(evt);
            }
        });

        jLabel55.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setText("Rp.");

        total_denda.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        total_denda.setForeground(new java.awt.Color(255, 255, 255));
        total_denda.setText("total");

        jLabel14.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Denda :");

        jLabel15.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Total Biaya:");

        total_biaya.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        total_biaya.setForeground(new java.awt.Color(255, 255, 255));
        total_biaya.setText("total");

        jLabel56.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(255, 255, 255));
        jLabel56.setText("Rp.");

        javax.swing.GroupLayout panelGlass4Layout = new javax.swing.GroupLayout(panelGlass4);
        panelGlass4.setLayout(panelGlass4Layout);
        panelGlass4Layout.setHorizontalGroup(
            panelGlass4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGlass4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(panelGlass4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGlass4Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelGlass4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelGlass4Layout.createSequentialGroup()
                                .addComponent(jLabel28)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbl_total, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(hitung_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelGlass4Layout.createSequentialGroup()
                        .addGroup(panelGlass4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panelGlass4Layout.createSequentialGroup()
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel55)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelGlass4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(total_denda, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGlass4Layout.createSequentialGroup()
                                .addComponent(jLabel56)
                                .addGap(18, 18, 18)
                                .addComponent(total_biaya, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        panelGlass4Layout.setVerticalGroup(
            panelGlass4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGlass4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panelGlass4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel28)
                    .addComponent(lbl_total))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelGlass4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel55)
                    .addComponent(total_denda))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelGlass4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel56)
                    .addComponent(total_biaya))
                .addGap(18, 18, 18)
                .addComponent(hitung_total, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(panelGlass4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 300, 310, 210));

        jLabel41.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("Id Sopir");

        jLabel42.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("Nama Sopir");

        jLabel43.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText(":");

        jLabel44.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setText(":");

        jLabel47.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("Tarif");

        jLabel48.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setText(":");

        nama_sopir.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        nama_sopir.setForeground(new java.awt.Color(255, 255, 255));
        nama_sopir.setText("Nama Sopir");

        tarif_sopir.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        tarif_sopir.setForeground(new java.awt.Color(255, 255, 255));
        tarif_sopir.setText("Tarif Per hari");

        alamat_sopir.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        alamat_sopir.setForeground(new java.awt.Color(255, 255, 255));
        alamat_sopir.setText("Alamat Sopir");

        jLabel49.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setText("Alamat Sopir");

        telp_sopir.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        telp_sopir.setForeground(new java.awt.Color(255, 255, 255));
        telp_sopir.setText("Telp. Sopir");

        jLabel50.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setText(":");

        jLabel51.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jLabel51.setText(":");

        jLabel52.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 255, 255));
        jLabel52.setText("Telp. Sopir");

        jLabel53.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setText("No. SIM");

        jLabel54.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 255, 255));
        jLabel54.setText(":");

        sim_sopir.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        sim_sopir.setForeground(new java.awt.Color(255, 255, 255));
        sim_sopir.setText("Sim");

        id_sopir.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        id_sopir.setForeground(new java.awt.Color(255, 255, 255));
        id_sopir.setText("Id Sopir");

        javax.swing.GroupLayout panelGlass5Layout = new javax.swing.GroupLayout(panelGlass5);
        panelGlass5.setLayout(panelGlass5Layout);
        panelGlass5Layout.setHorizontalGroup(
            panelGlass5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGlass5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelGlass5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGlass5Layout.createSequentialGroup()
                        .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(tarif_sopir))
                    .addGroup(panelGlass5Layout.createSequentialGroup()
                        .addGroup(panelGlass5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel49)
                            .addComponent(jLabel52)
                            .addComponent(jLabel53))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelGlass5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelGlass5Layout.createSequentialGroup()
                                .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sim_sopir))
                            .addGroup(panelGlass5Layout.createSequentialGroup()
                                .addGroup(panelGlass5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelGlass5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(telp_sopir)
                                    .addComponent(alamat_sopir, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(panelGlass5Layout.createSequentialGroup()
                        .addGroup(panelGlass5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel42, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel41, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelGlass5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelGlass5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(id_sopir, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nama_sopir, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        panelGlass5Layout.setVerticalGroup(
            panelGlass5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGlass5Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(panelGlass5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(jLabel51)
                    .addComponent(id_sopir))
                .addGap(13, 13, 13)
                .addGroup(panelGlass5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(jLabel44)
                    .addComponent(nama_sopir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelGlass5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel49)
                    .addComponent(alamat_sopir)
                    .addComponent(jLabel48))
                .addGap(19, 19, 19)
                .addGroup(panelGlass5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel52)
                    .addComponent(jLabel50)
                    .addComponent(telp_sopir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelGlass5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel53)
                    .addComponent(jLabel54)
                    .addComponent(sim_sopir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelGlass5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47)
                    .addComponent(jLabel43)
                    .addComponent(tarif_sopir))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        getContentPane().add(panelGlass5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 290, 210));

        panelGlass7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bbm_pinjam.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        bbm_pinjam.setForeground(new java.awt.Color(255, 255, 255));
        bbm_pinjam.setText("bbm pinjam");
        panelGlass7.add(bbm_pinjam, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 420, -1, -1));

        jLabel73.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(255, 255, 255));
        jLabel73.setText("Liter");
        panelGlass7.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 420, -1, -1));

        jLabel75.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(255, 255, 255));
        jLabel75.setText("KM");
        panelGlass7.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 390, -1, -1));

        tanggal_pesan.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        tanggal_pesan.setForeground(new java.awt.Color(255, 255, 255));
        tanggal_pesan.setText("Tanggal Pesan");
        panelGlass7.add(tanggal_pesan, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, -1, -1));

        tanggal_pinjam.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        tanggal_pinjam.setForeground(new java.awt.Color(255, 255, 255));
        tanggal_pinjam.setText("Tanggal Pinjam");
        panelGlass7.add(tanggal_pinjam, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, -1, -1));

        jam_pinjam.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jam_pinjam.setForeground(new java.awt.Color(255, 255, 255));
        jam_pinjam.setText("Jam Pinjam");
        panelGlass7.add(jam_pinjam, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, -1, -1));

        rencanatgl_kembali.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        rencanatgl_kembali.setForeground(new java.awt.Color(255, 255, 255));
        rencanatgl_kembali.setText("Tanggal Kembali");
        panelGlass7.add(rencanatgl_kembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, -1, -1));

        rencanajam_kembali.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        rencanajam_kembali.setForeground(new java.awt.Color(255, 255, 255));
        rencanajam_kembali.setText("Jam Kembali");
        panelGlass7.add(rencanajam_kembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, -1, -1));

        kondisi_pinjam.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        kondisi_pinjam.setForeground(new java.awt.Color(255, 255, 255));
        kondisi_pinjam.setText("Kondisi Pinjam");
        panelGlass7.add(kondisi_pinjam, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, -1, 90));

        kilometer_pinjam.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        kilometer_pinjam.setForeground(new java.awt.Color(255, 255, 255));
        kilometer_pinjam.setText("kilometer");
        panelGlass7.add(kilometer_pinjam, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 390, -1, -1));

        jLabel60.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(255, 255, 255));
        jLabel60.setText("Tangal Pinjam");
        panelGlass7.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, 40));

        jLabel61.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(255, 255, 255));
        jLabel61.setText(":");
        panelGlass7.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 14, 40));

        jLabel62.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(255, 255, 255));
        jLabel62.setText("Jam Pinjam");
        panelGlass7.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, 40));

        jLabel63.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(255, 255, 255));
        jLabel63.setText(":");
        panelGlass7.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 14, 40));

        jLabel64.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(255, 255, 255));
        jLabel64.setText("Tanggal Kembali");
        panelGlass7.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, 40));

        jLabel65.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(255, 255, 255));
        jLabel65.setText(":");
        panelGlass7.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 14, 40));

        jLabel77.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(255, 255, 255));
        jLabel77.setText("Jam Kembali");
        panelGlass7.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, 40));

        jLabel79.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(255, 255, 255));
        jLabel79.setText(":");
        panelGlass7.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 14, 40));

        jLabel80.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(255, 255, 255));
        jLabel80.setText("Lama Pinjam");
        panelGlass7.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, 40));

        jLabel66.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(255, 255, 255));
        jLabel66.setText(":");
        panelGlass7.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 14, 40));

        jLabel67.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(255, 255, 255));
        jLabel67.setText("Kondisi Mobil");
        panelGlass7.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, 40));

        jLabel68.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(255, 255, 255));
        jLabel68.setText(":");
        panelGlass7.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, 14, 40));

        jLabel81.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel81.setForeground(new java.awt.Color(255, 255, 255));
        jLabel81.setText("Kilometer");
        panelGlass7.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, -1, 40));

        jLabel70.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(255, 255, 255));
        jLabel70.setText(":");
        panelGlass7.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 380, 14, 40));

        jLabel71.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(255, 255, 255));
        jLabel71.setText("Bahan Bakar");
        panelGlass7.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, -1, 40));

        jLabel72.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(255, 255, 255));
        jLabel72.setText(":");
        panelGlass7.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 410, 14, 40));

        jLabel69.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(255, 255, 255));
        jLabel69.setText("Tangal Sewa");
        panelGlass7.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel74.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(255, 255, 255));
        jLabel74.setText(":");
        panelGlass7.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 14, -1));

        getContentPane().add(panelGlass7, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 50, 320, 450));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/backOk.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, -1, -1));

        buttonGlass1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/arrow_left.png"))); // NOI18N
        buttonGlass1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGlass1ActionPerformed(evt);
            }
        });
        getContentPane().add(buttonGlass1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/backOk.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void hitung_totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hitung_totalActionPerformed
        try {
            SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
            String strDate1 = df.format(a);
            String strDate2 = df.format(realtgl_kembali.getDate());
            Date Tanggal1 = df.parse(strDate1);
            Date Tanggal2 = df.parse(strDate2);
            long Hari1 = Tanggal1.getTime();
            long Hari2 = Tanggal2.getTime();
            long diff = Hari2 - Hari1;
            long Lama = diff / (24 * 60 * 60 * 1000);
            String Hasil = (Long.toString(Lama));
            denda.setText(Hasil);

            int harga_sewa = Integer.parseInt(sewa_mobil.getText()); // lbl_harga di pars ke integer
            int lama_sewa = Integer.parseInt(denda.getText());   // txt_lama di pars ke integer
            int hrg_sopir = Integer.parseInt(tarif_sopir.getText());
            int Total = ((2 * harga_sewa * lama_sewa) + (2 * hrg_sopir * lama_sewa));                     // mencari total Harga
            String a = Integer.toString(Total);
            total_denda.setText(a);

        } catch (Exception a) {
            JOptionPane.showMessageDialog(this, "Masukan Tanggal Peminjaman dan Tanggal Pengembalian");
        }
        int totalbiaya = Integer.parseInt(total_denda.getText()) + Integer.parseInt(lbl_total.getText());
        String b = Integer.toString(totalbiaya);
        total_biaya.setText(b);
    }//GEN-LAST:event_hitung_totalActionPerformed

    private void btn_create_addItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_create_addItemActionPerformed

        add();
        update();
        tampiltabel();
    }//GEN-LAST:event_btn_create_addItemActionPerformed

    private void kode_transItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_kode_transItemStateChanged
        // TODO add your handling code here:
        Filldatatrans();
        Filldatamobil();
        Filldatapelanggan();
        Filldatasopir();
    }//GEN-LAST:event_kode_transItemStateChanged

    private void kode_transActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kode_transActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kode_transActionPerformed

    private void buttonGlass1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGlass1ActionPerformed
        // TODO add your handling code here:
        new Home().show();
        super.dispose();
    }//GEN-LAST:event_buttonGlass1ActionPerformed

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new transaksi_form().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel alamat_sopir;
    private javax.swing.JTextField bbm_kembali;
    private javax.swing.JLabel bbm_pinjam;
    private usu.widget.ButtonGlass btn_create_addItem;
    private usu.widget.ButtonGlass buttonGlass1;
    private javax.swing.JLabel denda;
    private javax.swing.JLabel denda1;
    private usu.widget.ButtonGlass hitung_total;
    private javax.swing.JLabel id_sopir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jam_pinjam;
    private javax.swing.JTextField kilometer_kembali;
    private javax.swing.JLabel kilometer_pinjam;
    private javax.swing.JComboBox kode_trans;
    private javax.swing.JTextArea kondisi_kembali;
    private javax.swing.JLabel kondisi_pinjam;
    private javax.swing.JLabel lblNama;
    private javax.swing.JLabel lbl_alamat;
    private javax.swing.JLabel lbl_ktp;
    private javax.swing.JLabel lbl_tlp;
    private javax.swing.JLabel lbl_total;
    private javax.swing.JLabel merk_mobil;
    private javax.swing.JLabel nama_sopir;
    private javax.swing.JLabel nopol_mobil;
    private usu.widget.glass.PanelGlass panelGlass1;
    private usu.widget.glass.PanelGlass panelGlass2;
    private usu.widget.glass.PanelGlass panelGlass3;
    private usu.widget.glass.PanelGlass panelGlass4;
    private usu.widget.glass.PanelGlass panelGlass5;
    private usu.widget.glass.PanelGlass panelGlass7;
    private lu.tudor.santec.jtimechooser.JTimeChooser realjam_kembali;
    private com.toedter.calendar.JDateChooser realtgl_kembali;
    private javax.swing.JLabel rencanajam_kembali;
    private javax.swing.JLabel rencanatgl_kembali;
    private javax.swing.JLabel sewa_mobil;
    private javax.swing.JLabel sim_sopir;
    private javax.swing.JLabel status_mobil;
    private javax.swing.JTable tabel;
    private javax.swing.JLabel tahun_mobil;
    private javax.swing.JLabel tanggal_pesan;
    private javax.swing.JLabel tanggal_pinjam;
    private javax.swing.JLabel tarif_sopir;
    private javax.swing.JLabel telp_sopir;
    private javax.swing.JLabel tipe_mobil;
    private javax.swing.JLabel total_biaya;
    private javax.swing.JLabel total_denda;
    // End of variables declaration//GEN-END:variables
}
