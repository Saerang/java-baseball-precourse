package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Player {
    private final List<Integer> playerNumbers = new ArrayList<>();

    public Player(String playerNumbers) {
        for (String playerNumber : playerNumbers.split("")) {
            this.playerNumbers.add(Integer.parseInt(playerNumber));
        }

        validate(this.playerNumbers);
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

    public List<Integer> getPlayerNumbers() {
        return playerNumbers;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerNumbers=" + playerNumbers +
                '}';
    }
}
