package com.tarefaChicao.projeto.controllers.handlers;

import com.tarefaChicao.projeto.dtos.CustomError;
import com.tarefaChicao.projeto.services.exceptions.NotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<CustomError> notFound(NotFoundException err, HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        CustomError error = new CustomError(Instant.now(), status.value(), err.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(error);
    }
}
