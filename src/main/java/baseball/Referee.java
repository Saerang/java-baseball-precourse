package baseball;

import baseball.support.RandomNumberGenerator;
import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Referee {
    private final static int NUMBER_COUNT = 3;
    private final List<Integer> numbers = new ArrayList<>();

    public Referee(RandomNumberGenerator randomNumberGenerator) {
        numbers.addAll(randomNumberGenerator.generate());
    }

    private void init() {
        Set<Integer> numbers = new HashSet<>();
        while (numbers.size() < NUMBER_COUNT) {
            numbers.add(Randoms.pickNumberInRange(1, 9));
        }

        this.numbers.addAll(numbers);
    }

    public Result getResult(List<Integer> playerNumbers) {
        int matchNumber = getMatchNumbers(playerNumbers);
        int strike = getStrikeCount(playerNumbers);
        int ball = matchNumber - strike;

        return new Result(strike, ball);
    }

    private int getMatchNumbers(List<Integer> playerNumbers) {
        int matchNumber = 0;

        for (int playerNumber : playerNumbers) {
            matchNumber += getMatchNumber(playerNumber);
        }

        return matchNumber;
    }


    private int getMatchNumber(int playerNumber) {
        return numbers.contains(playerNumber) ? 1 : 0;
    }

    private int getStrikeCount(List<Integer> playerNumbers) {
        int strike = 0;

        for (int i = 0; i < playerNumbers.size(); i++) {
            strike += getMatchNumber(i, playerNumbers);
        }

        return strike;
    }

    private int getMatchNumber(int index, List<Integer> playerNumbers) {
        return numbers.get(index).equals(playerNumbers.get(index)) ? 1 : 0;
    }


}
