package application.root.application.config.exeptions;

import application.root.application.config.exeptions.custom.ConflictException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<Map<String, Object>> handleHttpRequestMethodNotSupportedException(
            HttpRequestMethodNotSupportedException ex) {
        Map<String, Object> response = new HashMap<>();

        response.put("status", HttpStatus.METHOD_NOT_ALLOWED.value());
        response.put("message", "Método HTTP não suportado: " + ex.getMethod());

        return new ResponseEntity<>(response, HttpStatus.METHOD_NOT_ALLOWED);
    }
}
