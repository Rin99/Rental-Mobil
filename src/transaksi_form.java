
import Connection.Koneksi;
import Connection.ResultSetTableModel;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Stack;
import javax.swing.JOptionPane;

public class transaksi_form extends javax.swing.JFrame {

    public transaksi_form() {
        initComponents();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = getSize();
        setLocation(
                (screenSize.width - frameSize.width) / 2,
                (screenSize.height - frameSize.height) / 2);
        Fillcombomerk();
        Fillcombosopir();
        tampiltabel();
    }

    void tampiltabel() {
        try {
            Koneksi objkoneksi = new Koneksi();
            Connection con = objkoneksi.bukakoneksi();
            Statement st = con.createStatement();
            String sql = "select NoTransaksi, NoKTP, NoPlat, IDSopir, TglPinjam, TglKembaliRencana  from transaksi";
            ResultSet set = st.executeQuery(sql);
            ResultSetTableModel model = new ResultSetTableModel(set);
            tabel.setModel(model);
        } catch (SQLException e) {
//            System.out.println("gagal query ini" + e);
        }
    }

    private void Fillcombomerk() {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/rental_mobil", "root", "");
            st = con.createStatement();
            String sql = "select distinct merk_mobil from data_mobil";
            rs = st.executeQuery(sql);

            while (rs.next()) {
                merk_mobil.addItem(rs.getString("merk_mobil"));
            }
        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e);
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

    private void Fillcombosopir() {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/rental_mobil", "root", "");
            st = con.createStatement();
            String sql = "select id_sopir from data_sopir";
            rs = st.executeQuery(sql);

            while (rs.next()) {
                id_sopir.addItem(rs.getString("id_sopir"));
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

    private void Fillnopol() {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/rental_mobil", "root", "");
            st = con.createStatement();
            String sql = "select nopol_mobil from data_mobil where merk_mobil = '" + merk_mobil.getSelectedItem() + "'";
            rs = st.executeQuery(sql);
            nopol_mobil.removeAllItems();
            nopol_mobil.addItem("--Pilih Nopol--");
            while (rs.next()) {
                nopol_mobil.addItem(rs.getString("nopol_mobil"));
            }
        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e);
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
            String sql = "select * from data_mobil where nopol_mobil = '" + nopol_mobil.getSelectedItem() + "'";
            rs = st.executeQuery(sql);

            while (rs.next()) {
                tipe_mobil.setText(rs.getString("tipe_mobil"));
                tahun_mobil.setText(rs.getString("tahun_mobil"));
                sewa_mobil.setText(rs.getString("sewa_mobil"));
                status_mobil.setText(rs.getString("status_mobil"));
            }
        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e);
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
            String sql = "select * from data_sopir where id_sopir = '" + id_sopir.getSelectedItem() + "'";
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

    public void getPeminjam(String kode, String nama, String alamat, String notel, String ktp) {
        lbl_kode.setText(kode);
        lblNama.setText(nama);
        lbl_alamat.setText(alamat);
        lbl_tlp.setText(notel);
        lbl_ktp.setText(ktp);
    }

    void add() {
//        if (nopol_mobil.getSelectedItem().equals("--Pilih Nopol--") || tanggal_pesan.getDate().equals(null) || tanggal_pinjam.getDate().equals(null) || jam_pinjam.getFormatedTime().toString().equals("00:00:00") || rencanatgl_kembali.getDate().equals(null) || jam_kembali.getFormatedTime().toString().equals("00:00:00") || lama.getText().equals("Lama Pinjam") || kondisi_pinjam.getText().equals("") || kilometer_pinjam.getText().equals("") || BBM_pinjam.getText().equals("")) {
//            JOptionPane.showMessageDialog(this, "Lengkapi data yang anda masukkan terlebih dahulu!");
//        } else {
            try {
                Koneksi objkoneksi = new Koneksi();
                Connection con = objkoneksi.bukakoneksi();
                Statement st = con.createStatement();
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                String sql = "INSERT INTO transaksi (NoTransaksi, NoKTP, NoPlat, TglPesan, TglPinjam, JamPinjam, TglKembaliRencana, JamKembaliRencana, BiayaPinjam, KilometerPinjam, BBMPinjam, KondisiMobilPinjam, IDSopir, BiayaSopir) values ('"
                        + lbl_kode.getText() + "','"
                        + lbl_ktp.getText() + "','"
                        + nopol_mobil.getSelectedItem() + "','"
                        + String.valueOf(format.format(tanggal_pesan.getDate())) + "','"
                        + String.valueOf(format.format(tanggal_pinjam.getDate())) + "','"
                        + jam_pinjam.getFormatedTime() + "','"
                        + String.valueOf(format.format(rencanatgl_kembali.getDate())) + "','"
                        + jam_kembali.getFormatedTime() + "','"
                        + lbl_total.getText() + "','"
                        + kilometer_pinjam.getText() + "','"
                        + BBM_pinjam.getText() + "','"
                        + kondisi_pinjam.getText() + "','"
                        + id_sopir.getSelectedItem() + "','"
                        + tarif_sopir.getText() + "')";
                int row = st.executeUpdate(sql);
                if (row == 1) {
                    JOptionPane.showMessageDialog(null, "Data Transaksi Sudah Disimpan", "informasi", JOptionPane.INFORMATION_MESSAGE);
                    con.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Data Transaksi Gagal Disimpan" + e, "informasi", JOptionPane.INFORMATION_MESSAGE);
            }
            tampiltabel();
//        }
    }

    void update() {
        try {
            Koneksi objkoneksi = new Koneksi();
            Connection con = objkoneksi.bukakoneksi();
            Statement st = con.createStatement();
            String sql = "update data_mobil set status_mobil = 'Keluar'"
                    + "where nopol_mobil ='" + nopol_mobil.getSelectedItem() + "'";
            int row = st.executeUpdate(sql);
            if (row == 1) {
                con.close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "data tidak diubah"
                    + e, "informasi", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    void hitung() {
        try {
            SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
            String strDate1 = df.format(tanggal_pinjam.getDate());
            String strDate2 = df.format(rencanatgl_kembali.getDate());
            Date Tanggal1 = df.parse(strDate1);
            Date Tanggal2 = df.parse(strDate2);
            long Hari1 = Tanggal1.getTime();
            long Hari2 = Tanggal2.getTime();
            long diff = Hari2 - Hari1;
            long Lama = diff / (24 * 60 * 60 * 1000);
            String Hasil = (Long.toString(Lama));
            lama.setText(Hasil);

            int harga_sewa = Integer.parseInt(sewa_mobil.getText()); // lbl_harga di pars ke integer
            int lama_sewa = Integer.parseInt(lama.getText());   // txt_lama di pars ke integer
            int hrg_sopir = Integer.parseInt(tarif_sopir.getText());
            int Total = (harga_sewa * lama_sewa * 2) + (hrg_sopir * lama_sewa * 2);                     // mencari total Harga
            String a = Integer.toString(Total);
            lbl_total.setText(a);
        } catch (ParseException a) {
//            JOptionPane.showMessageDialog(this, "Masukan Tanggal Peminjaman dan Tanggal Pengembalian");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        lbl_kode = new javax.swing.JLabel();
        panelGlass3 = new usu.widget.glass.PanelGlass();
        lama = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        kondisi_pinjam = new javax.swing.JTextArea();
        BBM_pinjam = new javax.swing.JTextField();
        kilometer_pinjam = new javax.swing.JTextField();
        lama1 = new javax.swing.JLabel();
        tanggal_pesan = new com.toedter.calendar.JDateChooser();
        tanggal_pinjam = new com.toedter.calendar.JDateChooser();
        rencanatgl_kembali = new com.toedter.calendar.JDateChooser();
        jam_pinjam = new lu.tudor.santec.jtimechooser.JTimeChooser();
        jam_kembali = new lu.tudor.santec.jtimechooser.JTimeChooser();
        jLabel40 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        panelGlass2 = new usu.widget.glass.PanelGlass();
        merk_mobil = new javax.swing.JComboBox();
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
        nopol_mobil = new javax.swing.JComboBox();
        btn_create_addItem = new usu.widget.ButtonGlass();
        panelGlass4 = new usu.widget.glass.PanelGlass();
        jLabel7 = new javax.swing.JLabel();
        lbl_total = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        hitung_total = new usu.widget.ButtonGlass();
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
        id_sopir = new javax.swing.JComboBox();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        sim_sopir = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        buttonGlass1 = new usu.widget.ButtonGlass();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        lbl_kode.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbl_kode.setForeground(new java.awt.Color(255, 255, 255));
        lbl_kode.setText("Kode Trans");

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
                .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
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
                        .addComponent(lbl_kode, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                    .addComponent(lbl_kode))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        getContentPane().add(panelGlass1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 290, 240));

        panelGlass3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lama.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lama.setForeground(new java.awt.Color(255, 255, 255));
        lama.setText("lama pinjam");
        panelGlass3.add(lama, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 240, -1, -1));

        jLabel20.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        panelGlass3.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, -1, -1));

        kondisi_pinjam.setColumns(20);
        kondisi_pinjam.setRows(5);
        jScrollPane2.setViewportView(kondisi_pinjam);

        panelGlass3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, 210, -1));
        panelGlass3.add(BBM_pinjam, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 420, 100, -1));
        panelGlass3.add(kilometer_pinjam, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 390, 100, -1));

        lama1.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        lama1.setForeground(new java.awt.Color(255, 255, 255));
        lama1.setText("Hari");
        panelGlass3.add(lama1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 240, -1, -1));
        panelGlass3.add(tanggal_pesan, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, -1, -1));
        panelGlass3.add(tanggal_pinjam, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, -1, -1));
        panelGlass3.add(rencanatgl_kembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, -1, -1));
        panelGlass3.add(jam_pinjam, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, -1, -1));
        panelGlass3.add(jam_kembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, -1, -1));

        jLabel40.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("Tangal Sewa");
        panelGlass3.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel46.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setText(":");
        panelGlass3.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 14, -1));

        jLabel55.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setText("Tangal Sewa");
        panelGlass3.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel56.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(255, 255, 255));
        jLabel56.setText(":");
        panelGlass3.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 14, -1));

        jLabel57.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(255, 255, 255));
        jLabel57.setText("Tangal Pinjam");
        panelGlass3.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, 40));

        jLabel58.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(255, 255, 255));
        jLabel58.setText(":");
        panelGlass3.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 14, 40));

        jLabel59.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(255, 255, 255));
        jLabel59.setText("Jam Pinjam");
        panelGlass3.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, 40));

        jLabel60.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(255, 255, 255));
        jLabel60.setText(":");
        panelGlass3.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 14, 40));

        jLabel61.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(255, 255, 255));
        jLabel61.setText("Tanggal Kembali");
        panelGlass3.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, 40));

        jLabel62.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(255, 255, 255));
        jLabel62.setText(":");
        panelGlass3.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 14, 40));

        jLabel63.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(255, 255, 255));
        jLabel63.setText("Jam Kembali");
        panelGlass3.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, 40));

        jLabel64.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(255, 255, 255));
        jLabel64.setText(":");
        panelGlass3.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 14, 40));

        jLabel65.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(255, 255, 255));
        jLabel65.setText("Lama Pinjam");
        panelGlass3.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, 40));

        jLabel66.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(255, 255, 255));
        jLabel66.setText(":");
        panelGlass3.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 14, 40));

        jLabel67.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(255, 255, 255));
        jLabel67.setText("Kondisi Mobil");
        panelGlass3.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, 40));

        jLabel68.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(255, 255, 255));
        jLabel68.setText(":");
        panelGlass3.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, 14, 40));

        jLabel69.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(255, 255, 255));
        jLabel69.setText("Liter");
        panelGlass3.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 410, -1, 40));

        jLabel70.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(255, 255, 255));
        jLabel70.setText(":");
        panelGlass3.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 380, 14, 40));

        jLabel71.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(255, 255, 255));
        jLabel71.setText("Bahan Bakar");
        panelGlass3.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, -1, 40));

        jLabel72.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(255, 255, 255));
        jLabel72.setText(":");
        panelGlass3.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 410, 14, 40));

        jLabel73.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(255, 255, 255));
        jLabel73.setText("Kilometer");
        panelGlass3.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, -1, 40));

        jLabel74.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(255, 255, 255));
        jLabel74.setText("Kilometer");
        panelGlass3.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 380, -1, 40));

        getContentPane().add(panelGlass3, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 50, 390, 460));

        merk_mobil.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--Pilih Merk--" }));
        merk_mobil.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                merk_mobilItemStateChanged(evt);
            }
        });
        merk_mobil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                merk_mobilActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("No. Plat");

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Merk Kendaraan");

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
        jLabel33.setText("Tarif");

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
        sewa_mobil.setText("Harga Per 1 Hari");

        jLabel36.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Status");

        status_mobil.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        status_mobil.setForeground(new java.awt.Color(255, 255, 255));
        status_mobil.setText("status");

        jLabel38.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText(":");

        nopol_mobil.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--Pilih Nopol--" }));
        nopol_mobil.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                nopol_mobilItemStateChanged(evt);
            }
        });
        nopol_mobil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nopol_mobilActionPerformed(evt);
            }
        });

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
                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel9)
                            .addComponent(jLabel33)
                            .addComponent(jLabel29))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelGlass2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelGlass2Layout.createSequentialGroup()
                                .addGroup(panelGlass2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelGlass2Layout.createSequentialGroup()
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(merk_mobil, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                        .addGroup(panelGlass2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(panelGlass2Layout.createSequentialGroup()
                                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(nopol_mobil, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(186, 186, 186))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGlass2Layout.createSequentialGroup()
                                        .addComponent(tipe_mobil, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(194, 194, 194))))))))
        );
        panelGlass2Layout.setVerticalGroup(
            panelGlass2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGlass2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(panelGlass2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel13)
                    .addComponent(merk_mobil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(panelGlass2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel12)
                    .addComponent(nopol_mobil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(panelGlass2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(jLabel31)
                    .addComponent(tipe_mobil))
                .addGap(18, 18, 18)
                .addGroup(panelGlass2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(tahun_mobil)
                    .addComponent(jLabel29))
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
                .addContainerGap(39, Short.MAX_VALUE))
        );

        getContentPane().add(panelGlass2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, 310, -1));

        btn_create_addItem.setForeground(new java.awt.Color(255, 255, 255));
        btn_create_addItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/pinjam.png"))); // NOI18N
        btn_create_addItem.setText("Kirim");
        btn_create_addItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_create_addItemActionPerformed(evt);
            }
        });
        getContentPane().add(btn_create_addItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 440, 250, 80));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Total :");

        lbl_total.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbl_total.setForeground(new java.awt.Color(255, 255, 255));
        lbl_total.setText("total");

        jLabel28.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
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

        javax.swing.GroupLayout panelGlass4Layout = new javax.swing.GroupLayout(panelGlass4);
        panelGlass4.setLayout(panelGlass4Layout);
        panelGlass4Layout.setHorizontalGroup(
            panelGlass4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGlass4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelGlass4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hitung_total, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelGlass4Layout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbl_total, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        panelGlass4Layout.setVerticalGroup(
            panelGlass4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGlass4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panelGlass4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel28)
                    .addComponent(lbl_total))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(hitung_total, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(panelGlass4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 320, 290, 110));

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
        tarif_sopir.setText("Tarif/Jam");

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

        id_sopir.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--Pilih Sopir--" }));
        id_sopir.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                id_sopirItemStateChanged(evt);
            }
        });
        id_sopir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_sopirActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout panelGlass5Layout = new javax.swing.GroupLayout(panelGlass5);
        panelGlass5.setLayout(panelGlass5Layout);
        panelGlass5Layout.setHorizontalGroup(
            panelGlass5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGlass5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(id_sopir, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
            .addGroup(panelGlass5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelGlass5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGlass5Layout.createSequentialGroup()
                        .addGroup(panelGlass5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelGlass5Layout.createSequentialGroup()
                                .addGroup(panelGlass5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel42, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel41, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panelGlass5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelGlass5Layout.createSequentialGroup()
                                .addComponent(jLabel49)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(panelGlass5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelGlass5Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(nama_sopir, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelGlass5Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(alamat_sopir, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelGlass5Layout.createSequentialGroup()
                        .addGroup(panelGlass5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelGlass5Layout.createSequentialGroup()
                                .addGroup(panelGlass5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel52)
                                    .addComponent(jLabel53))
                                .addGap(24, 24, 24))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGlass5Layout.createSequentialGroup()
                                .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(panelGlass5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelGlass5Layout.createSequentialGroup()
                                .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sim_sopir))
                            .addGroup(panelGlass5Layout.createSequentialGroup()
                                .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelGlass5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tarif_sopir)
                                    .addComponent(telp_sopir))))))
                .addGap(0, 66, Short.MAX_VALUE))
        );
        panelGlass5Layout.setVerticalGroup(
            panelGlass5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGlass5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(panelGlass5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(id_sopir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41)
                    .addComponent(jLabel51))
                .addGap(9, 9, 9)
                .addGroup(panelGlass5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(jLabel44)
                    .addComponent(nama_sopir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelGlass5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(alamat_sopir)
                    .addComponent(jLabel49))
                .addGroup(panelGlass5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelGlass5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelGlass5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel48)
                            .addComponent(jLabel52)
                            .addComponent(telp_sopir))
                        .addGap(15, 15, 15)
                        .addGroup(panelGlass5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel50)
                            .addComponent(jLabel53))
                        .addGap(16, 16, 16)
                        .addGroup(panelGlass5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel54)
                            .addComponent(jLabel47))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelGlass5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(sim_sopir)
                        .addGap(17, 17, 17)
                        .addComponent(tarif_sopir)))
                .addGap(23, 23, 23))
        );

        getContentPane().add(panelGlass5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 290, 210));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Transaksi Kendaraan");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 450, 40));

        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "No. Trans", "No. KTP", "No. Plat", "ID Sopir", "Pinjam", "Kembali", "Biaya"
            }
        ));
        jScrollPane1.setViewportView(tabel);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 540, 980, 100));

        buttonGlass1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/arrow_left.png"))); // NOI18N
        buttonGlass1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGlass1ActionPerformed(evt);
            }
        });
        getContentPane().add(buttonGlass1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/backOk.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 0, 570, 680));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/backOk.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 680));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void hitung_totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hitung_totalActionPerformed
        hitung();
    }//GEN-LAST:event_hitung_totalActionPerformed

    private void merk_mobilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_merk_mobilActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_merk_mobilActionPerformed

    private void btn_create_addItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_create_addItemActionPerformed
        add();
        update();
    }//GEN-LAST:event_btn_create_addItemActionPerformed

    private void nopol_mobilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nopol_mobilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nopol_mobilActionPerformed

    private void id_sopirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_sopirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_id_sopirActionPerformed

    private void merk_mobilItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_merk_mobilItemStateChanged
        // TODO add your handling code here:
        if (merk_mobil.getSelectedItem().equals("--Pilih Merk--")) {

        } else {

            Fillnopol();
        }
    }//GEN-LAST:event_merk_mobilItemStateChanged

    private void nopol_mobilItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_nopol_mobilItemStateChanged
        // TODO add your handling code here:
        if (nopol_mobil.getSelectedItem().equals("--Pilih Nopol--")) {
        } else {
            Filldatamobil();
        }
    }//GEN-LAST:event_nopol_mobilItemStateChanged

    private void id_sopirItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_id_sopirItemStateChanged
        // TODO add your handling code here:
        if (id_sopir.getSelectedItem().equals("--Pilih Sopir--")) {
        } else {
            Filldatasopir();
        }
    }//GEN-LAST:event_id_sopirItemStateChanged

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
    private javax.swing.JTextField BBM_pinjam;
    private javax.swing.JLabel alamat_sopir;
    private usu.widget.ButtonGlass btn_create_addItem;
    private usu.widget.ButtonGlass buttonGlass1;
    private usu.widget.ButtonGlass hitung_total;
    private javax.swing.JComboBox id_sopir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
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
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel46;
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
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
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
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private lu.tudor.santec.jtimechooser.JTimeChooser jam_kembali;
    private lu.tudor.santec.jtimechooser.JTimeChooser jam_pinjam;
    private javax.swing.JTextField kilometer_pinjam;
    private javax.swing.JTextArea kondisi_pinjam;
    private javax.swing.JLabel lama;
    private javax.swing.JLabel lama1;
    private javax.swing.JLabel lblNama;
    private javax.swing.JLabel lbl_alamat;
    private javax.swing.JLabel lbl_kode;
    private javax.swing.JLabel lbl_ktp;
    private javax.swing.JLabel lbl_tlp;
    private javax.swing.JLabel lbl_total;
    private javax.swing.JComboBox merk_mobil;
    private javax.swing.JLabel nama_sopir;
    private javax.swing.JComboBox nopol_mobil;
    private usu.widget.glass.PanelGlass panelGlass1;
    private usu.widget.glass.PanelGlass panelGlass2;
    private usu.widget.glass.PanelGlass panelGlass3;
    private usu.widget.glass.PanelGlass panelGlass4;
    private usu.widget.glass.PanelGlass panelGlass5;
    private com.toedter.calendar.JDateChooser rencanatgl_kembali;
    private javax.swing.JLabel sewa_mobil;
    private javax.swing.JLabel sim_sopir;
    private javax.swing.JLabel status_mobil;
    private javax.swing.JTable tabel;
    private javax.swing.JLabel tahun_mobil;
    private com.toedter.calendar.JDateChooser tanggal_pesan;
    private com.toedter.calendar.JDateChooser tanggal_pinjam;
    private javax.swing.JLabel tarif_sopir;
    private javax.swing.JLabel telp_sopir;
    private javax.swing.JLabel tipe_mobil;
    // End of variables declaration//GEN-END:variables
}
