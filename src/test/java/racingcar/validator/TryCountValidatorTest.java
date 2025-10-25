package racingcar.validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class TryCountValidatorTest {

    private TryCountValidator tryCountValidator;

    @BeforeEach
    void setUp() {
        this.tryCountValidator = new TryCountValidator();
    }

    @Test
    void 정상_입력() {

        // when
        String tryCount = "5";

        // then
        assertDoesNotThrow(() -> tryCountValidator.validate(tryCount));
    }

    @Test
    void 입력값이_0보다_작은_경우() {

        // when
        String tryCount = "0";

        // then
        assertThatThrownBy(() -> tryCountValidator.validate(tryCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 1 이상이어야 합니다.");
    }

    @Test
    void 입력값이_정수가_아닌_경우() {

        // when
        String tryCount = "car1";

        // then
        assertThatThrownBy(() -> tryCountValidator.validate(tryCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 정수여야 합니다.");
    }
}