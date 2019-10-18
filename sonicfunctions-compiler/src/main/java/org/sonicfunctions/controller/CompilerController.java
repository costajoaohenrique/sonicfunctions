package org.sonicfunctions.controller;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonicfunctions.domain.ResultCompiler;
import org.sonicfunctions.domain.SFunction;
import org.sonicfunctions.domain.SParameter;
import org.sonicfunctions.service.CompilerService;

@Path("/api")
public class CompilerController {

    @Inject
    CompilerService service;

    private static final Logger LOGGER = LoggerFactory.getLogger(CompilerController.class);

    @GET
    @Path("/eval")
    @Produces(MediaType.APPLICATION_JSON)
    public ResultCompiler eval(@QueryParam("source") String source) {
        return service.eval(source);
    }

    @POST
    @Path("/insert")
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public String insert() {
        LOGGER.info("Inserindo Functions JS no Banco");
        SFunction.ofJS("qtdMesesAno", "function qtdMesesAno() {return soma(6,6);}", 1L).persist();
        SFunction.ofJS("soma", "function soma(valor1,valor2) {return valor1 + valor2;}", 1L)
                .addParam("valor1", SParameter.Type.INT).addParam("valor2", SParameter.Type.INT).persist();
        LOGGER.info("Function inserida");
        return "OK";
    }
}