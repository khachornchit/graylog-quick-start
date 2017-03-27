/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataManagement;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author kajornjit.songsaen
 */
public class CrmPerformanceChart {

    private static final String DB_DRIVER = "oracle.jdbc.OracleDriver";
    private static final String DB_CONNECTION = "jdbc:oracle:thin:@vmdevtest01:1521/XE";
    private static final String DB_USER = "clbsdashboard";
    private static final String DB_PASSWORD = "123456";

    public boolean insertRecordIntoTable(
            int PerformanceId,
            String Timex,
            int PageSpeed,
            int RestSpeed,
            int Reference,
            int Lsl,
            int Usl
    ) throws SQLException {

        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;
        String insertTableSQL = "INSERT INTO CLBSDASHBOARD.CRMPERFERMANCECHART (PERFORMANCEID,TIMEX,PAGESPEED,RESTSPEED,REFERENCE,LSL,USL) VALUES (?,?,?,?,?,?,?)";

        try {
            dbConnection = getDBConnection();
            preparedStatement = dbConnection.prepareStatement(insertTableSQL);
            preparedStatement.setInt(1, PerformanceId);
            preparedStatement.setString(2, Timex);
            preparedStatement.setInt(3, PageSpeed);
            preparedStatement.setInt(4, RestSpeed);
            preparedStatement.setInt(5, Reference);
            preparedStatement.setInt(6, Lsl);
            preparedStatement.setInt(7, Usl);
            preparedStatement.executeUpdate();
            System.out.println("Record is inserted into DBUSER table!");
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        } finally {

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (dbConnection != null) {
                dbConnection.close();
            }
        }
    }

    public boolean selectRecordsFromTable() throws SQLException {

        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;
        String selectSQL = "SELECT PERFORMANCEID,TIMEX ,PAGESPEED ,RESTSPEED ,LSL ,USL ,REFERENCE FROM CLBSDASHBOARD.CRMPERFERMANCECHART";

        try {
            dbConnection = getDBConnection();
            preparedStatement = dbConnection.prepareStatement(selectSQL);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String PerformanceId = rs.getString("PERFORMANCEID");
                String Timex = rs.getString("TIMEX");
                String PageSpeed = rs.getString("PAGESPEED");
                String RestSpeed = rs.getString("RESTSPEED");
                String LSL = rs.getString("LSL");
                String USL = rs.getString("USL");
                String Reference = rs.getString("REFERENCE");

                System.out.println("PerformanceId : " + PerformanceId);
                System.out.println("Time : " + Timex);
                System.out.println("PageSpeed : " + PageSpeed);
                System.out.println("RestSpeed : " + RestSpeed);
                System.out.println("LSL : " + LSL);
                System.out.println("USL : " + USL);
                System.out.println("Reference : " + Reference);
            }
            return true;
        } catch (SQLException e) {

            System.out.println(e.getMessage());
            return false;
        } finally {

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (dbConnection != null) {
                dbConnection.close();
            }
            return true;
        }

    }

    public boolean getLastTime() throws SQLException {

        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;
        String selectSQL = "SELECT TIMEX FROM CRMPERFERMANCECHART WHERE PERFORMANCEID = (SELECT MAX(PERFORMANCEID) FROM CRMPERFERMANCECHART)";

        try {
            dbConnection = getDBConnection();
            preparedStatement = dbConnection.prepareStatement(selectSQL);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String Timex = rs.getString("TIMEX");
                System.out.println("Last Time : " + Timex);
            }
            return true;
        } catch (SQLException e) {

            System.out.println(e.getMessage());
            return false;
        } finally {

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (dbConnection != null) {
                dbConnection.close();
            }
            return true;
        }

    }

    private Connection getDBConnection() {

        Connection dbConnection = null;

        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
            return dbConnection;

        } catch (SQLException e) {
            System.out.println("Connect failed !");
            System.out.println(e.getMessage());
        }
        return dbConnection;
    }

    private java.sql.Timestamp getCurrentTimeStamp() {
        java.util.Date today = new java.util.Date();
        return new java.sql.Timestamp(today.getTime());
    }
}
