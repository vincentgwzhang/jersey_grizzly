package poc.jersey.demo.server.http;

import java.io.IOException;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import poc.jersey.demo.server.config.ViewApplicationConfig;

public class EmbeddedHttpServer {

    public static final URI BASE_URI = URI.create("http://localhost:8082/");

    public static void main(String[] args) {
        try {
            final HttpServer server = GrizzlyHttpServerFactory.createHttpServer(BASE_URI, new ViewApplicationConfig(), false);
            Runtime.getRuntime().addShutdownHook(new Thread(() -> server.shutdownNow()));
            server.start();
        } catch (IOException ex) {
            Logger.getLogger(EmbeddedHttpServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static HttpServer startServer() {
        final ResourceConfig rc = new ResourceConfig().packages("poc.jersey.demo.server");
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI.toString()), rc);
    }
}
