package it.uniecampus.lfulgione.tastetracking.ttbe.login.controller.impl;

import it.uniecampus.lfulgione.tastetracking.ttbe.login.controller.LoginController;
import it.uniecampus.lfulgione.tastetracking.ttbe.login.dto.LoginRequestDTO;
import it.uniecampus.lfulgione.tastetracking.ttbe.login.dto.LoginResponseDTO;
import it.uniecampus.lfulgione.tastetracking.ttbe.login.dto.SignupRequestDTO;
import it.uniecampus.lfulgione.tastetracking.ttbe.login.exception.EmailNotFoundException;
import it.uniecampus.lfulgione.tastetracking.ttbe.login.exception.PasswordNotMatchesException;
import it.uniecampus.lfulgione.tastetracking.ttbe.login.exception.UserAlreadyExistException;
import it.uniecampus.lfulgione.tastetracking.ttbe.login.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class LoginControllerImpl implements LoginController {
	private final LoginService loginService;
	
	@Autowired
	public LoginControllerImpl(LoginService loginService) {
		this.loginService = loginService;
	}
	
	@Override
	public ResponseEntity<Void> signup(
			SignupRequestDTO signup)
			throws UserAlreadyExistException {
		loginService.signup(signup);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@Override
	public ResponseEntity<LoginResponseDTO> login(
			LoginRequestDTO login)
			throws EmailNotFoundException, PasswordNotMatchesException {
		LoginResponseDTO payload = loginService.login(login);
		return new ResponseEntity<>(payload, HttpStatus.OK);
	}
}
