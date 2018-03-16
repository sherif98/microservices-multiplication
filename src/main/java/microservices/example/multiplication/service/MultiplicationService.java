package microservices.example.multiplication.service;

import microservices.example.multiplication.domain.Multiplication;

public interface MultiplicationService {

    Multiplication createRandomMultiplication();
}