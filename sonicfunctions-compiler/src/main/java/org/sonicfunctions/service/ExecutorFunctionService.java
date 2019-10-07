package org.sonicfunctions.service;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonicfunctions.domain.ResultExecutor;
import org.sonicfunctions.domain.SFunction;
import org.sonicfunctions.utils.JsUtils;

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

    public ResultExecutor execute(Long idUser, String nameFunction, Map<String, String> params) {
        SFunction sfunction = SFunction.find("name", nameFunction).firstResult();
        if (Objects.isNull(sfunction)) {
            return ResultExecutor.ofNotSuccess(String.format("Function %s not found", nameFunction));
        }
        List<SFunction> sfunctions = SFunction.list("idUser", idUser);
        String source = sfunctions.stream().map(sf -> sf.getSourceBody()).reduce("", (a, b) -> a.concat(b));
        LOGGER.info(source);
        source = JsUtils.createCall(sfunction, params, source);
        return execute(source);
    }

}