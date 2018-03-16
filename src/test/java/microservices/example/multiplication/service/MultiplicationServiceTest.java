package microservices.example.multiplication.service;


import microservices.example.multiplication.domain.Multiplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MultiplicationServiceTest {

    @MockBean
    private RandomGeneratorService randomGeneratorService;
    @Autowired
    private MultiplicationService multiplicationService;


    @Test
    public void createRandomMultiplicationTest() {
        BDDMockito.given(randomGeneratorService.generateRandomFactor())
                .willReturn(10, 20);

        Multiplication randomMultiplication = multiplicationService.createRandomMultiplication();

        assertThat(randomMultiplication.getFactorA()).isEqualTo(10);
        assertThat(randomMultiplication.getFactorB()).isEqualTo(20);
        assertThat(randomMultiplication.getResult()).isEqualTo(200);
    }
}
