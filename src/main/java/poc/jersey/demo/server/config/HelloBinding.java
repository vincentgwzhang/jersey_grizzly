package poc.jersey.demo.server.config;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.ws.rs.NameBinding;

/**
 *
 * @NameBinding is for made an annotation, for example, named "HelloBinding"
 *
 * Then put @HelloBinding to a ContainerRequestFilter.
 *
 * Then put @HelloBinding to any endpoint, for example com.baeldung.jersey.server.Greetings#getHelloGreeting()
 *
 * So when getHelloGreeting() endpoint is called, then ContainerRequestFilter will be called
 *
 *
 */
@NameBinding
@Retention(RetentionPolicy.RUNTIME)
public @interface HelloBinding {
}
