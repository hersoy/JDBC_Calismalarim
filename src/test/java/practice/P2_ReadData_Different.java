package practice;

import java.sql.*;

public class P2_ReadData_Different {

        //MySql de day4 de..personel tablosu


        public static void main(String[] args) throws SQLException, ClassNotFoundException {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch59?serverTimezone=UTC", "root", "0715");

            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            // ilk satirdaki ilk objeyi yazdiralim
            String query = "select * from personel";
            ResultSet resultSet=st.executeQuery(query);
            System.out.println(resultSet.getRow());    //0 //hangi row'dasin sorgusu
            resultSet.first();      // imleci ilk kayita goturmus oldu
            Object ilkSatirdakiObje = resultSet.getObject(1);
            System.out.println(ilkSatirdakiObje.toString());        // 123456789 / ilk hucredeki degeri yazdirdi

            // ikinci satirdaki ilk objeyi yazdiralim
            resultSet.next();
            Object ikinciSatirdakiObje = resultSet.getObject(1);
            System.out.println(ikinciSatirdakiObje.toString());     // 234567890 / ikinci satirdaki degeri yazdirdi

            // ilk sutundaki 5.degeri yazdiralim
            resultSet.absolute(5);
            Object besinciSatirdakiDeger = resultSet.getObject(1);
            System.out.println(besinciSatirdakiDeger.toString());       // 456789012

            // 0.satira gitmemizin sebebi while sorgusu icerisinde bulunan resultSet.next() in bizi
            // birinci kayda goturmesi icindir. Eger 1.satira gidecek olsak while icindeki kod yuzunden yazdirmaya
            // 2.satirdan baslar, tum listeyi alamayiz
            System.out.println("=======================TUM ID'LER===========================================");
            // Tum listeyi yazdirmak istersek;
            resultSet.absolute(0);  // boylelikle oncelikle ilk satira gideriz
            while(resultSet.next()){
                Object idler = resultSet.getObject(1);  // 1. kolondaki tum objeleri getirir
                System.out.println(idler.toString());
            }
            System.out.println("=====================TUM İSİMLER=============================================");
            resultSet.absolute(0);  // boylelikle oncelikle ilk satira gideriz
            while(resultSet.next()){
                Object isim = resultSet.getObject("isim");  // 2. kolondaki tum objeleri getirir
                System.out.println(isim.toString());
            }
            System.out.println("=====================TUM SEHİRLER============================================");
            resultSet.absolute(0);  // boylelikle oncelikle ilk satira gideriz
            while(resultSet.next()){
                Object sehir = resultSet.getObject("sehir");  // 3. kolondaki tum objeleri getirir
                System.out.println(sehir.toString());
            }












        }

}

