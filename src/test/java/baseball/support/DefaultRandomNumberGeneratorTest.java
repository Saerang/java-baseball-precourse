package baseball.support;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class DefaultRandomNumberGeneratorTest {
    @Test
    void 난수_생성() {
        RandomNumberGenerator randomNumberGenerator = new DefaultRandomNumberGenerator();

        List<Integer> randomNumbers = randomNumberGenerator.generate();

        assertThat(randomNumbers).hasSize(3);
        for (Integer randomNumber : randomNumbers) {
            assertThat(randomNumber).isBetween(1, 9);
        }
    }
}
