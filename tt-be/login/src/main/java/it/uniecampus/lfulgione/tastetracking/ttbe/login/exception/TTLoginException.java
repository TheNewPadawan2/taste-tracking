package it.uniecampus.lfulgione.tastetracking.ttbe.login.exception;

public abstract class TTLoginException extends Exception {
    public TTLoginException(String message) {
        super(message);
    }

    public TTLoginException(String message, Throwable cause) {
        super(message, cause);
    }
}
