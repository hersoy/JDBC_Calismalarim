package querys;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Query06 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch59?serverTimezone=UTC", "root", "0715");
        Statement st = con.createStatement();
/*
        // SORU1: Bölümler tablosunda yeni bir kayıt (80, 'ARGE', 'ISTANBUL')
       int s1 = st.executeUpdate("insert into bolumler values(80, 'ARGE', 'İSTANBUL')");
        System.out.println(s1+ " satir eklendi");



        // executeUpdate: etkilenen satir sayisini dondurur. onun icin yazdirmak icin int'e atadik

        // 1. YOL:
        // SORU2; Bölümler tablosuna birden fazla kayıt ekleyelim.
        String[] veri1 = {"insert into bolumler values(95, 'YEMEKHANE', 'İSTANBUL')",
                "insert into bolumler values(85, 'OFIS1', 'ANKARA')",
                "insert into bolumler values(75, 'OFIS2', 'ANTALYA')"};

        int count=0;
        for (String each:veri1
             ) {

           count=count+st.executeUpdate(each);
        }
        System.out.println(count+ " data eklendi");

        // 2. YOL:
        String[] veri2 = {"insert into bolumler values(81, 'YEMEKHANE', 'İSTANBUL')",
                "insert into bolumler values(82, 'OFIS1', 'ANKARA')",
                "insert into bolumler values(83, 'OFIS2', 'ANTALYA')"};


        for (String each : veri2
        ) {
        st.addBatch(each);  // yukaridaki verilerin tamamini bir araya topluyor
        }
        st.executeBatch();      // biraraya getirilen verileri tek seferde gonderir

        System.out.println("veriler database'e eklendi");

 */
        // SORU2; Bölümler tablosuna birden fazla kayıt ekleyelim.
        String[] veri3 = {"insert into bolumler values(101, 'YEMEKHANE', 'İSTANBUL')",
                "insert into bolumler values(102, 'OFIS1', 'ANKARA')",
                "insert into bolumler values(103, 'OFIS2', 'ANTALYA')",
                "insert into bolumler values(104, 'OFIS3', 'ADANA')"};

        for (String each:veri3){
            st.addBatch(each);
        }
        st.executeBatch();

        System.out.println("Veriler database eklendi");




    }
}
