package org.sonicfunctions.controller;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.sonicfunctions.domain.ResultCompiler;
import org.sonicfunctions.service.CompilerService;

@Path("/api")
public class CompilerController {

    @Inject
    private CompilerService service;

    @GET
    @Path("/eval")
    @Produces(MediaType.APPLICATION_JSON)
    public ResultCompiler eval(@QueryParam("source") String source) {
        return service.eval(source);
    }
}