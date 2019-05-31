package com.sonicfunctions.register.thorntail.controller;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sonicfunctions.register.thorntail.domain.Function;
import com.sonicfunctions.register.thorntail.service.RegisterService;

/**
 *
 */
@Path("/")
@Singleton
public class RegisterController {

    @Inject
    private RegisterService registerService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/function")
    public String saveFunction(Function function) {
        return registerService.saveFunction(function);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/function/{name}")
    public Function getFunctionByName(@PathParam("name") String name) {
        return registerService.getFunctionByName(name);
    }
}
