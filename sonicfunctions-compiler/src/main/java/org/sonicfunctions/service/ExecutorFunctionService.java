package org.sonicfunctions.service;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonicfunctions.domain.ResultExecutor;

/**
 * CompilerService
 */
@RequestScoped
public class ExecutorFunctionService {

    @Inject
    private CompilerService service;

    private static final Logger LOGGER = LoggerFactory.getLogger(ExecutorFunctionService.class);

    public ResultExecutor execute(String source) {
        LOGGER.info("Executing source");
        try {
            String result = service.evalForExecute(source).toString();
            return ResultExecutor.ofSuccess(result);
        } catch (Exception e) {
            LOGGER.error("Error executing source", e);
            return ResultExecutor.ofNotSuccess(e.getMessage());
        }
    }


}