package querys;

import java.sql.*;

public class Query04 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/okul?serverTimezone=UTC", "root", "0715");
        //Statement st = con.createStatement();
        PreparedStatement ps = con.prepareStatement("select * from ogrenciler");
        ResultSet rs = ps.executeQuery();
        ResultSetMetaData rsmd = rs.getMetaData();

        System.out.println("1. sutunun ismi : "+rsmd.getColumnName(1));
        System.out.println("2. sutunun ismi : "+rsmd.getColumnName(2));
        System.out.println("3. sutunun ismi : "+rsmd.getColumnName(3));
        System.out.println("4. sutunun ismi : "+rsmd.getColumnName(4));

        System.out.println("Toplam sutun sayisi : "+rsmd.getColumnCount());

        System.out.println("========================================================================================");

        System.out.println("1. sutunun data tipi : "+rsmd.getColumnTypeName(1));
        System.out.println("2. sutunun data tipi : "+rsmd.getColumnTypeName(2));
        System.out.println("3. sutunun data tipi : "+rsmd.getColumnTypeName(3));
        System.out.println("4. sutunun data tipi : "+rsmd.getColumnTypeName(4));

        System.out.println("Tablonun ismi : "+rsmd.getTableName(1));

        System.out.println("========================================================================================");

        while (rs.next()){
            System.out.printf("%-6d %-15.15s %-8s %-8s\n", rs.getInt(1),
                    rs.getString(2), rs.getString(3),
                    rs.getString(4));
        }

    }
}
