package com.example.demo.controller;

import com.example.demo.service.DemoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Map;

@Path("/jaxrs")
public class DemoJaxRsController {

    private final DemoService demoService;

    //@Autowired
    @Inject
    public DemoJaxRsController(DemoService demoService) {
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

    @POST
    @Path("/path/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createWithPathParam(@PathParam("id") String id) {
        String msg = "received id: " + (id == null ? "" : id);
        return Response.ok(Map.of("message", demoService.createMessage(msg))).build();
    }

    @POST
    @Path("/body")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createWithBody(Map<String, String> payload) {
        String message = payload == null ? "" : payload.getOrDefault("message", "");
        return Response.ok(Map.of("message", demoService.createMessage(message))).build();
    }
}
