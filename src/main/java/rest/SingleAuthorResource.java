package rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import author.Author;
import logging.Logger.Severity;
import parsing.*;
import logging.SysoutLogger;

/**
 * Resource for handling author name requests
 */
@Path("author")
public class SingleAuthorResource {
    
    private Gson gson = new Gson();

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getMsg(String data) {
        
        Parser<Author> parser = new AuthorParser(new SysoutLogger(Severity.DEBUG));
        Author a = parser.parse(data);
        
        return Response.status(200).entity(gson.toJson(a)).build();
    }
}
