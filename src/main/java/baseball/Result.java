package baseball;

import java.util.ArrayList;
import java.util.List;

public class Result {
    private final int strike;
    private final int ball;

    public Result(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public boolean isFinished() {
        return strike == 3;
    }

    public String getResultText() {
        if (this.strike == 0 && this.ball == 0) {
            return "낫싱";
        }

        return String.join(" ", getResultString());
    }

    private List<String> getResultString() {
        List<String> result = new ArrayList<>();
        if (this.getStrikeResult() != null) {
            result.add(this.getStrikeResult());
        }

        if (this.getBallResult() != null) {
            result.add(this.getBallResult());
        }

        return result;
    }

    private String getStrikeResult() {
        if (this.strike == 0) {
            return null;
        }
        
        return this.strike + "스트라이크";
    }

    private String getBallResult() {
        if (this.ball == 0) {
            return null;
        }

        return this.ball + "볼";
    }

    @Override
    public String toString() {
        return "Result{" +
                "strike=" + strike +
                ", ball=" + ball +
                '}';
    }
}
