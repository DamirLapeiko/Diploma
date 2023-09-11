package lapeiko.travel_agency.controller;

import lapeiko.travel_agency.service.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AuthorizationServiceException;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ErrorControllerAdvice {

    @ExceptionHandler(BusinessException.class)
    public ErrorResponse onBusinessException(BusinessException e) {
        log.warn("Business error: {}", e.toString());
        return ErrorResponse.create(e, HttpStatus.BAD_REQUEST, e.getMessage());
    }
    @ExceptionHandler(AuthorizationServiceException.class)
    public ErrorResponse onAuthorizationException(AuthorizationServiceException e) {
        log.warn("Authorization error: {}", e.toString());
        return ErrorResponse.create(e, HttpStatus.FORBIDDEN, "No required authority");
    }
    @ExceptionHandler(Exception.class)
    public ErrorResponse onException(Exception e) {
        log.error("Unknown error: {}", e.toString());
        return ErrorResponse.create(e, HttpStatus.BAD_REQUEST, "Unknown error");
    }
}
