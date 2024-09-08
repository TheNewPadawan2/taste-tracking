package it.uniecampus.lfulgione.tastetracking.ttbe.login.advice;

import it.uniecampus.lfulgione.tastetracking.ttbe.login.controller.ProductController;
import it.uniecampus.lfulgione.tastetracking.ttbe.login.dto.ErrorDTO;
import it.uniecampus.lfulgione.tastetracking.ttbe.login.exception.EmailNotFoundException;
import it.uniecampus.lfulgione.tastetracking.ttbe.login.exception.PasswordNotMatchesException;
import it.uniecampus.lfulgione.tastetracking.ttbe.login.exception.ProductNotFoundException;
import it.uniecampus.lfulgione.tastetracking.ttbe.login.exception.UserAlreadyExistException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(assignableTypes = { ProductController.class })
@Slf4j
public class ProductControllerAdvice {
    @ExceptionHandler(value = {
            ProductNotFoundException.class})
    private ResponseEntity<ErrorDTO> productNotFound() {
        log.error("Product not found");
        return new ResponseEntity<>(
                ErrorDTO.builder()
                        .code("PRD-001")
                        .message("Aggiornamento fallito: prodotto non trovato")
                        .build(),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
