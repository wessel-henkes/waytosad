package connection;

import java.sql.*;

public class ConnectionOracle {

    private static final String DB_DRIV = "oracle.jdbc.driver.OracleDriver";
    private static final String DB_URL = "jdbc:oracle:thin:@ondora02.hu.nl:8521/cursus02.hu.nl";
    private static final String DB_USER = "tosad_2017_2b_team2";
    private static final String DB_PASS = "tosad_2017_2b_team2";
    private static final String DB_USER2 = "tosad_2017_2b_team2_target";
    private static final String DB_PASS2 = "tosad_2017_2b_team2_target";
    private static Connection conn;
    private static Connection conn2;



    @SuppressWarnings("Duplicates")
    public void Connect() throws SQLException {
        try {
            Class.forName(DB_DRIV).newInstance();
        }
        catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
            e1.printStackTrace();
        }
        try {
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            conn2 = DriverManager.getConnection(DB_URL, DB_USER2, DB_PASS2);
        }catch (SQLException e){
            System.out.println(e);
        }
    }

    public static Connection getConn() {
        return conn;
    }

    public static Connection getConn2() {
        return conn2;
    }

    public void closeConnection(Connection c){
        try{
            c.close();
        }catch (SQLException e){
            System.out.println(e);
        }
    }

}
