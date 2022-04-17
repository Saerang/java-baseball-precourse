package baseball.support;

import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static baseball.Const.NUMBER_COUNT;

public class DefaultRandomNumberGenerator implements RandomNumberGenerator {

    @Override
    public List<Integer> generate() {
        Set<Integer> numbers = new HashSet<>();
        while(numbers.size() < NUMBER_COUNT) {
            numbers.add(Randoms.pickNumberInRange(1, 9));
        }

        return new ArrayList<>(numbers);
    }

}
