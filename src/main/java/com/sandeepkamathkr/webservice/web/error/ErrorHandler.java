package com.sandeepkamathkr.webservice.web.error;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.NativeWebRequest;
import org.zalando.problem.Problem;
import org.zalando.problem.Status;
import org.zalando.problem.spring.web.advice.ProblemHandling;

import javax.persistence.EntityNotFoundException;

@RestControllerAdvice
public class ErrorHandler implements ProblemHandling {

    /**
     * Handle entity not found exception
     *
     * @param e       the e
     * @param request the request
     * @return the response entity
     */
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Problem> handleEntityNotFoundException(EntityNotFoundException e, NativeWebRequest request) {
        Exception newException = new Exception(e.getMessage(), e);
        return create(Status.NOT_FOUND, newException, request);
    }
}
