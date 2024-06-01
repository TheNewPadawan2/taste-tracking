package it.uniecampus.lfulgione.tastetracking.ttbe.login.controller;

import it.uniecampus.lfulgione.tastetracking.ttbe.login.dto.LoginRequestDTO;
import it.uniecampus.lfulgione.tastetracking.ttbe.login.dto.LoginResponseDTO;
import it.uniecampus.lfulgione.tastetracking.ttbe.login.dto.SignupRequestDTO;
import it.uniecampus.lfulgione.tastetracking.ttbe.login.exception.EmailNotFoundException;
import it.uniecampus.lfulgione.tastetracking.ttbe.login.exception.PasswordNotMatchesException;
import it.uniecampus.lfulgione.tastetracking.ttbe.login.exception.UserAlreadyExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/login")
public interface LoginController {
    @PostMapping(path = "/signup")
    ResponseEntity<Void> signup(
            @RequestBody SignupRequestDTO signup)
            throws UserAlreadyExistException;

    @PostMapping(path = "/login")
    ResponseEntity<LoginResponseDTO> login(
            @RequestBody LoginRequestDTO login)
            throws EmailNotFoundException, PasswordNotMatchesException;
}
