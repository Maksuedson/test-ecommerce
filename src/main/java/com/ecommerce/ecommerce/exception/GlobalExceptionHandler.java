package com.ecommerce.ecommerce.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NaoEncontradoException.class)
    public ResponseEntity<String> handleNaoEncontrado(NaoEncontradoException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(NaoAlteradoException.class)
    public ResponseEntity<String> handleNaoAlterado(NaoAlteradoException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
    
    @ExceptionHandler(IntegridadeException.class)
    public ResponseEntity<String> handleIntegridade(IntegridadeException ex) {
    	return ResponseEntity.status
    			(HttpStatus.CONFLICT).body("Erro de integridade: " + ex.getMessage());
    }

}
