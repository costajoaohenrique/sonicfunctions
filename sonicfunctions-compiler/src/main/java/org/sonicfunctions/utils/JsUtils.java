package org.sonicfunctions.utils;

import java.util.Map;

import org.sonicfunctions.domain.SFunction;

/**
 * JsUtils
 */
public class JsUtils {

    public static String createCall(SFunction sfunction, Map<String, String> params, String fullSource) {
        String paramsString = sfunction.getParameters()
            .stream()
            .map(p -> params.get(p.getName()))
            .reduce((x, z) -> x + "," + z).get();
        return sfunction.getName().concat("(").concat(paramsString).concat(");").concat(fullSource);
    }

}