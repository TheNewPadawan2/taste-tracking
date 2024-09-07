package it.uniecampus.lfulgione.tastetracking.ttbe.login.exception;

public class PasswordNotMatchesException extends TTLoginException {
    public PasswordNotMatchesException() {
        this(null);
    }

    public PasswordNotMatchesException(Throwable cause) {
        super("The password does not match", cause);
    }
}
