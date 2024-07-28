package it.uniecampus.lfulgione.tastetracking.ttbe.login.service.impl;

import it.uniecampus.lfulgione.tastetracking.ttbe.login.dto.LoginRequestDTO;
import it.uniecampus.lfulgione.tastetracking.ttbe.login.dto.LoginResponseDTO;
import it.uniecampus.lfulgione.tastetracking.ttbe.login.dto.SignupRequestDTO;
import it.uniecampus.lfulgione.tastetracking.ttbe.login.entity.UserEntity;
import it.uniecampus.lfulgione.tastetracking.ttbe.login.exception.EmailNotFoundException;
import it.uniecampus.lfulgione.tastetracking.ttbe.login.exception.PasswordNotMatchesException;
import it.uniecampus.lfulgione.tastetracking.ttbe.login.mapper.UserMapper;
import it.uniecampus.lfulgione.tastetracking.ttbe.login.repository.UserRepository;
import it.uniecampus.lfulgione.tastetracking.ttbe.login.service.LoginService;
import it.uniecampus.lfulgione.tastetracking.ttbe.login.service.PasswordService;
import jakarta.validation.constraints.Email;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
    public LoginResponseDTO login(LoginRequestDTO loginRequestDTO) throws EmailNotFoundException, PasswordNotMatchesException {
        Optional<UserEntity> userOpt = userRepository.findByEmail(loginRequestDTO.getEmail());
        if (userOpt.isEmpty()) {
            log.debug("No user found for email: {}", loginRequestDTO.getEmail());
            log.error("User not found");
            throw new EmailNotFoundException();
        }
        LoginResponseDTO responseDTO = userMapper.loginResponseDTO(userOpt.get());
        if (!passwordService.matches(loginRequestDTO.getPassword(), userOpt.get().getPassword())) {
            log.error("Password doesn't matches");
            throw new PasswordNotMatchesException();
        }
        return responseDTO;
    }
}
