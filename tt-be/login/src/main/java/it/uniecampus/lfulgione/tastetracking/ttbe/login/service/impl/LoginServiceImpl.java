package it.uniecampus.lfulgione.tastetracking.ttbe.login.service.impl;

import it.uniecampus.lfulgione.tastetracking.ttbe.login.dto.LoginRequestDTO;
import it.uniecampus.lfulgione.tastetracking.ttbe.login.dto.LoginResponseDTO;
import it.uniecampus.lfulgione.tastetracking.ttbe.login.dto.SignupRequestDTO;
import it.uniecampus.lfulgione.tastetracking.ttbe.login.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LoginServiceImpl implements LoginService {
    @Override
    public void signup(SignupRequestDTO signupRequestDTO) {
        //TODO
        throw new RuntimeException("Not implemented yet");
    }

    @Override
    public LoginResponseDTO login(LoginRequestDTO loginRequestDTO) {
        //TODO
        throw new RuntimeException("Not implemented yet");
    }
}
