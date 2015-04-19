package es.uned.services.init;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import es.uned.services.rest.RestAPI;

@Configuration
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(RestAPI.class);
    }
}
