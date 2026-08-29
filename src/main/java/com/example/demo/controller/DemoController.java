package com.example.demo.controller;

import com.example.demo.service.DemoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

@Path("/demo")
public class DemoController {

    private final DemoService demoService;

    //@Autowired
    @Inject
    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMessage() {
        return Response.ok(Map.of("message", demoService.getMessage())).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response createMessage(@QueryParam("message") String message) {
        return Response.ok(Map.of("message", demoService.createMessage(message == null ? "" : message))).build();
    }
}
