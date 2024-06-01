package it.uniecampus.lfulgione.tastetracking.ttbe.login.service;

import it.uniecampus.lfulgione.tastetracking.ttbe.login.dto.LoginRequestDTO;
import it.uniecampus.lfulgione.tastetracking.ttbe.login.dto.LoginResponseDTO;
import it.uniecampus.lfulgione.tastetracking.ttbe.login.dto.SignupRequestDTO;

public interface LoginService {
    void signup(SignupRequestDTO signupRequestDTO);
    LoginResponseDTO login(LoginRequestDTO loginRequestDTO);
}
