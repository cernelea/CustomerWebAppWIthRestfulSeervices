package com.cernelea.rest.exceptionHandling;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<CustomerResponseError> handlingCustomerNotFound(CustomerNotFoundException ex) {
        CustomerResponseError customerResponseError = new CustomerResponseError();
        customerResponseError.setMessage(ex.getMessage());
        customerResponseError.setStatus(HttpStatus.NOT_FOUND.value());
        customerResponseError.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(customerResponseError, HttpStatus.NOT_FOUND);


    }

    @ExceptionHandler
    public ResponseEntity<CustomerResponseError> handleExceptions(Exception ex) {

        CustomerResponseError customerResponseError = new CustomerResponseError();
        customerResponseError.setMessage(ex.getMessage());
        customerResponseError.setStatus(HttpStatus.BAD_REQUEST.value());
        customerResponseError.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(customerResponseError, HttpStatus.BAD_REQUEST);


    }


}
