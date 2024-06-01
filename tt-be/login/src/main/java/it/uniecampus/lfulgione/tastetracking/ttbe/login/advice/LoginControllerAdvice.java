package it.uniecampus.lfulgione.tastetracking.ttbe.login.advice;

import it.uniecampus.lfulgione.tastetracking.ttbe.login.controller.LoginController;
import it.uniecampus.lfulgione.tastetracking.ttbe.login.dto.ErrorDTO;
import it.uniecampus.lfulgione.tastetracking.ttbe.login.exception.EmailNotFoundException;
import it.uniecampus.lfulgione.tastetracking.ttbe.login.exception.PasswordNotMatchesException;
import it.uniecampus.lfulgione.tastetracking.ttbe.login.exception.UserAlreadyExistException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(assignableTypes = { LoginController.class })
@Slf4j
public class LoginControllerAdvice {

    @ExceptionHandler(value = {UserAlreadyExistException.class})
    private ResponseEntity<ErrorDTO> userAlreadyExist() {
        log.error("The mail address was already assigned to another user");
        return new ResponseEntity<>(
                ErrorDTO.builder()
                        .code("LOG-C001")
                        .message("The mail address was already assigned to another user")
                        .build(),
                HttpStatus.OK);
    }

    @ExceptionHandler(value = {
            EmailNotFoundException.class,
            PasswordNotMatchesException.class})
    private ResponseEntity<ErrorDTO> passwordEmailMissmatch() {
        log.error("Email or Password wrong");
        //1) Junior = "non capisco un cazzo"
        //2) Middle = "Non so a che serve, però le variabili fanno scopa ed il metodo mi fa capire che vole quest'oggetto qua"
        //3) Senior = "Si ma perché faccio questo?"
        return new ResponseEntity<>(
                ErrorDTO.builder()
                        .code("LOG-R001")
                        .message("Email or Password wrong")
                        .build(),
                HttpStatus.OK);
    }
}
