package org.personal.table.web.handler;

import org.personal.table.exception.NoNoteException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler({NoNoteException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Void> handleNoFoundError() {
        return ResponseEntity.notFound().build();
    }

}
