package author;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.stream.Stream;

import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import logging.Logger;
import logging.Logger.Severity;
import logging.SysoutLogger;
import parsing.AuthorParser;
import parsing.Parser;

/**
 * A service for parsing author names
 * @author Mikkel Gade
 */
public class AuthorNameService {
    
    public static final String BASE_URI = "http://0.0.0.0:8080/";

    public static void main(String[] args) {
        Logger log = new SysoutLogger(Severity.DEBUG);
        log.info("Starting AuthorNameService...");
        log.debug("Args: " + Arrays.toString(args));
        
        if (args.length == 1) {
            String inputFileName = args[0]; // Expect file name as first argument
            log.info("Loading file: " + inputFileName);
            try {
                Stream<String> lines = Files.lines(Paths.get(inputFileName));
                
                Parser<Author> authorParser = new AuthorParser(log);
                lines.forEach(new Consumer<String>() {

                    @Override
                    public void accept(String line) {
                        log.debug(authorParser.parse(line).toString());
                    }
                });
                
                lines.close();
                
            } catch (IOException e) {
                log.error(String.format("Could not read file [%s]", e.toString()));
            }
            
        } else {
            startWebServer();
        }

    }
    
    /**
     * Starts a new web server instance
     */
    private static void startWebServer() {
        Logger log = new SysoutLogger(Severity.ERROR);
        log.info("Starting web server...");
        
        // Create a resource config that scans for JAX-RS resources and providers in rest package
        ResourceConfig resourceConfig = new ResourceConfig().packages("rest");

        // Create and start a new instance of grizzly web server
        GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), resourceConfig);
        
        log.info("Started web server at " + BASE_URI);
    }

}
