package microservices.example.multiplication.service;

import microservices.example.multiplication.domain.Multiplication;
import microservices.example.multiplication.domain.MultiplicationResultAttempt;

import java.util.List;

public interface MultiplicationService {

    Multiplication createRandomMultiplication();

    boolean checkAttempt(MultiplicationResultAttempt resultAttempt);

    List<MultiplicationResultAttempt> getStatsForUser(String userAlias);
}