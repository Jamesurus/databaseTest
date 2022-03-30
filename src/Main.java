/**
 * @author Sen Wang
 * @version 03.30
 */

import java.sql.*;

public class Main {
    private static String DriverName = "org.sqlite.JDBC";

    public static void main(String[] args) throws SQLException {
        System.out.println("Hello World");
        try {
            Class.forName("org.sqlite.JDBC");//加载驱动
            Connection conn = DriverManager.getConnection("jdbc:sqlite:D:\\databases\\University.db");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from courses");
            System.out.println("c_id\tc_title\tcode\tyear\td_id");
            while (rs.next()) {
                System.out.print(rs.getString(1)+"\t");
                System.out.print(rs.getString(2)+"\t");
                System.out.print(rs.getString(3)+"\t");
                System.out.print(rs.getString(4)+"\t");
                System.out.print(rs.getString(5)+"\n");

            }
            rs.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
