package practice;

import java.sql.*;

public class P4_DML_Insert {
    //MySql de day6 da..
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch59?serverTimezone=UTC", "root", "0715");

        Statement st = con.createStatement();



        //SORU: Calisanlar tablosuna yeni bir kayit ((10005, 'Gokhan Agar' , 15000)  ekleyelim ve eklenen kaydi teyit icin sorgulayalim.
        String insertQuery="INSERT INTO calisanlar VALUES(10005, 'Gokhan Agar' , 15000)";


        //intelij de gorelim
        ResultSet rs = st.executeQuery(insertQuery);
        while (rs.next()){
            System.out.printf("%-7d %-20s %-10d",rs.getInt(1),rs.getString(2),rs.getInt(3));
        }


        //SORU: Calisanlar tablosuna birden fazla yeni kayıt ekleyelim.

        // 1.YONTEM
        // Ayri ayri sorgular ile veritabanina tekrar tekrar ulasmak islemlerin yavas yapilmasina yol acar.
        // 10000 tane veri kaydi yapildigi dusunuldugunde  bu kotu bir yaklasimdir.



        // 2.YONTEM (addBath ve excuteBatch() metotlari ile)
        // addBatch metodu ile SQL ifadeleri gruplandirilabilir ve
        // exucuteBatch()  metodu ile veritabanina bir kere gonderilebilir.
        // ***!!!!**** excuteBatch() metodu bir int [] dizi dondurur.
        // Bu dizi her bir ifade sonucunda etkilenen satir sayisini gosterir.


        // 3. YONTEM
        //-----------------------------------------------------
        // batch metoduyla birlikte PreparedStatement kullanmak en efektif yontemdir.
        // SQL de guvenligi icin basvurulan bir yontemdir. Unutulmamalidir...

    }
}