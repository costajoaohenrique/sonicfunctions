package org.sonicfunctions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.SortedMap;
import java.util.TreeMap;

import org.junit.jupiter.api.Test;
import org.sonicfunctions.domain.SFunction;
import org.sonicfunctions.domain.SParameter;
import org.sonicfunctions.utils.JsUtils;

/**
 * ExcutorFucntionsTest
 */
public class ExcutorFucntionsTest {

    @Test
    public void createCallJsTest(){
        SFunction function = SFunction.ofJS("nomeDaFuncao", "", 1L)
            .addParam("param1", SParameter.Type.INT)
            .addParam("param2", SParameter.Type.DECIMAL);

        SortedMap<String, String> params = new TreeMap<String,String>();
        params.put("param1", "30");
        params.put("param2", "77");

        String result = JsUtils.createCall(function,params,"");
        assertEquals(result,"nomeDaFuncao(30,77);");
    }

} 