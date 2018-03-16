package microservices.example.multiplication.repository;

import microservices.example.multiplication.domain.MultiplicationResultAttempt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MultiplicationResultAttemptRepository extends JpaRepository<MultiplicationResultAttempt, Long> {

    List<MultiplicationResultAttempt> findTop5ByUserAliasOrderByIdDesc(String userAlias);
}