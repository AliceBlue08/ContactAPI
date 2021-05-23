package kz.izabella.contactapi.exception;

public class FullNameMustBeAlphabeticException extends Exception {
    public FullNameMustBeAlphabeticException(String message) {
        super(message);
    }
}
