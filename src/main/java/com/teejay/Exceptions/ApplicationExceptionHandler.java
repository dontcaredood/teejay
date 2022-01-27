package com.teejay.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class ApplicationExceptionHandler {
    @ResponseStatus(
            value = HttpStatus.NOT_FOUND,
            reason = "Requested user Not Found")
    @ExceptionHandler(UserNotFoundException.class)
    public void handleException(UserNotFoundException e) {
    }

    @ResponseStatus(
            value = HttpStatus.BAD_REQUEST,
            reason = "Invalid password")
    @ExceptionHandler(IncorrectPasswordException.class)
    public void handleException(IncorrectPasswordException e) {
    }
    
    @ResponseStatus(
            value = HttpStatus.NOT_FOUND,
            reason = "Exit entry already exists for this trade id")
    @ExceptionHandler(ExitEntryAlreadyExistsException.class)
    public void handleException(ExitEntryAlreadyExistsException e) {
    }
    
    @ResponseStatus(
            value = HttpStatus.NOT_FOUND,
            reason = "No history found.")
    @ExceptionHandler(NoHistoryFoundException.class)
    public void handleException(NoHistoryFoundException e) {
    }

//    @ResponseStatus(
//            value = HttpStatus.GATEWAY_TIMEOUT,
//            reason = "Upstream Service Not Responding, Try Again")
//    @ExceptionHandler(ServiceUnavailableException.class)
//    public void handleException(ServiceUnavailableException e) {
//    }
}