package connection;

import java.sql.*;
import javax.json.*;


public class test{

    private static final String DB_DRIV = "oracle.jdbc.driver.OracleDriver";
    private static final String DB_URL = "jdbc:oracle:thin:@ondora02.hu.nl:8521/cursus02.hu.nl";
    private static final String DB_USER = "tosad_2017_2b_team2";
    private static final String DB_PASS = "tosad_2017_2b_team2";
    private static final String DB_USER2 = "tosad_2017_2b_team2_target";
    private static final String DB_PASS2 = "tosad_2017_2b_team2_target";
    private Connection conn;
    public test() throws SQLException {
        try {
            Class.forName(DB_DRIV).newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
            e1.printStackTrace();
        }

        conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
    }
    public JsonArray getArray(Connection conn) throws SQLException{

            //test
            Statement stm = conn.createStatement();
            String queryText = "SELECT id, string FROM test";


            ResultSet rs = stm.executeQuery(queryText);

            JsonArrayBuilder jab = Json.createArrayBuilder();

            int id;
            String string;
            while (rs.next()) {
                JsonObjectBuilder job = Json.createObjectBuilder();

                id = rs.getInt("id");
                string = rs.getString("string");
                System.out.println(id + ", " + string);
                job.add("id", id);
                job.add("String", string);
                jab.add(job);
            }
            JsonArray array = jab.build();

            rs.close();
            stm.close();
            conn.close();
            return array;

    }

    public Connection getConn() {
        return conn;
    }
}
