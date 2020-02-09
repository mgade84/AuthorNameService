package rest;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import author.Author;
import logging.Logger.Severity;
import parsing.*;
import logging.SysoutLogger;

/**
 * Resource for handling multi author name requests
 * @author Mikkel Gade
 */
@Path("multiauthor")
public class MultiAuthorResource {
    
    private Gson gson = new Gson();

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getMsg(String data) {
        
        Parser<List<Author>> parser = new MultiAuthorParser(new SysoutLogger(Severity.DEBUG));
        List<Author> authorList = parser.parse(data);
        
        return Response.status(200).entity(gson.toJson(authorList)).build();
    }
}
