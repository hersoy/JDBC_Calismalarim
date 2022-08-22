package querys;

import java.sql.*;

public class Query01 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 1- Driver yukle
        Class.forName("com.mysql.jdbc.Driver");

        // 2- Baglanti olustur
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/okul?serverTimezone=UTC", "root", "0715");

        // 3- Statement: SQL kodlarimizi yazmak icin bir nesne olusturacagiz
        Statement st = con.createStatement();

        // 4- ResultSet:
        ResultSet veri = st.executeQuery("select * from ogrenciler");

        // 5- Sonuclari al
        while (veri.next()) {
            // İNDEX kullanarak:
            //    System.out.println(veri.getInt(1)+veri.getString(2)
            //            +veri.getString(3)+veri.getString(4));

            // SUTUN ISMI kullanarak:
            //    System.out.println(veri.getInt("okul_no")+veri.getString("ogrenci_ismi")
            //            +veri.getString("sinif")+veri.getString("cinsiyet"));

            // PRINT-F kullanarak:
            System.out.printf("%-6d %-15.15s %-8s %-8s\n", veri.getInt(1),
                    veri.getString(2), veri.getString(3), veri.getString(4));

                 }
        // 6- Kapatma:
        con.close();
        st.close();
        veri.close();
    }
}
