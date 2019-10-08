package org.sonicfunctions.controller;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

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

    @GET
    @Path("/execute/{idUser}/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public ResultExecutor execute(@PathParam("idUser") Long idUser,@PathParam("name") String name,@Context UriInfo info) {
        Map<String,String> mapParams = new HashMap<>();
        info.getQueryParameters().forEach((k,v) -> mapParams.put(k, v.get(0)));
        return service.execute(idUser,name,mapParams);
    }
}