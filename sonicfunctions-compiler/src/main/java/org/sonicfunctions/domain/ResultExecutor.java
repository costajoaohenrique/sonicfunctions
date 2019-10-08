package org.sonicfunctions.domain;

import java.util.Optional;

/**
 * ResultCompiler
 */
public class ResultExecutor {

    private boolean success;

    private Optional<String> messageError;

    private Optional<String> resultMessage;

    public Optional<String> getResultMessage() {
        return resultMessage;
    }
    public boolean isSuccess() {
        return success;
    }

    public Optional<String> getMessageError() {
        return messageError;
    }

    private ResultExecutor(boolean success, Optional<String> messageError, Optional<String> resultMessage) {
        this.success = success;
        this.messageError = messageError;
        this.resultMessage = resultMessage;
    }

    public static ResultExecutor ofSuccess(String resultMessage) {
        return new ResultExecutor(true, Optional.empty(), Optional.of(resultMessage));
    }

    public static ResultExecutor ofNotSuccess(String messageError) {
        return new ResultExecutor(false, Optional.of(messageError),Optional.empty());
    }
}