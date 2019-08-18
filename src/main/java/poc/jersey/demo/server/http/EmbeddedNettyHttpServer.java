package poc.jersey.demo.server.http;

import io.netty.channel.Channel;
import org.glassfish.jersey.netty.httpserver.NettyHttpContainerProvider;
import poc.jersey.demo.server.config.ViewApplicationConfig;

import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmbeddedNettyHttpServer {

    public static final URI BASE_URI = URI.create("http://localhost:8082/");

    public static void main(String[] args) {
        try {
            final Channel server = NettyHttpContainerProvider.createHttp2Server(BASE_URI, new ViewApplicationConfig(), null);
            Runtime.getRuntime().addShutdownHook(new Thread(() -> server.close()));
            Thread.currentThread().join();
        } catch (Exception ex) {
            Logger.getLogger(EmbeddedNettyHttpServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
