package it.uniecampus.lfulgione.tastetracking.ttbe.login.exception;

public class ProductNotFoundException extends TTLoginException {
    public ProductNotFoundException() {
        this(null);
    }

    public ProductNotFoundException(Throwable cause) {
        super("Product not found", cause);
    }
}
