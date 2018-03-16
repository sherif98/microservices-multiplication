package microservices.example.multiplication.repository;

import microservices.example.multiplication.domain.Multiplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MultiplicationRepository extends JpaRepository<Multiplication, Long> {


}
