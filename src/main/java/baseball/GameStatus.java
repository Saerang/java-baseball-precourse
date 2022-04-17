package baseball;

public enum GameStatus {
    PROGRESS("1"),
    END("2");

    private final String status;

    GameStatus(String status) {
        this.status = status;
    }

    public static boolean isEndGame(String status) {
        return END.status.equals(status);
    }

    public static boolean isGameReset(String status) {
        return PROGRESS.status.equals(status);
    }
}
