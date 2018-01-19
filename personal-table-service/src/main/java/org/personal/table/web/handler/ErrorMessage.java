package org.personal.table.web.handler;

import lombok.Getter;

public class ErrorMessage {

    @Getter
    private String message;

    public ErrorMessage(String message) {
        this.message = message;
    }

}
