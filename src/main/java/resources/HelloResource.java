package resources;

import javax.json.JsonArray;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;
import connection.test;

import java.sql.SQLException;

@Path("/hello")
public class HelloResource {

    @GET
    @Produces("application/json")
    public JsonArray handleGreeting() throws SQLException {
    	 test a = new test(); return a.getArray(a.getConn());
    }

}
