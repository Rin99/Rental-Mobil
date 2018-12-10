/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

/**
 *
 * @author USER
 */
import java.sql.*;

public class Koneksi {

    public Koneksi() {
    }

    public Connection bukakoneksi() throws SQLException {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/rental_mobil", "root", "");
            return con;
        } catch (SQLException se) {
            System.out.println("No Connection Open");
            return null;
        } catch (Exception ex) {
            System.out.println("Couldn't open connection" + ex);
            return null;
        }
    }
}
