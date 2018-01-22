package resources;

import javax.json.JsonArray;
import javax.ws.rs.*;
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

    @POST
    @Produces("application/json")
    public String andlePost(@FormParam("code") String code){

    return "done";
    }
}
