package racingcar.validator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoveCountValidatorTest {

    @Test
    void 정상_입력() {

        // given
        TryCountValidator tryCountValidator = new TryCountValidator();

        // when
        String tryCount = "5";

        // then
        assertDoesNotThrow(() -> tryCountValidator.validate(tryCount));
    }

    @Test
    void 비정상_입력() {

        // given
        TryCountValidator tryCountValidator = new TryCountValidator();

        // when
        String tryCount1 = "0";

        // then
        Assertions.assertThatThrownBy(() -> tryCountValidator.validate(tryCount1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이동 횟수는 1 이상이어야 합니다.");
    }
}