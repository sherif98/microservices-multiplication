package microservices.example.multiplication.service;

import microservices.example.multiplication.domain.Multiplication;
import microservices.example.multiplication.domain.MultiplicationResultAttempt;

public interface MultiplicationService {

    Multiplication createRandomMultiplication();

    boolean checkAttempt(MultiplicationResultAttempt resultAttempt);
}