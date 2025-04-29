package com.exercicio.exercicio.exception;

import com.exercicio.exercicio.dto.ErroDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErroDTO> handleRuntime(RuntimeException ex) {
        return ResponseEntity.badRequest().body(new ErroDTO(ex.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroDTO> handleValidation(MethodArgumentNotValidException ex) {
        return ResponseEntity.badRequest().body(new ErroDTO("Dados inválidos."));
    }
}