package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerTest {

    @Test
    void 적은_숫자를_입력한_경우() {
        assertThatThrownBy(() -> new Player("12"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("3자리의 숫자를 입력애햐 합니다.");
    }

    @Test
    void 같은_숫자를_입력한_경우() {
        assertThatThrownBy(() -> new Player("111"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("서로 다른 3자리의 숫자를 입력해야 합니다.");
    }

}
