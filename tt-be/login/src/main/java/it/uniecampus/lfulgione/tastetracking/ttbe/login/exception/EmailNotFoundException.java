package it.uniecampus.lfulgione.tastetracking.ttbe.login.exception;

public class EmailNotFoundException extends TTLoginException {
    public EmailNotFoundException() {
        this(null);
    }

    public EmailNotFoundException(Throwable cause) {
        super("Email not found", cause);
    }
}
