package microservices.example.multiplication.controller;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import microservices.example.multiplication.domain.MultiplicationResultAttempt;
import microservices.example.multiplication.service.MultiplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/results")
public class MultiplicationResultAttemptController {

    private final MultiplicationService multiplicationService;

    @Autowired
    public MultiplicationResultAttemptController(MultiplicationService multiplicationService) {
        this.multiplicationService = multiplicationService;
    }


    @RequestMapping(method = RequestMethod.POST)
    MultiplicationResultAttempt postResult(@RequestBody MultiplicationResultAttempt multiplicationResultAttempt) {
        boolean result = multiplicationService.checkAttempt(multiplicationResultAttempt);
        return new MultiplicationResultAttempt(multiplicationResultAttempt.getUser(),
                multiplicationResultAttempt.getMultiplication(),
                multiplicationResultAttempt.getResultAttempt(),
                result);
    }

    @GetMapping
    List<MultiplicationResultAttempt> getStatistics(@RequestParam("alias") String alias) {
        return multiplicationService.getStatsForUser(alias);
    }

}
