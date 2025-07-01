/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author hp 15
 */
public class Connector {
    static String url = "jdbc:sqlserver://localhost\\Quandale-Dingle:1433;databaseName=SellerDashboard;encrypt=true;trustServerCertificate=true";
    static String userName = "iqbal";
    static String password = "1234556";
    
    public static Connection getConnection()
            throws SQLException, ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection conn = DriverManager.getConnection(url, userName, password);
        return conn;
    }

    public static void main(String[] args) {
        try (Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from Products")) {
           while (rs.next()) {
               System.out.println(rs.getString(1));
           }

       } catch (Exception e) {
           e.printStackTrace();
       }
    }

}
