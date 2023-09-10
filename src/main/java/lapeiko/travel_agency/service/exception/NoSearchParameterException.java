package lapeiko.travel_agency.service.exception;

public class NoSearchParameterException extends Exception {
    public NoSearchParameterException() {
    }

    public NoSearchParameterException(String message) {
        super(message);
    }

    public NoSearchParameterException(String message, Throwable cause) {
        super(message, cause);
    }
}