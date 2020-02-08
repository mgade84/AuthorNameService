package rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Resource for handling author name requests
 */
@Path("author")
public class AuthorResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getIt() {
        return "{\"message\":\"Got it! 2\"}";
    }
}
