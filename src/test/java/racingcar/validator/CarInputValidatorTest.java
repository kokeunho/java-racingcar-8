package racingcar.validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CarInputValidatorTest {

    private CarInputValidator carInputValidator;

    @BeforeEach
    void setUp() {
        carInputValidator = new CarInputValidator();
    }

    @Test
    void 정상_입력() {

        // when
        String input = "car1,car2,car3,car4";

        // then
        assertDoesNotThrow(() -> carInputValidator.validate(input));
    }

    @Test
    void 차량수_조건() {

        // when
        String input1 = "";
        String input2 = "car1";

        // then
        assertThatThrownBy(() -> carInputValidator.validate(input1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("차량은 2대 이상이어야 합니다.");
        assertThatThrownBy(() -> carInputValidator.validate(input2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("차량은 2대 이상이어야 합니다.");
    }

    // 글자수가 1~5글자여야 함
    @Test
    void 글자수_조건() {

        // when
        String input1 = "car1,,car3,car4";
        String input2 = "carcar1,car2,car3,car4";

        // then
        assertThatThrownBy(() -> carInputValidator.validate(input1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("차량명은 최소 1글자 최대 5글자여야 합니다.");
        assertThatThrownBy(() -> carInputValidator.validate(input2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("차량명은 최소 1글자 최대 5글자여야 합니다.");
    }
}