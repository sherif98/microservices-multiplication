package microservices.example.multiplication.repository;

import microservices.example.multiplication.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByAlias(String userAlias);
}
