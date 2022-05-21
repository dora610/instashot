package link.karurisuro.instashot.utils;

import link.karurisuro.instashot.error.CustomDataNotFoundException;
import link.karurisuro.instashot.error.CustomParameterConstraintException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.PrintWriter;
import java.io.StringWriter;

@ControllerAdvice
public class CustomErrorHandler {

    private static final Logger log = LoggerFactory.getLogger(CustomErrorHandler.class);

    @ExceptionHandler(value = CustomDataNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleCustomDataNotFoundException(CustomDataNotFoundException e) {
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        log.error(e.getMessage());
        e.printStackTrace();
        return new ResponseEntity<>(new ErrorResponse(e.getMessage(), httpStatus), httpStatus);
    }


    @ExceptionHandler(value = CustomParameterConstraintException.class)
    public ResponseEntity<ErrorResponse> handleCustomParameterConstraintException(CustomParameterConstraintException e) {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        log.error(e.getMessage());
        e.printStackTrace();
        return new ResponseEntity<>(new ErrorResponse(e.getMessage(), httpStatus), httpStatus);
    }

    @ExceptionHandler(value = NullPointerException.class)
    public ResponseEntity<ErrorResponse> handleNullPointerException(NullPointerException e) {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        log.error(e.getMessage());
        e.printStackTrace();
        return new ResponseEntity<>(new ErrorResponse(e.getMessage(), httpStatus), httpStatus);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception e) {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

        // converting stack trace to string
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        e.printStackTrace(printWriter);

        String stackTrace = stringWriter.toString();
        return new ResponseEntity<>(new ErrorResponse(e.getMessage(), httpStatus, stackTrace), httpStatus);
    }
}
