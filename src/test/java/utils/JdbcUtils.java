package utils;

import java.sql.*;

public class JdbcUtils {

    private static Connection connect = null;
    private static Statement stmt = null;
    private static ResultSetMetaData metaData = null;
    private static ResultSet reSet = null;


    public static void getConnection(){

        String url= ConfReader.getValue("JDBCurl");
        String username= ConfReader.getValue("Username");
        String password = ConfReader.getValue("Password");

        try {
            connect = DriverManager.getConnection(url,username,password);
            System.out.println("Connected to DataBase");
        } catch (SQLException e) {
            System.out.println("ConnectionFail" + e.getMessage());
            e.printStackTrace();
        }


    }


}
