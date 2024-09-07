package it.uniecampus.lfulgione.tastetracking.ttbe.login.exception;

public class UserAlreadyExistException extends TTLoginException {
    public UserAlreadyExistException() {
        this(null);
    }

    public UserAlreadyExistException(Throwable cause) {
        super("User already exists", cause);
    }
}
