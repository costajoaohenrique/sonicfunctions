package org.sonicfunctions.controller;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.sonicfunctions.domain.ResultExecutor;
import org.sonicfunctions.service.ExecutorFunctionService;

@Path("/api")
public class ExecutorController {

    @Inject
    private ExecutorFunctionService service;

    @GET
    @Path("/execute")
    @Produces(MediaType.APPLICATION_JSON)
    public ResultExecutor execute(@QueryParam("source") String source) {
        return service.execute(source);
    }
}