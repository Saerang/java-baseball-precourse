package baseball;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;


class RefereeTest {


    private static Stream<Arguments> provideMatchTestData() { // argument source method
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3), "123", 3, 0),
                Arguments.of(Arrays.asList(1, 2, 3), "125", 2, 1),
                Arguments.of(Arrays.asList(1, 2, 3), "123", 3, 0)
                        );
    }

    @Test
    void 정답을_전부_맞출경우() {
        Referee referee = new Referee(new TestRandomNumberGenerator(Arrays.asList(1, 2, 3)));

        Result result = referee.getResult(Arrays.asList(1, 2, 3));

        assertThat(result.getResultText()).isEqualTo("3스트라이크");
    }

    @Test
    void 정답을_전부_틀릴경우() {
        Referee referee = new Referee(new TestRandomNumberGenerator(Arrays.asList(1, 2, 3)));

        Result result = referee.getResult(Arrays.asList(4, 5, 6));

        assertThat(result.getResultText()).isEqualTo("낫싱");
    }

    @ParameterizedTest
    @MethodSource(value = "providePartialFitCase")
    void 정답을_일부분_맞출경우(List<Integer> randomNumbers, List<Integer> playerNumbers, String resultText) {
        Referee referee = new Referee(new TestRandomNumberGenerator(randomNumbers));

        Result result = referee.getResult(playerNumbers);

        assertThat(result.getResultText()).isEqualTo(resultText);
    }

    private static Stream<Arguments> providePartialFitCase() {
        return Stream.of(
                Arguments.of(Arrays.asList(1,2,3), Arrays.asList(1,2,4), "2스트라이크"),
                Arguments.of(Arrays.asList(1,2,3), Arrays.asList(3,1,2), "3볼"),
                Arguments.of(Arrays.asList(1,2,3), Arrays.asList(1,3,2), "1스트라이크 2볼")
                        );
    }


}
