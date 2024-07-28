package it.uniecampus.lfulgione.tastetracking.ttbe.login.service.impl;

import it.uniecampus.lfulgione.tastetracking.ttbe.login.dto.LoginRequestDTO;
import it.uniecampus.lfulgione.tastetracking.ttbe.login.dto.LoginResponseDTO;
import it.uniecampus.lfulgione.tastetracking.ttbe.login.dto.SignupRequestDTO;
import it.uniecampus.lfulgione.tastetracking.ttbe.login.mapper.UserMapper;
import it.uniecampus.lfulgione.tastetracking.ttbe.login.repository.UserRepository;
import it.uniecampus.lfulgione.tastetracking.ttbe.login.service.LoginService;
import it.uniecampus.lfulgione.tastetracking.ttbe.login.service.PasswordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LoginServiceImpl implements LoginService {
    private final PasswordService passwordService;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public LoginServiceImpl(
            PasswordService passwordService,
            UserRepository userRepository,
            UserMapper userMapper) {
        this.passwordService = passwordService;
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public void signup(SignupRequestDTO signupRequestDTO) {
        log.info("START signUp");
        long ts = System.currentTimeMillis();
        signupRequestDTO.setPassword(passwordService.encode(signupRequestDTO.getPassword()));
        userRepository.save(userMapper.entity(signupRequestDTO));
        log.info("END signUp - executed in {}", System.currentTimeMillis() - ts);
    }

    @Override
    public LoginResponseDTO login(LoginRequestDTO loginRequestDTO) {
        //TODO
        throw new RuntimeException("Not implemented yet");
    }
}
