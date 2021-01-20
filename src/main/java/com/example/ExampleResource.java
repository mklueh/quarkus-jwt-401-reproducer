package com.example;

import javax.annotation.security.DenyAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class ExampleResource {

    @GET
    @Path("hello")
    @Produces(MediaType.TEXT_PLAIN)
    @RolesAllowed({"user"})
    public String hello() {
        return "Hello RESTEasy";
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @DenyAll
    @Path("not-reachable")
    public String notReachable() {
        return "Hello RESTEasy";
    }
}