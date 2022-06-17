package swemu.tdd.spring.calculator;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FakeCalculator implements Calculator {
    @Override
    public Double add(List<Double> operands) {
        return 12.5;
    }
}
