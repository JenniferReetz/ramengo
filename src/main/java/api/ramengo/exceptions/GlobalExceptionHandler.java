package api.ramengo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFound(ResourceNotFoundException ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("error", "Resource Not Found");
        body.put("message", ex.getMessage());
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidOrderException.class)
    public ResponseEntity<Object> handleInvalidOrder(InvalidOrderException ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("error", "Invalid Order");
        body.put("message", ex.getMessage());
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InternalServerException.class)
    public ResponseEntity<Object> handleInternalServerError(InternalServerException ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("error", "Internal Server Error");
        body.put("message", ex.getMessage());
        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}