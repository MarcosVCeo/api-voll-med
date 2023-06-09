package br.com.marcosceola.api.exception;

public class ApiException extends RuntimeException {

    public ApiException(String msg) {
        super((msg));
    }

    public ApiException(String msg, Exception exception) {
        super(msg, exception);
    }
}
