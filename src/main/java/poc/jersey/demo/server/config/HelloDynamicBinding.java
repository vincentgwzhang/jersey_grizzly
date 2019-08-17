package poc.jersey.demo.server.config;

import poc.jersey.demo.server.Greetings;
import poc.jersey.demo.server.filter.ResponseServerFilter;

import javax.ws.rs.container.DynamicFeature;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.FeatureContext;
import javax.ws.rs.ext.Provider;

/**
 * This class will check every endpoints
 */
@Provider
public class HelloDynamicBinding implements DynamicFeature {

    @Override
    public void configure(ResourceInfo resourceInfo, FeatureContext context) {
        if (Greetings.class.equals(resourceInfo.getResourceClass()) && resourceInfo.getResourceMethod().getName().contains("HiGreeting")) {
            context.register(ResponseServerFilter.class);
        }
    }

}
