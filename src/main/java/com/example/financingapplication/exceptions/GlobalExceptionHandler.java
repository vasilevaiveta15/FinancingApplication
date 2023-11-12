package com.example.financingapplication.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.web.csrf.InvalidCsrfTokenException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.naming.AuthenticationException;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler
{
  @ExceptionHandler(InvalidException.class)
  public ResponseEntity<String> handlerInvalidException(InvalidException ex)
  {
    return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(PasswordException.class)
  public ResponseEntity<String> handlerPasswordException(PasswordException ex)
  {
    return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
  }


//  @ExceptionHandler(AuthenticationEntryPoint.class)
//  @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
//  @ResponseBody
//  public ResponseEntity<String> handleAuthenticationException(Exception ex)
//  {
//    return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
//  }
}
