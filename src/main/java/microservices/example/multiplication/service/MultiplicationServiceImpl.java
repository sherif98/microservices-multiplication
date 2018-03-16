package microservices.example.multiplication.service;

import microservices.example.multiplication.domain.Multiplication;
import microservices.example.multiplication.domain.MultiplicationResultAttempt;
import microservices.example.multiplication.domain.User;
import microservices.example.multiplication.repository.MultiplicationResultAttemptRepository;
import microservices.example.multiplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class MultiplicationServiceImpl implements MultiplicationService {

    @Autowired
    private RandomGeneratorService randomGeneratorService;

    @Autowired
    private MultiplicationResultAttemptRepository attemptRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Multiplication createRandomMultiplication() {
        int factorA = randomGeneratorService.generateRandomFactor();
        int factorB = randomGeneratorService.generateRandomFactor();
        return new Multiplication(factorA, factorB);
    }

    @Override
    @Transactional
    public boolean checkAttempt(MultiplicationResultAttempt resultAttempt) {
        Optional<User> user = userRepository.findByAlias(resultAttempt.getUser().getAlias());

        boolean isCorrect = resultAttempt.getResultAttempt() ==
                resultAttempt.getMultiplication().getFactorA() * resultAttempt.getMultiplication().getFactorB();

        MultiplicationResultAttempt attempt =
                new MultiplicationResultAttempt(user.orElse(resultAttempt.getUser()),
                        resultAttempt.getMultiplication(),
                        resultAttempt.getResultAttempt(),
                        isCorrect);

        attemptRepository.save(attempt);
        return isCorrect;
    }

    @Override
    public List<MultiplicationResultAttempt> getStatsForUser(String userAlias) {
        return attemptRepository.findTop5ByUserAliasOrderByIdDesc(userAlias);
    }
}
