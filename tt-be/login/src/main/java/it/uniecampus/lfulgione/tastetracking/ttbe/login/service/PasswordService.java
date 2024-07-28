package it.uniecampus.lfulgione.tastetracking.ttbe.login.service;

public interface PasswordService {
    String encode(String rawPassword);
    boolean matches(String rawPassword, String encodedPassword);
}
