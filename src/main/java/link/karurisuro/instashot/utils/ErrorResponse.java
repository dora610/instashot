package link.karurisuro.instashot.utils;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class ErrorResponse {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;
    private int code;
    private String message;
    private String status;
    private String stackTrace;
    private Object data;

    public ErrorResponse() {
        this.timestamp = LocalDateTime.now();
    }

    public ErrorResponse(String message, HttpStatus httpStatus) {
        this();
        this.message = message;
        this.status = httpStatus.toString();
        this.code = httpStatus.value();
    }

    public ErrorResponse(String message, HttpStatus httpStatus,  String stackTrace) {
        this(message, httpStatus);
        this.stackTrace = stackTrace;
    }

    public ErrorResponse(String message, HttpStatus httpStatus,  String stackTrace, Object data) {
        this(message, httpStatus, stackTrace);
        this.data = data;
    }
}
