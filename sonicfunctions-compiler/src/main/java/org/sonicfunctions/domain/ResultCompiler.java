package org.sonicfunctions.domain;

import java.util.Optional;

/**
 * ResultCompiler
 */
public class ResultCompiler {

    private boolean valid;

    private Optional<String> messageError;

    public boolean isValid() {
        return valid;
    }

    public Optional<String> getMessageError() {
        return messageError;
    }

    private ResultCompiler(boolean valid, Optional<String> messageError) {
        this.valid = valid;
        this.messageError = messageError;
    }

    public static ResultCompiler ofValid() {
        return new ResultCompiler(true, Optional.empty());
    }

    public static ResultCompiler ofInvalid(String messageError) {
        return new ResultCompiler(false, Optional.of(messageError));
    }
}