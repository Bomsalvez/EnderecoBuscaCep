package estagio.ti.totem.vamosdnovo.config.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ResourceExcetionHandle {
    private MessageSource messageSource;

    @Autowired
    public ResourceExcetionHandle(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErrorDTO> handle(MethodArgumentNotValidException ex) {
        List<ErrorDTO> error = new ArrayList<>();
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        fieldErrors.forEach(erro -> {
            String msg = messageSource.getMessage(erro, LocaleContextHolder.getLocale());
            ErrorDTO errorDTO = new ErrorDTO(msg, erro.getField());

            error.add(errorDTO);
        });
        return error;
    }

    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFound.class)
    public ErrorDTO handle(NotFound ex) {
        return new ErrorDTO(ex.getMessage());
    }

    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ErrorDTO handle(SQLIntegrityConstraintViolationException ex) {
        return new ErrorDTO(ex.getMessage());
    }
}
