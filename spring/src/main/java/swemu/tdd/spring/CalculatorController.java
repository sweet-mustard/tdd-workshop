package swemu.tdd.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private static final Logger logger = LoggerFactory.getLogger(CalculatorController.class);

    @PostMapping("/add")
    public ResponseEntity<Result> add(@RequestBody Operands operands) {
        logger.info("Adding {}", operands);
        return ResponseEntity.ok(new Result(0.0));
    }
}
