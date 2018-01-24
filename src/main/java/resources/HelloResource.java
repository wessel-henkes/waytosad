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
    @Produces("text/plain")
    public String handleGreeting() throws SQLException {
    	return "hello world";
    }

    @POST
    @Produces("text/plain")

    public String andlePost(@FormParam("code") String code){
    System.out.println(code);
    return "done";
    }
}
