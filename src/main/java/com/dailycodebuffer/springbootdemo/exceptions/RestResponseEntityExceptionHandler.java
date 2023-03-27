package com.dailycodebuffer.springbootdemo.exceptions;

import com.dailycodebuffer.springbootdemo.exceptions.backend.ProductsNotFoundException;
import com.dailycodebuffer.springbootdemo.exceptions.customers.CustomerNotFoundException;
import com.dailycodebuffer.springbootdemo.exceptions.employees.EmployeeNotFoundException;
import com.dailycodebuffer.springbootdemo.exceptions.students.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler
        extends ResponseEntityExceptionHandler {


    @ExceptionHandler(EmployeeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorMessage EmployeeNotFoundHandler(EmployeeNotFoundException ex) {
        return new ErrorMessage(
                HttpStatus.NOT_FOUND,
                ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage genericException(Exception exception) {
        return new ErrorMessage(
                HttpStatus.INTERNAL_SERVER_ERROR,
                exception.getMessage()
        );
    }


    @ExceptionHandler(StudentNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage studentNotFoundExceptionHandler(StudentNotFoundException exception) {
        return new ErrorMessage(
                HttpStatus.NOT_FOUND,
                exception.getMessage()
        );
    }

    @ExceptionHandler(CustomerNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage customerNotFoundExceptionHandler(CustomerNotFoundException cx){
        return new ErrorMessage(
                HttpStatus.NOT_FOUND,
                cx.getMessage());
    }


    // TODO: this is for content negotiation
    @ExceptionHandler(ContentMismatchException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public ErrorMessage customNegotiationExceptionHandler(ContentMismatchException cm){
        return new ErrorMessage(
                HttpStatus.NOT_ACCEPTABLE,
                cm.getMessage()
        );
    }


    @ExceptionHandler(ProductsNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage handleProductsNotFoundException(ProductsNotFoundException pe){
        return new ErrorMessage(
                HttpStatus.NOT_FOUND,
                pe.getMessage()
        );
    }
}
