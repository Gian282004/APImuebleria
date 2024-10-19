package com.muebleria.handler;

import com.muebleria.exception.UsuarioNoEncontrado;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class GlobalExceptionHandler {
       public ResponseEntity<String> handleUsuarioNoEncontrado(UsuarioNoEncontrado e)
       {
           return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
       }
}
