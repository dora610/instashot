package link.karurisuro.instashot.utils;

import link.karurisuro.instashot.error.NotFoundError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomErrorHandler {

    private static final Logger log = LoggerFactory.getLogger(CustomErrorHandler.class);

    @ExceptionHandler(value = NotFoundError.class)
    public ResponseEntity<String> handleNotFoundException(NotFoundError e) {
        log.error(e.getMessage());
        e.printStackTrace();
        log.error("cause: {}", e.getCause());
        return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
