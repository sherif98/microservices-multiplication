package microservices.example.multiplication.controller;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import microservices.example.multiplication.domain.MultiplicationResultAttempt;
import microservices.example.multiplication.service.MultiplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/results")
public class MultiplicationResultAttemptController {

    private final MultiplicationService multiplicationService;

    @Autowired
    public MultiplicationResultAttemptController(MultiplicationService multiplicationService) {
        this.multiplicationService = multiplicationService;
    }


    @RequestMapping(method = RequestMethod.POST)
    ResultResponse postResult(@RequestBody MultiplicationResultAttempt multiplicationResultAttempt) {
        return new ResultResponse(multiplicationService.checkAttempt(multiplicationResultAttempt));
    }

    @RequiredArgsConstructor
    @NoArgsConstructor(force = true)
    @Getter
    private static final class ResultResponse {
        private final boolean correct;
    }
}
