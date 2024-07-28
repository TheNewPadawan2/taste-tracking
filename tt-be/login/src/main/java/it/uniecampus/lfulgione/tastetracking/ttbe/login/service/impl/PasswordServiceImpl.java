package it.uniecampus.lfulgione.tastetracking.ttbe.login.service.impl;

import it.uniecampus.lfulgione.tastetracking.ttbe.login.service.PasswordService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Getter
@Slf4j
public class PasswordServiceImpl implements PasswordService {
    private final PasswordEncoder passwordEncoder;
    private final String pepper;

    @Autowired
    public PasswordServiceImpl(
            PasswordEncoder passwordEncoder,
            @Value("${application.security.pepper}") String pepper) {
        this.passwordEncoder = passwordEncoder;
        this.pepper = pepper;
    }

    @Override
    public String encode(String rawPassword) {
        String encodedPassword = passwordEncoder.encode(rawPassword + pepper);
        log.debug("encoded {} --> {}", rawPassword, encodedPassword);
        return encodedPassword;
    }

    @Override
    public boolean matches(String rawPassword, String encodedPassword) {
        boolean matches = passwordEncoder.matches(
                rawPassword + pepper,
                encodedPassword);
        log.debug("password {} " + (matches ? "matches" : "doesn't match") + " with {}",
                rawPassword,
                encodedPassword);
        return matches;
    }
}
