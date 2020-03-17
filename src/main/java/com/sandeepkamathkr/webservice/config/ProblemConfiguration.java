package com.sandeepkamathkr.webservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.zalando.problem.ProblemModule;
import org.zalando.problem.validation.ConstraintViolationProblemModule;

@Configuration
public class ProblemConfiguration {

    /**
     * Module for serialization/deserialization of RFC7807 Problem.
     *
     * @return the problem module
     */
    @Bean
    ProblemModule problemModule() {
        return new ProblemModule();
    }

    /**
     * Module for serialization/deserialization of ConstraintViolationProblem.
     *
     * @return the constraint violation problem module
     */
    @Bean
    ConstraintViolationProblemModule constraintViolationProblemModule() {
        return new ConstraintViolationProblemModule();
    }
}
