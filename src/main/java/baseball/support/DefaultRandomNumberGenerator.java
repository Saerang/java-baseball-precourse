package baseball.support;

import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.Const.NUMBER_COUNT;

public class DefaultRandomNumberGenerator implements RandomNumberGenerator {
    private final List<Integer> numbers = new ArrayList<>();

    @Override
    public List<Integer> generate() {
        while(numbers.size() < NUMBER_COUNT) {
            addNumber();
        }

        return numbers;
    }

    private void addNumber() {
        int number = Randoms.pickNumberInRange(1, 9);

        if(numbers.contains(number)) {
            return;
        }

        numbers.add(number);
    }

}
