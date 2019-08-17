package poc.jersey.demo.server.interceptor;

import java.io.IOException;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.ReaderInterceptor;
import javax.ws.rs.ext.ReaderInterceptorContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Effect on POST method
 */
@Provider
public class RequestServerReaderInterceptor implements ReaderInterceptor {

    private static final Logger LOG = LoggerFactory.getLogger(RequestServerReaderInterceptor.class);

    @Override
    public Object aroundReadFrom(ReaderInterceptorContext context) throws IOException, WebApplicationException {
        LOG.info("Request reader interceptor in the server side");

        //For example, the form input string is "abc", then it change the input string to "abc updated"
        //InputStream is = context.getInputStream();
        //String body = new BufferedReader(new InputStreamReader(is)).lines().collect(Collectors.joining("\n"));
        //context.setInputStream(new ByteArrayInputStream((body + " updated").getBytes()));

        return context.proceed();
    }

}
