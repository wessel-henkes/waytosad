package connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class testConnect {
    private ConnectionOracle CO;
    private Connection conn  = CO.getConn();
    private Connection conn2 = CO.getConn2();

    public void testconneasdf() throws SQLException{
        //test
        Statement stm = conn.createStatement();
        String queryText = "SELECT id, string FROM test";
        Statement stm2 = conn2.createStatement();
        String queryText2 = "SELECT id , string FROM test";

        ResultSet rs = stm.executeQuery(queryText);
        ResultSet rs2 = stm2.executeQuery(queryText2);

        int id;
        String string;
        while (rs.next()) {
            id = rs.getInt("id");
            string = rs.getString("string");
            System.out.println(id + ", " + string);
        }

        int id2;
        String string2;
        while (rs2.next()) {
            id2 = rs2.getInt("id");
            string2 = rs2.getString("string");
            System.out.println(id2 + ", " + string2);
        }

        rs.close();
        stm.close();
        rs2.close();
        stm2.close();
        conn.close();
        conn2.close();
    }
}
