package link.karurisuro.instashot.error;

import org.springframework.http.HttpStatus;

public class CustomErrorException extends Exception {
    private HttpStatus status;
    private Object data;

    public CustomErrorException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public CustomErrorException(String message, HttpStatus status, Object data) {
        super(message);
        this.status = status;
        this.data = data;
    }

    public CustomErrorException() {
    }
}
