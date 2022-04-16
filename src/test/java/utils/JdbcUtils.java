package utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcUtils {

    private static Connection connect = null;   // database
    private static Statement stmt = null;       // schema
    private static ResultSet rsSet = null;      // query
    private static ResultSetMetaData metaData = null; // queryHeader


    public static void connectConnection(){

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

    public static void connectStatement(){
       // connectConnection();

        try {
            stmt= connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            System.out.println("Connected to schema");
        } catch (SQLException e) {
            System.out.println("StatementFailed" + e.getMessage());
            e.printStackTrace();
        }
    }

    public static ResultSet assignQuery(String query){
        connectStatement();

        try {
            rsSet = stmt.executeQuery(query);
        } catch (SQLException e) {
            System.out.println("Query Fail " + e.getMessage());
            e.printStackTrace();
        }
        return rsSet;

    }

    public static String getSingularValue(ResultSet query){

        String value= "valueNotValid";
        try {
            query.beforeFirst();
            query.next();
            value = query.getString(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return value;

    }

    public static List<String> getAllColumNames(ResultSet rs){
        ResultSetMetaData metaData = null;
        List<String> columnNames = new ArrayList<>();

        try {
            metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                columnNames.add(metaData.getColumnName(i));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return columnNames;
    }




}
