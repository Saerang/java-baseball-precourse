package baseball;

import baseball.support.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class TestRandomNumberGenerator implements RandomNumberGenerator {
    private List<Integer> numbers = new ArrayList<>();

    public TestRandomNumberGenerator(List<Integer> numbers) {
        this.numbers.addAll(numbers);
    }

    @Override
    public List<Integer> generate() {
        return this.numbers;
    }
}
