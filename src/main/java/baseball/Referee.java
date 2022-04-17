package baseball;

import baseball.support.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Referee {
    private final List<Integer> numbers = new ArrayList<>();

    public Referee(RandomNumberGenerator randomNumberGenerator) {
        numbers.addAll(randomNumberGenerator.generate());
    }

    public Result getResult(List<Integer> playerNumbers) {
        validate(playerNumbers);

        int matchNumber = getMatchNumbers(playerNumbers);
        int strike = getStrikeCount(playerNumbers);
        int ball = matchNumber - strike;

        return new Result(strike, ball);
    }

    private void validate(List<Integer> playerNumbers) {
        if (playerNumbers.size() != Const.NUMBER_COUNT) {
            throw new IllegalArgumentException("3자리의 숫자를 입력애햐 합니다.");
        }

        Set<Integer> playerNumbersSet = new HashSet<>(playerNumbers);

        if (playerNumbersSet.size() != Const.NUMBER_COUNT) {
            throw new IllegalArgumentException("서로 다른 3자리의 숫자를 입력해야 합니다.");
        }
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
