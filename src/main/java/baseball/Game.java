package baseball;

import baseball.support.DefaultRandomNumberGenerator;
import nextstep.utils.Console;

public class Game {

    void start() {
        Referee referee = new Referee(new DefaultRandomNumberGenerator());
        boolean isInProgress = true;

        while (isInProgress) {
            isInProgress = gameProgress(referee);
        }
        this.gameEndAfter();
    }

    private boolean gameProgress(Referee referee) {
        System.out.print("숫자를 입력해주세요: ");
        String playerNumbers = Console.readLine();
        Player player = new Player(playerNumbers);

        Result result = referee.getResult(player.getPlayerNumbers());
        System.out.println(result.getResultText());

        if (result.isFinished()) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
            return false;
        }

        return true;
    }

    public void gameEndAfter() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String gameStatus = Console.readLine();

        if (GameStatus.isGameReset(gameStatus)) {
            this.start();
        }

        if (GameStatus.isEndGame(gameStatus)) {
            return;
        }

        System.out.println("잘못 입력하였습니다.");
    }
}
