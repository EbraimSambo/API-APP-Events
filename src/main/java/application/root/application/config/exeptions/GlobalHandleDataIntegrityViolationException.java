package application.root.application.config.exeptions;

import application.root.application.config.exeptions.custom.ConflictException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalHandleDataIntegrityViolationException {
    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<Map<String, Object>> handleConflict(ConflictException ex) {
        Map<String, Object> response = new HashMap<>();

        response.put("success", false);
        response.put("status", HttpStatus.CONFLICT.value());
        response.put("message", "Erro de integridade de dados: " + ex.getMessage());

        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }
}
