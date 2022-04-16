package nextstep.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomsTest {

    @RepeatedTest(50)
    void 난수_범위_테스트() {
        int randomNumber = Randoms.pickNumberInRange(1, 9);

        assertThat(randomNumber).isBetween(1, 9);
    }

    @Test
    void 난수_범위가_벗어날_때() {
        Assertions.assertThatThrownBy(() -> Randoms.pickNumberInRange(2, 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("startInclusive가 endInclusive보다 클 수 없습니다.");
    }

}