package com.example.demo.config;

import com.example.demo.controller.DemoJaxRsController;
import jakarta.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        // Disable WADL generation to avoid JAXBContext warning when JAXB implementation is not on the classpath
        property("jersey.config.server.wadl.disableWadl", true);
        register(DemoJaxRsController.class);
    }
}
