package org.sonicfunctions;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.sonicfunctions.service.CompilerService;

@Path("/api")
public class SonicFunctionsResource {

    @Inject
    private CompilerService service;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return service.eval();
    }
}