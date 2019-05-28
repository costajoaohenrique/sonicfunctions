package com.sonicfunctions.register.thorntail.controller;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 */
@Path("/")
@Singleton
public class RegisterController {

    
    @GET
    @Produces("text/plain")
    @Path("/{name}")
    public String getByName(@PathParam("name") String name) {
        return "Hello World " + name;
    }
}
