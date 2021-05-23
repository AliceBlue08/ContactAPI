package kz.izabella.contactapi.exception;

public class ContactItemNotFoundException extends Exception {
    public ContactItemNotFoundException(String message) {
        super(message);
    }
}