package baseball;

import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Referee {
    private final static int NUMBER_COUNT = 3;
    private List<Integer> numbers = new ArrayList<>();

    public Referee() {
        this.init();
    }

    private void init() {
        Set<Integer> numbers = new HashSet<>();
        while(numbers.size() < NUMBER_COUNT) {
            numbers.add(Randoms.pickNumberInRange(1, 9));
        }

        this.numbers.addAll(numbers);
    }

}
