package microservices.example.multiplication.controller;


import microservices.example.multiplication.domain.Multiplication;
import microservices.example.multiplication.service.MultiplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/multiplications")
public class MultiplicationController {

    private final MultiplicationService multiplicationService;

    @Autowired
    public MultiplicationController(MultiplicationService multiplicationService) {
        this.multiplicationService = multiplicationService;
    }

    @RequestMapping(value = "/random", method = RequestMethod.GET)
    Multiplication getRandomMultiplication() {
        return multiplicationService.createRandomMultiplication();
    }


}
