package practice;

import java.sql.*;

public class P1_ReadData {

    //MySql de day3 de..

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch59?serverTimezone=UTC", "root", "0715");

        Statement st = con.createStatement();

        // SORU1: Talebeler tablosundan tum kayitları listeleyiniz.
        ResultSet kayitlar = st.executeQuery("select * from talebeler");
        while (kayitlar.next()) {
            System.out.printf("%-6d %-15.15s %-8s %-5d\n", kayitlar.getInt(1),
                    kayitlar.getString(2), kayitlar.getString(3),
                    kayitlar.getInt(4));
        }

        // SORU2: Talebeler tablosunda notları 90 uzeri olan kayitları listeleyiniz.
        ResultSet kayitlarBuyuk90 = st.executeQuery("select * from talebeler where yazili_notu>90");

        while (kayitlarBuyuk90.next()) {
            System.out.printf("%-6d %-15.15s %-8d\n", kayitlarBuyuk90.getInt(1), kayitlarBuyuk90.getString(2),
                    kayitlarBuyuk90.getInt(4));
        }

        // SORU3: Talebeler tablosunda id'si 124 olan öğrencilerin tüm bilgilerini listeleyiniz.
        ResultSet id124 = st.executeQuery("select * from talebeler where id=124");
        while (id124.next()) {
            System.out.printf("%-6d %-15.15s %-8s %-6d\n", id124.getInt(1),
                    id124.getString(2), id124.getString(3),
                    id124.getInt(4));
        }

        // SORU4: Talebeler tablosunda notu 70 ile 90 arasindaki kisilerin isimlerini listeleyiniz.
        ResultSet not7090 = st.executeQuery("select isim from talebeler where yazili_notu<90 and yazili_notu>70");
        while (not7090.next()) {
            System.out.println(not7090.getString("isim"));
        }

        // SORU5: Talebeler tablosunda isminin 2. harfi e olan kisilerin veli_isimleri ile birlikte listeleyiniz.
        ResultSet ismin2HarfiEOlan = st.executeQuery("select isim, veli_isim from talebeler where isim LIKE '_e%'");
        while (ismin2HarfiEOlan.next()) {
            System.out.printf("%-16s %-10s\n", ismin2HarfiEOlan.getString(1), ismin2HarfiEOlan.getString(2));
        }

    }

}

